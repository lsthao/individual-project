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
import java.util.List;

@WebServlet(
        urlPatterns = {"/allRestaurants"}
)
public class AllRestaurants extends HttpServlet{
    Logger logger = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();

        //getting all restaurants for select dropdown
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);
        List<Restaurant> allRestaurants = restaurantDAO.getAll();

        session.setAttribute("restaurants", allRestaurants);

        String url = "/web-pages/all-restaurants.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }

}
