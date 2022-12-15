package ru.sstu.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",value = "/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LogoutServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        logger.info("Старт закрытия сессии");
        final HttpSession session = req.getSession();

        session.removeAttribute("login");
        session.removeAttribute("password");
        session.removeAttribute("role");
        session.removeAttribute("idClient");
        session.setMaxInactiveInterval(0);

        logger.info("Сессия закрыта ");
        resp.sendRedirect("/");
    }

}