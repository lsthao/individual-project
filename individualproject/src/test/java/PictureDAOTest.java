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


    }

    @Test
    public void getAllPicturesTest() {
        List<Picture> picturesList = pictureDAO.getAllPictures();


    }

    @Test
    public void deletePictureTest() {
        Picture picture = pictureDAO.getPictureByID(1);
        pictureDAO.delete(picture);


    }

    @Test
    public void updatePictureTest() {
        Picture picture = pictureDAO.getPictureByID(2);
        picture.setPicture("updated-picture.png");

        pictureDAO.updatePicture(picture);


    }




}
