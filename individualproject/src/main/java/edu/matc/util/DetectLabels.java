package edu.matc.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.IOUtils;
import org.apache.log4j.Logger;

/**
 * This class uses Amazon Rekognition to add functionality to read
 * a photo and detect labels the photo relates to.
 */
public class DetectLabels {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * Takes a the photo name, finds the photo in an Amazon s3 bucket and checks
     * whether or not the photo is related to food.
     * @param photo
     * @return
     */
    public boolean detectLabelWithA3Object(String photo) {

        String bucket = "food-pictures";
        boolean isFood = false;

        AWSCredentials credentials;

        try {
            credentials = new BasicAWSCredentials("", "");
        } catch (Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Usersuserid.aws/credentials), and is in a valid format.", e);
        }

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(photo).withBucket(bucket)))
                .withMaxLabels(10)
                .withMinConfidence(75F);

        try {
            DetectLabelsResult result = rekognitionClient.detectLabels(request);
            List <Label> labels = result.getLabels();

            for (Label label: labels) {
                logger.info(label);
                if (label.getName().equals("Food") && label.getConfidence() > 60) {
                    isFood = true;
                }
            }
        } catch(AmazonRekognitionException e) {
            e.printStackTrace();
        }

        return isFood;
    }




}

