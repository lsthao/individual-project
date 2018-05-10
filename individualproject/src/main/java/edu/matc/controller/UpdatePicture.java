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
        urlPatterns = {"/updatePicture"}
)
/**
 * This servlet class is used to update a picture.
 *
 * @Author Leja Thao
 */
public class UpdatePicture extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * This doPost method updates a picture comment and redirects to the updated pictures
     * individual page.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDAO pictureDAO = new GenericDAO(Picture.class);
        GenericDAO restaurantDAO = new GenericDAO(Restaurant.class);

        int pictureID = Integer.parseInt(request.getParameter("picture-id"));
        String comment = request.getParameter("comment");

        Picture picture = (Picture)pictureDAO.getByID(pictureID);
        picture.setComment(comment);
        pictureDAO.update(picture);


        String url = "/individualproject/individualpicture?ID=" + pictureID;
        response.sendRedirect(url);
    }
}
