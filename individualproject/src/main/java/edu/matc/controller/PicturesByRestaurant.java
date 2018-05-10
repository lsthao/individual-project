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
import java.util.Set;

@WebServlet(
        urlPatterns = {"/byRestaurant"}
)
/**
 * This class is used to display all pictures that are from the same restaurant.
 *
 * @author Leja Thao
 */
public class PicturesByRestaurant extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This is a doGet method that gets the ID of a restaurant and uses
     * the DAO to get all pictures from that restaurant to display the photos
     * on the page.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("ID"));

        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);
        Restaurant restaurant = (Restaurant) restaurantDAO.getByID(id);

        Set<Picture> pictures = restaurant.getPictures();

        session.setAttribute("pictures", pictures);
        session.setAttribute("restaurant", restaurant);

        String url= "/web-pages/pictures-by-restaurant.jsp";

        RequestDispatcher requestDispatcher =
                getServletContext().getRequestDispatcher(url);

        requestDispatcher.forward(request, response);

    }
}