package edu.matc.controller;

import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
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
public class SubmitPicture extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GenericDAO pictureDAO = new GenericDAO(Picture.class);
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);

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

        logger.info("restaurant name here? " + comment);
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

        String url = "/individualproject/";
        response.sendRedirect(url);

    }


}
