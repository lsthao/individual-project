package edu.matc.controller;

import edu.matc.entity.Picture;
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
        urlPatterns = {"/individualpicture"}
)
public class IndividualPicture extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession();
        GenericDAO pictureDAO = new GenericDAO(Picture.class);

        int id = Integer.parseInt(request.getParameter("ID"));

        Picture picture = (Picture)pictureDAO.getByID(id);

        session.setAttribute("picture", picture);
        String url= "/web-pages/individual-picture.jsp";

        RequestDispatcher requestDispatcher =
                getServletContext().getRequestDispatcher(url);

        requestDispatcher.forward(request, response);


    }
}
