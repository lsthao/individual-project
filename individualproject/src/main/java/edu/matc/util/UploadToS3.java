package edu.matc.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * This class uses Amazon S3 to perform functionality to upload images to an Amazon S3 bucket.
 */
public class UploadToS3 {

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This function adds a photo to my Amazon S3 bucket for this project.
     *
     * @param photo
     * @return
     */
    public void uploadFile(String photo) {

        String clientRegion = "us-east-2";
        String bucketName = "food-pictures";
        String stringObjKeyName = getPhotoNameString(photo);
        String fileObjKeyName = getPhotoNameString(photo);
        String fileName = photo;

        BasicAWSCredentials credentials;
        try {
            credentials = new BasicAWSCredentials("", "");
        } catch (Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Usersuserid.aws/credentials), and is in a valid format.", e);
        }


        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(clientRegion)
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .build();

            // Upload a text string as a new object.
            s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpeg");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            s3Client.putObject(request);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }

    }


    /**
     * This function takes the full photo path and returns just the photo file name.
     *
     * @param fullPhotoPath
     * @return
     */
    public String getPhotoNameString(String fullPhotoPath) {
        int index_one = fullPhotoPath.lastIndexOf("/");
        String photoFileName = fullPhotoPath.substring(index_one +1, fullPhotoPath.length());
        logger.info(photoFileName);
        return photoFileName;
    }


}
