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


/**
 * This class uses the GenericDAO to get all pictures and all restaurants to display on the
 * index page.
 *
 * @author Leja Thao
 */
@WebServlet(
        urlPatterns = {"/"}
)
public class AllPictures extends HttpServlet{
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * A doGet method that sets all pictures as an attribute to display all pictures
     * and then sets al restaurants as an attribute for the dropdown in the submit form.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();

        //getting all restaurants for select dropdown
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);
        List<Restaurant> allRestaurants = restaurantDAO.getAll();

        //getting all pictures to display on homepage
        GenericDAO pictureDAO = new GenericDAO(Picture.class);
        List<Picture> allPictures = pictureDAO.getAll();

        session.setAttribute("restaurants", allRestaurants);
        session.setAttribute("pictures", allPictures);

        String url = "/web-pages/index.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }

}
