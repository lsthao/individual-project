import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenericPictureDAOTest {

    GenericDAO pictureDAO;
    int initialNumberOfPictures;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        pictureDAO = new GenericDAO(Picture.class);
        initialNumberOfPictures = pictureDAO.getAll().size();

    }

    @Test
    public void addTest() {
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);
        Restaurant restaurant = (Restaurant) restaurantDAO.getByID(1);

        Picture picture = new Picture("newwwpicture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = pictureDAO.add(picture);

        Picture insertedPicture = (Picture) pictureDAO.getByID(id);
        assertEquals("newwwpicture.jpg", insertedPicture.getPicture());
        assertEquals(restaurant.getName(), insertedPicture.getRestaurant().getName());
        assertEquals(2, insertedPicture.getUserID());

    }




    @Test
    public void getAllPicturesTest() {
        List<Picture> picturesList = pictureDAO.getAll();
        System.out.println(picturesList);
        assertNotNull(picturesList);
        assertEquals(initialNumberOfPictures, picturesList.size());

    }

    @Test
    public void deletePictureTest() {
        Picture picture = (Picture)pictureDAO.getByID(3);
        pictureDAO.delete(picture);
        assertNull(pictureDAO.getByID(3));


    }

    @Test
    public void updatePictureTest() {

        String newPictureName = "https://www.theblackpeppercorn.com/wp-content/uploads/2011/07/pad-thai.jpg";
        Picture picture = (Picture)pictureDAO.getByID(2);
        picture.setPicture(newPictureName);
        picture.setUserID(1);

        pictureDAO.update(picture);

        Picture updatedPicture = (Picture)pictureDAO.getByID(2);

        assertEquals(newPictureName, updatedPicture.getPicture());
        assertEquals(1, updatedPicture.getUserID());

    }

    @Test
    public void getPictureByID() {
        Picture picture = (Picture)pictureDAO.getByID(1);
        assertNotNull(picture);
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Meatball_pizza.jpg/1200px-Meatball_pizza.jpg", picture.getPicture());


    }

}
