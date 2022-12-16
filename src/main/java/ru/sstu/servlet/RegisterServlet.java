package ru.sstu.servlet;
import org.apache.log4j.Logger;
import ru.sstu.entity.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static ru.sstu.entity.util.Util.filterAllHtml;

@WebServlet(name = "RegisterServlet", value ="/registration")
public class RegisterServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(RegisterServlet.class);
    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Вход на страницу /registration");
        req.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();


        logger.info("Прием данных с страницы /registration");
        String login = filterAllHtml(req.getParameter("login"));
        String firstName = filterAllHtml(req.getParameter("firstName"));
        String secondName = filterAllHtml(req.getParameter("secondName"));
        String patronymic = filterAllHtml(req.getParameter("patronymic"));
        String password = filterAllHtml(req.getParameter("password"));

        /*Нет никаких проверок на фронте и беке на валидность данных*/

        if(!login.equals("") && !firstName.equals("") && !secondName.equals("") && !patronymic.equals("") && !password.equals("") ){
            DatabaseConnection.addClient(firstName,secondName,patronymic,"2",login,password);
        }

        resp.sendRedirect("/login");
        logger.info("Пользователь создан");
    }
}
