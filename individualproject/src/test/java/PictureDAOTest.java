import edu.matc.entity.Picture;
import edu.matc.persistence.PictureDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PictureDAOTest {

    PictureDAO pictureDAO;
    int initialNumberOfPictures;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        pictureDAO = new PictureDAO();
        initialNumberOfPictures = pictureDAO.getAllPictures().size();

    }

    @Test
    public void addPictureTest() {
        Picture picture = new Picture("newpicture.jpg", 2, "username");
        int pictureID = pictureDAO.addPicture(picture);
        assertEquals(3, pictureID);

    }


}
