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


/**
 * This class is used to delete a picture from the database.
 *
 * @author Leja Thao
 */
@WebServlet(
        urlPatterns = {"/deletePicture"}
)
public class DeletePicture extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * This function is a doPost that gets the pictureID from the application
     * and performs the delete operation.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDAO pictureDAO = new GenericDAO(Picture.class);

        int pictureID = Integer.parseInt(request.getParameter("picture-id"));

        Picture picture = (Picture)pictureDAO.getByID(pictureID);
        pictureDAO.delete(picture);


        String url = "/individualproject/";
        response.sendRedirect(url);
    }
}
