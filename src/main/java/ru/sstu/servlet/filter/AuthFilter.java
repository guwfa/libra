package ru.sstu.servlet.filter;

import org.apache.log4j.Logger;
import ru.sstu.entity.domain.Client;
import ru.sstu.entity.repository.ClientInstance;
import ru.sstu.entity.util.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebFilter("/")
 public class AuthFilter implements Filter {
    private static final Logger logger = Logger.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        logger.info("Начата проверка doFilter");

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();
        session.setMaxInactiveInterval(10*60);

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            logger.info("Client:  login=" + login + "  password=" + password);

            final Client.ROLE role = (Client.ROLE) session.getAttribute("role");

            moveToMenu(req, res, role);


        } else if (  ClientInstance.userIsExist(login,password)) {

            Client client = DatabaseConnection.getClient(login);
            final Client.ROLE role = client.getRole();

            logger.info("Client:  login=" + login + "  password=" + password + " role= " + role);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("", role);
            req.getSession().setAttribute("idClient", client.getIdClient());


            moveToMenu(req, res, role);

        } else {
            logger.info("Client UNKNOWN");
            moveToMenu(req, res, Client.ROLE.UNKNOWN);
        }
    }

    private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final Client.ROLE role)
            throws IOException, ServletException {

        if (role.equals(Client.ROLE.ADMIN)) { res.sendRedirect("/adminPanel"); }
        else if (role.equals(Client.ROLE.USER)) { req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,res); }
        else { req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res); }
    }

    @Override
    public void destroy() {
    }

}

