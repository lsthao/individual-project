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
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/updateRestaurant"}
)
/**
 * This servlet class is used to update a restaurant.
 *
 * @Author Leja Thao
 */
public class UpdateRestaurant extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * This doPost method updates a restaurant and redirects to the updated restaurant's
     * individual page.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);

        int restaurantID = Integer.parseInt(request.getParameter("restaurant-id"));
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String phoneNumber = request.getParameter("phonenumber");

        Restaurant restaurant = (Restaurant)restaurantDAO.getByID(restaurantID);
        restaurant.setName(name);
        restaurant.setLocation(location);
        restaurant.setPhoneNumber(phoneNumber);

        restaurantDAO.update(restaurant);


        String url = "/individualproject/individualrestaurant?ID=" + restaurantID;
        response.sendRedirect(url);
    }
}
