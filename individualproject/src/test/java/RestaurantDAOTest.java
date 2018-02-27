import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.PictureDAO;
import edu.matc.persistence.RestaurantDAO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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



}
