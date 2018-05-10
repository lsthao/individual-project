package edu.matc.controller;

import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
import edu.matc.util.DetectLabels;
import edu.matc.util.UploadToS3;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/submitPicture"}
)
/**
 * This class is used to submit a picture and add it to the database.
 *
 * @author
 */
public class SubmitPicture extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This is a doPost method that gets form values and uses them to create
     * Picture/Restaurant objects to add to the database.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GenericDAO pictureDAO = new GenericDAO(Picture.class);
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);
        UploadToS3 upload = new UploadToS3();
        DetectLabels detect = new DetectLabels();

        String pictureURL = request.getParameter("picture-url");
        String comment = request.getParameter("comment");
        String restaurantName = request.getParameter("restaurant-name");
        String newRestaurantName = request.getParameter("new-restaurant-name");
        String street = request.getParameter("street-address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zip-code");
        String fullAddress = street + ", "
                + city + ", "
                + state + ", "
                + zipCode;
        String phoneNumber = request.getParameter("phone-number");
        upload.uploadFile(pictureURL);
        String pictureName = upload.getPhotoNameString(pictureURL);

        pictureURL = "https://s3.us-east-2.amazonaws.com/food-pictures/" + pictureName;

        logger.info(pictureName);

        if(detect.detectLabelWithA3Object(pictureName)) {
            if (!restaurantName.equals("Add New")) {

                Restaurant restaurant = (Restaurant) restaurantDAO.getByPropertyEqual("name", restaurantName).get(0);
                logger.info(restaurant);
                Picture newPicture = new Picture(pictureURL, comment, restaurant, 1);
                restaurant.addPicture(newPicture);
                pictureDAO.add(newPicture);

            } else {

                Restaurant newRestaurant = new Restaurant(newRestaurantName, fullAddress, phoneNumber);
                int id = restaurantDAO.add(newRestaurant);
                Restaurant addedRestaurant = (Restaurant) restaurantDAO.getByID(id);
                logger.info("inside the else?? " + comment);
                Picture newPicture = new Picture(pictureURL, comment, addedRestaurant, 1);
                addedRestaurant.addPicture(newPicture);

                pictureDAO.add(newPicture);
            }


            session.setAttribute("addSuccessMessage", "Your picture has been added!");
        } else {
            session.setAttribute("addSuccessMessage", "We are only accepting pictures of food. Please submit a new one. ");
        }



        String url = "/individualproject/";
        response.sendRedirect(url);

    }


}
