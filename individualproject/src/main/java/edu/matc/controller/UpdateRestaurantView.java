package edu.matc.controller;

import edu.matc.entity.Picture;
import edu.matc.entity.Restaurant;
import edu.matc.persistence.GenericDAO;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/updaterestaurantview"}
)
/**
 * This Servlet class passes an individual restaurant
 * information to be edited.
 */
public class UpdateRestaurantView extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession();
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);

        int id = Integer.parseInt(request.getParameter("ID"));

        Restaurant restaurant = (Restaurant)restaurantDAO.getByID(id);

        session.setAttribute("restaurant", restaurant);
        String url= "/web-pages/update-restaurant.jsp";

        RequestDispatcher requestDispatcher =
                getServletContext().getRequestDispatcher(url);

        requestDispatcher.forward(request, response);


    }
}
