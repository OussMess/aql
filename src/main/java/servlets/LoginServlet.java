package servlets;/* Created by Oussama on 11/12/2017. */

import Beans.Authentification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final static String BIENVENUE_PAGE = "/WEB-INF/bienvenue.jsp";
    private final static String ERROR_PAGE = "/WEB-INF/errorPage.jsp";

    private final static String LOGIN_PAGE = "/login.jsp";

    private Authentification loggin = new Authentification();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(loggin.isCorrectLoginPassword(username, password)){
            this.getServletContext().getRequestDispatcher(BIENVENUE_PAGE).forward(req, resp);
            return;
        }
        this.getServletContext().getRequestDispatcher(ERROR_PAGE).forward(req, resp);
    }
}
