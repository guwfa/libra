package ru.sstu.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ErrorServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Перенаправление на страницу ErrorServlet");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println(
                "<!doctype html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\"\n" +
                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>Упс, что-то пошло не так</title>\n" +
                        "    <style>\n" +
                        "        .btn {\n" +
                        "            background: #0084D4;\n" +
                        "            border-radius: 4px;\n" +
                        "            padding: 10px 22px;\n" +
                        "            font-size: 18px;\n" +
                        "            border: none;\n" +
                        "            color: #fff;\n" +
                        "            transition: .3s all;\n" +
                        "            margin: 40% auto;\n" +
                        "            display: block;\n" +
                        "            text-align: center;\n" +
                        "        }\n" +
                        "\n" +
                        "        .not-found__btn {\n" +
                        "            text-decoration: none;\n" +
                        "            position: relative;\n" +
                        "            top: -50px;\n" +
                        "        }\n" +
                        "\n" +
                        "        .btn:hover {\n" +
                        "            opacity: .8;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1 style=\"text-align: center\">Упс, что-то пошло не так</h1>\n" +
                        "    <h2 style=\"text-align: center\">Давайте начнём сначала!</h2>\n" +
                        "\n" +
                        "    <a href=\"/\" class=\"btn not-found__btn\">Вернуться на главную</a>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
