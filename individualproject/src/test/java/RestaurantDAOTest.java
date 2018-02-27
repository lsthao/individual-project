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

        restaurantDAO = new RestaurantDAO();
    }

    @Test
    public void addWithPictureTest() {
        Restaurant restaurant = new Restaurant("restaurant name", "restaurant location", "123-334-5322");
        Picture picture = new Picture("picture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = restaurantDAO.addRestaurant(restaurant);

    }

    @Test
    public void getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        assertEquals(1, restaurants.size());
    }

    @Test
    public void getRestaurantByID() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        assertEquals("restaurant name", restaurant.getName());
    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        String newLocation = "new location";
        restaurant.setLocation(newLocation);
        restaurantDAO.updateRestaurant(restaurant);
        Restaurant newRestaurant = restaurantDAO.getRestaurantByID(1);
        assertEquals(newLocation, newRestaurant.getLocation());
    }

    @Test
    public void deleteRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        restaurantDAO.delete(restaurant);
        assertNull(restaurantDAO.getRestaurantByID(1));
    }

}
