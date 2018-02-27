import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.PictureDAO;
import edu.matc.persistence.RestaurantDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void addTest() {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);

        Picture picture = new Picture("newpicture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = pictureDAO.addPicture(picture);


    }

    @Test
    public void getAllPicturesTest() {
        List<Picture> picturesList = pictureDAO.getAllPictures();
        assertNotNull(picturesList);

    }

    @Test
    public void deletePictureTest() {
        Picture picture = pictureDAO.getPictureByID(1);
        pictureDAO.delete(picture);

        assertNotEquals(initialNumberOfPictures, pictureDAO.getAllPictures().size());
        assertNull(pictureDAO.getPictureByID(1));

    }

    @Test
    public void updatePictureTest() {
        Picture picture = pictureDAO.getPictureByID(1);
        picture.setPicture("updated-picture.png");

        pictureDAO.updatePicture(picture);

        assertEquals("updated-picture.png", pictureDAO.getPictureByID(1).getPicture());
        //TODO: fix updatePicture method so test passes

    }

    @Test
    public void getByPropertyTest() {
        List<Picture> pictures = pictureDAO.getPictureByProperty("Username", "username");
        log.debug(pictures);

    }


}
