import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.PictureDAO;
import edu.matc.persistence.RestaurantDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantDAOTest {

    int initialNumberOfPictures;
    RestaurantDAO restaurantDAO;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        restaurantDAO = new RestaurantDAO();
    }

    @Test
    public void addWithPictureTest() {
        Restaurant restaurant = new Restaurant("an new restaurant name", "restaurant location", "123-334-5322");
        Picture picture = new Picture("anewpicture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = restaurantDAO.addRestaurant(restaurant);

    }

    @Test
    public void getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();

    }

    @Test
    public void getRestaurantByID() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);

    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        String newLocation = "new location";
        restaurant.setLocation(newLocation);
        restaurantDAO.updateRestaurant(restaurant);
        Restaurant newRestaurant = restaurantDAO.getRestaurantByID(1);

    }

    @Test
    public void deleteRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        restaurantDAO.delete(restaurant);
    }

}
