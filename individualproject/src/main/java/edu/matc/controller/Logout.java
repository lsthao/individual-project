package edu.matc.controller;


import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/logout"}
)
/**
 * This Servlet class is used to log a user out of a session.
 *
 * @Author Leja Thao
 */
public class Logout extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Invalidates login and redirects to index.jsp launch page
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/individualproject/");

    }
}