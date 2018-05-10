import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
import edu.matc.util.DetectLabels;
import edu.matc.util.UploadToS3;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class APITest {

    private Logger log = Logger.getLogger(this.getClass());
    DetectLabels detectLabels = new DetectLabels();

    @Before
    public void setup() {

    }


    @Test
    public void detectLabelsWithS3ObjectTest() throws java.lang.Exception {
        String falsePhotoName = "chinese.jpg";
        assertTrue(detectLabels.detectLabelWithA3Object(falsePhotoName));
    }


    @Test
    public void uploadPhotoToS3() {
        String photoPath = "/home/student/chinese.jpg";

        UploadToS3 upload = new UploadToS3();
        upload.uploadFile(photoPath);
    }

    @Test
    public void extractPhotoNameTest() {
        String photoPath="/home/student/chinese.jpg";
        UploadToS3 s3 = new UploadToS3();

        assertEquals("chinese.jpg",s3.getPhotoNameString(photoPath));
    }

    @Test
    public void detectLabelsWithExtractedPhotoName() {
        String photoPath="/home/student/pizza.jpg";

        UploadToS3 upload = new UploadToS3();
        upload.uploadFile(photoPath);
        String photoName = upload.getPhotoNameString(photoPath);

        assertTrue(detectLabels.detectLabelWithA3Object(photoName));
    }


}
