import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.PictureDAO;
import edu.matc.persistence.RestaurantDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PictureDAOTest {

    PictureDAO pictureDAO;
    int initialNumberOfPictures;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        pictureDAO = new PictureDAO();
        initialNumberOfPictures = pictureDAO.getAllPictures().size();

    }

    @Test
    public void addTest() {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);

        Picture picture = new Picture("newwwpicture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = pictureDAO.addPicture(picture);

        Picture insertedPicture = pictureDAO.getPictureByID(id);
        assertEquals("newwwpicture.jpg", insertedPicture.getPicture());
        assertEquals(restaurant.getName(), insertedPicture.getRestaurant().getName());
        assertEquals(2,insertedPicture.getUserID());


    }

    @Test
    public void getAllPicturesTest() {
        List<Picture> picturesList = pictureDAO.getAllPictures();
        assertNotNull(picturesList);
        assertEquals(initialNumberOfPictures, picturesList.size());

    }

    @Test
    public void deletePictureTest() {
        Picture picture = pictureDAO.getPictureByID(3);
        pictureDAO.delete(picture);
        assertNull(pictureDAO.getPictureByID(3));


    }

    @Test
    public void updatePictureTest() {

        String newPictureName = "updated-picture.png";
        Picture picture = pictureDAO.getPictureByID(2);
        picture.setPicture(newPictureName);
        picture.setUserID(1);

        pictureDAO.updatePicture(picture);

        Picture updatedPicture = pictureDAO.getPictureByID(2);

        assertEquals(newPictureName, updatedPicture.getPicture());
        assertEquals(1, updatedPicture.getUserID());

    }

    @Test
    public void getPictureByID() {
        Picture picture = pictureDAO.getPictureByID(1);
        assertNotNull(picture);
        assertEquals("picture1.jpg", picture.getPicture());


    }




}
