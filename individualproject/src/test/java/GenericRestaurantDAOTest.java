import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenericRestaurantDAOTest {

    int initialNumberOfRestaurants;
    GenericDAO restaurantDAO;

    private Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        restaurantDAO = new GenericDAO(Restaurant.class);

        initialNumberOfRestaurants = restaurantDAO.getAll().size();
    }

    @Test
    public void addWithPictureTest() {
        Restaurant restaurant = new Restaurant("a new restaurant name", "restaurant location", "123-334-5322");
        Picture picture = new Picture("anewpicture.jpg", "comment", restaurant, 2);
        restaurant.addPicture(picture);
        int id = restaurantDAO.add(restaurant);

        Restaurant insertedRestaurant = (Restaurant)restaurantDAO.getByID(id);
        assertNotNull(insertedRestaurant);
        assertEquals("a new restaurant name", insertedRestaurant.getName());
        assertEquals(initialNumberOfRestaurants + 1, restaurantDAO.getAll().size());


    }

    @Test
    public void getAllRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.getAll();
        assertNotNull(restaurants);
        assertEquals(initialNumberOfRestaurants, restaurants.size());

    }

    @Test
    public void getRestaurantByID() {
        Restaurant restaurant = (Restaurant)restaurantDAO.getByID(1);
        assertNotNull(restaurant);
        assertEquals("restaurant1", restaurant.getName());
        assertEquals("phonenumber", restaurant.getPhoneNumber());
        assertEquals("restaurant location", restaurant.getLocation());

    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = (Restaurant)restaurantDAO.getByID(2);
        String newLocation = "new location";
        String newRestaurantName = "new restaurant name update";

        restaurant.setLocation(newLocation);
        restaurant.setName(newRestaurantName);

        restaurantDAO.update(restaurant);
        Restaurant newRestaurant = (Restaurant)restaurantDAO.getByID(2);

        assertEquals(newLocation, newRestaurant.getLocation());
        assertEquals(newRestaurantName, newRestaurant.getName());

    }

    @Test
    public void deleteRestaurant() {
        Restaurant restaurant = (Restaurant)restaurantDAO.getByID(3);
        restaurantDAO.delete(restaurant);
        assertNull(restaurantDAO.getByID(3));
    }

    @Test
    public void getRestaurantByProperty() {
        Restaurant restaurant = (Restaurant)restaurantDAO.getByPropertyEqual("name", "restaurant1").get(0);

        System.out.println(restaurant.getId());
    }

}
