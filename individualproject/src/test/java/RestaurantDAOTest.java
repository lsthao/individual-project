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

    int initialNumberOfRestaurants;
    RestaurantDAO restaurantDAO;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        restaurantDAO = new RestaurantDAO();

        initialNumberOfRestaurants = restaurantDAO.getAllRestaurants().size();
    }

    @Test
    public void addWithPictureTest() {
        Restaurant restaurant = new Restaurant("a new restaurant name", "restaurant location", "123-334-5322");
        Picture picture = new Picture("anewpicture.jpg", restaurant, 2);
        restaurant.addPicture(picture);
        int id = restaurantDAO.addRestaurant(restaurant);

        Restaurant insertedRestaurant = restaurantDAO.getRestaurantByID(id);
        assertNotNull(insertedRestaurant);
        assertEquals("a new restaurant name", insertedRestaurant.getName());
        assertEquals(initialNumberOfRestaurants + 1, restaurantDAO.getAllRestaurants().size());


    }

    @Test
    public void getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        assertNotNull(restaurants);
        assertEquals(initialNumberOfRestaurants, restaurants.size());

    }

    @Test
    public void getRestaurantByID() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(1);
        assertNotNull(restaurant);
        assertEquals("restaurant1", restaurant.getName());
        assertEquals("phonenumber", restaurant.getPhoneNumber());
        assertEquals("restaurant location", restaurant.getLocation());

    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(2);
        String newLocation = "new location";
        String newRestaurantName = "new restaurant name update";

        restaurant.setLocation(newLocation);
        restaurant.setName(newRestaurantName);

        restaurantDAO.updateRestaurant(restaurant);
        Restaurant newRestaurant = restaurantDAO.getRestaurantByID(2);

        assertEquals(newLocation, newRestaurant.getLocation());
        assertEquals(newRestaurantName, newRestaurant.getName());

    }

    @Test
    public void deleteRestaurant() {
        Restaurant restaurant = restaurantDAO.getRestaurantByID(3);
        restaurantDAO.delete(restaurant);
        assertNull(restaurantDAO.getRestaurantByID(3));
    }

}
