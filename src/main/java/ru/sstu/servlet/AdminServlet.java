package ru.sstu.servlet;

import org.apache.log4j.Logger;
import ru.sstu.entity.domain.Book;
import ru.sstu.entity.domain.Client;
import ru.sstu.entity.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static ru.sstu.entity.util.DatabaseConnection.addBook;
import static ru.sstu.entity.util.DatabaseConnection.updateBook;
import static ru.sstu.entity.util.Util.filterAllHtml;

@WebServlet(name = "AdminServlet",value = "/adminPanel")
public class AdminServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminServlet.class);

    List <Client> listClients = DatabaseConnection.getListClient();
    List <Book> listBooks = DatabaseConnection.getListBook();

    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        logger.info("Вход на страницу /adminPanel");
        String viewTable = filterAllHtml(req.getParameter("viewTable"));
        String bookId = filterAllHtml(req.getParameter("bookId"));
        String bookName = filterAllHtml(req.getParameter("bookName"));
        String description = filterAllHtml(req.getParameter("description"));
        String place = filterAllHtml(req.getParameter("place"));
        String pubclishingHouse = filterAllHtml(req.getParameter("pubclishingHouse"));
        String addOrUpdateBook = filterAllHtml(req.getParameter("addOrUpdateBook"));
        String delBook = filterAllHtml(req.getParameter("delBook"));

        writer.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Панель администратора</title>\n" +
                        "    <style>\n" +
                        "    body {\n" +
                        "      font-family: Arial, sans-serif;\n" +
                        "      font-size: 16px;\n" +
                        "      color: #000;\n" +
                        "      background-color: #f8f8f8;\n" +
                        "    }\n" +
                        "    footer {\n" +
                        "      position: absolute;\n" +
                        "      left: 0;\n" +
                        "      bottom: 0;\n" +
                        "      width: 100%;\n" +
                        "      height: 50px;\n" +
                        "      background-color: #98999b;\n" +
                        "      color: #fff;\n" +
                        "    }\n" +
                        "\n" +
                        "    /*таблицы*/\n" +
                        "    .tableForm {\n" +
                        "      width: 100%;\n" +
                        "    }\n" +
                        "    table {\n" +
                        "      border-collapse: collapse;\n" +
                        "      width: 100%;\n" +
                        "    }\n" +
                        "    table, th, td {\n" +
                        "      border: 1px solid;\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /*Формы*/\n" +
                        "    .form {\n" +
                        "      max-width: 320px;\n" +
                        "      padding: 15px;\n" +
                        "      background-color: #fff;\n" +
                        "    }\n" +
                        "    .input {\n" +
                        "      display: block;\n" +
                        "      width: 100%;\n" +
                        "      padding: 8px 10px;\n" +
                        "      margin-bottom: 10px;\n" +
                        "\n" +
                        "      border: 1px solid #ccc;\n" +
                        "\n" +
                        "      font-family: inherit;\n" +
                        "      font-size: 16px;\n" +
                        "    }\n" +
                        "    .btn {\n" +
                        "      display: block;\n" +
                        "      width: 100%;\n" +
                        "      padding: 8px 10px;\n" +
                        "\n" +
                        "      border: 0;\n" +
                        "      background-color: #6c96e2;\n" +
                        "      cursor: pointer;\n" +
                        "\n" +
                        "      font-family: inherit;\n" +
                        "      font-size: 16px;\n" +
                        "      color: #fff;\n" +
                        "    }\n" +
                        "    .btn:hover {\n" +
                        "      background-color: #618ee1;\n" +
                        "    }\n" +
                        "\n" +
                        "    /*Всплывающее окно*/\n" +
                        "    .dropbtn {\n" +
                        "      background-color: #98999b;\n" +
                        "      color: white;\n" +
                        "      padding: 16px;\n" +
                        "      font-size: 16px;\n" +
                        "      border: none;\n" +
                        "\n" +
                        "    }\n" +
                        "    .dropdown {\n" +
                        "      position: relative;\n" +
                        "      display: inline-block;\n" +
                        "      float:right;\n" +
                        "      margin-right: 35px\n" +
                        "    }\n" +
                        "    .dropdown-content {\n" +
                        "      display: none;\n" +
                        "      position: absolute;\n" +
                        "      background-color: #98999b;\n" +
                        "      min-width: 160px;\n" +
                        "      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
                        "      z-index: 1;\n" +
                        "      margin-right:35px\n" +
                        "    }\n" +
                        "    .dropdown-content a {\n" +
                        "      color: black;\n" +
                        "      padding: 12px 16px;\n" +
                        "      text-decoration: none;\n" +
                        "      display: block;\n" +
                        "      margin-right: 35px\n" +
                        "    }\n" +
                        "    .dropdown-content a:hover {\n" +
                        "      background-color: #53565d;\n" +
                        "      margin-right: 35px\n" +
                        "    }\n" +
                        "    .dropdown:hover .dropdown-content {\n" +
                        "      display: block;\n" +
                        "      margin-right: 35px\n" +
                        "    }\n" +
                        "    .dropdown:hover .dropbtn {\n" +
                        "      background-color: #98999b;\n" +
                        "      margin-right: 35px;\n" +
                        "    }\n" +
                        "\n" +
                        "    /*Меню*/\n" +
                        "    .link{\n" +
                        "      margin-left: 30px;\n" +
                        "      margin-right: 30px;\n" +
                        "      margin-top: 10px;\n" +
                        "      text-align:center;\n" +
                        "      line-height: normal;\n" +
                        "      height: 50%;\n" +
                        "    }\n" +
                        "\n" +
                        "    /*Центральная часть*/\n" +
                        "    .parent {\n" +
                        "      width: 100%;\n" +
                        "      height: 100%;\n" +
                        "      position: absolute;\n" +
                        "      top: 0;\n" +
                        "      left: 0;\n" +
                        "      overflow: auto;\n" +
                        "    }\n" +
                        "    .block {\n" +
                        "      width: 500px;\n" +
                        "      height: 500px;\n" +
                        "      position: absolute;\n" +
                        "      top: 50%;\n" +
                        "      left: 50%;\n" +
                        "      margin: -125px 0 0 -125px;\n" +
                        "    }\n" +
                        "\n" +
                        "  </style>\n" +
                        "</head>"
        );




        writer.println(
                "<body>\n" +
                        "<main class=\"parent\">\n" +
                        "            <a href=/logout>Выход</a>\n" +
                        "  <table class=\"tableForm\">\n" +
                        "  <tr>\n" +
                        "    <th>\n" +
                        "      <div>\n" +
                        "        <form class=\"form\" action=\"/adminPanel\" method=\"get\">\n" +
                        "          <p><label>Показать таблицу пользователей<input class=\"input\" name=\"viewTable\" type=\"checkbox\" value=\"client\"></label></p>\n" +
                        "          <p><label>Показать таблицу Книг<input class=\"input\" name=\"viewTable\" type=\"checkbox\" value=\"book\"></label></p>\n" +
                        "          <p><input  class=\"btn\" type=\"submit\"></p>\n" +
                        "        </form>\n" +
                        "      </div>\n" +
                        "    </th>\n" +
                        "    <th>\n" +
                        "      <div>\n" +
                        "        <form class=\"form\" action=\"/adminPanel\" method=\"get\">\n" +
                        "          <p><label>Введите id  книги<input class=\"input\" type=\"text\" name=\"bookId\" id=\"bookId\" ></label></p>\n" +
                        "          <p><label>Введите название  книги<input class=\"input\" type=\"text\" name=\"bookName\" id=\"bookName\" required></label></p>\n" +
                        "          <p><label>Введите описание  книги<input class=\"input\" type=\"text\" name=\"description\" id=\"description\" required></label></p>\n" +
                        "          <p><label>Введите место выпуска  книги<input class=\"input\" type=\"text\" name=\"place\" id=\"place\" required></label></p>\n" +
                        "          <p><label>Введите типографию  книги<input class=\"input\" type=\"text\" name=\"pubclishingHouse\" id=\"pubclishingHouse\" required></label></p>\n" +
                        "          <p><label>Обновить существующую книгу<input class=\"input\" type=\"checkbox\"value=\"0\" name=\"addOrUpdateBook\" id=\"addOrUpdateBook\" ></label></p>\n" +
                        "          <p><label>Добавить новую книгу<input class=\"input\" type=\"checkbox\" value=\"1\" name=\"addOrUpdateBook\" id=\"addOrUpdateBook\" ></label></p>\n" +
                        "          <p><label><input class=\"btn\" type=\"submit\"></label></p>\n" +
                        "        </form>\n" +
                        "      </div>\n" +
                        "    </th>\n" +
                        "  </tr>\n" +
                        "</table>"
        );

        logger.info(
                "addOrUpdateBook = " + addOrUpdateBook
        );

        if(viewTable != null){
            //Лист пользователей
            if(viewTable.equals("client")){
                writer.println(
                        "<h3>Просмотр всех пользователей системы</h3>\n" +
                                "  <table >\n" +
                                "    <thead>\n" +
                                "    <tr>\n" +
                                "      <th>ID Пользователя</th>\n" +
                                "      <th>Имя</th>\n" +
                                "      <th>Фамилия</th>\n" +
                                "      <th>Отчество</th>\n" +
                                "      <th>Логин</th>\n" +
                                "      <th>Уровень доступа</th>\\\n" +
                                "      <th>Пароль</th>\n" +
                                "    </tr>\n" +
                                "    </thead>"
                );


                for (Client client : listClients){
                    writer.println(
                            " <tr>\n" +
                                    "       <td>" + client.getIdClient() + "</td>\n" +
                                    "       <td>" + client.getFirstName() + "</td>\n" +
                                    "       <td>" + client.getSecondName() + "</td>\n" +
                                    "       <td>" + client.getPatronymic() + "</td>\n" +
                                    "       <td>" + client.getLogin() + "</td>\n" +
                                    "       <td>" + client.getAccessLevel() + "</td>\n" +
                                    "       <td>" + client.getPassword() + "</td>\n" +
                                    " </tr>"
                    );
                }

                writer.println( "</table>");
            }

            //Лист Книг
            if(viewTable.equals("book")){
                writer.println(
                        "<h3>Выберите книгу которую хотите удалить из базы данных</h3>\n" +
                                "    <table>\n" +
                                "      <thead>\n" +
                                "      <tr>\n" +
                                "        <th>ID книги</th>\n" +
                                "        <th>Название</th>\n" +
                                "        <th>Описание</th>\n" +
                                "        <th>Место печати</th>\n" +
                                "        <th>Типография</th>\n" +
                                "        <th>Действие </th>\n" +
                                "      </tr>\n" +
                                "      </thead>"
                );

                for(Book book : listBooks){
                    writer.println(
                            "  <form action=\"/adminPanel\" method=\"get\">\n" +
                            "<tr>\n" +
                                    "             <td>" + book.getBookId() + "</td>\n" +
                                    "             <td>" + book.getBookName() + "</td>\n" +
                                    "             <td>" + book.getDescription()+ "</td>\n" +
                                    "             <td>" + book.getPlace() + "</td>\n" +
                                    "             <td>" + book.getPubclishingHouse() + "</td>\n" +
                                    "             <td>" + " <form>\n" +
                                    "        <input type=\"text\" name=\"delBook\" value=\"" + book.getBookId() + "\"  hidden=\"hidden\">\n" +
                                    "<input class=\"btn\" type=\"submit\"  value=\"Удалить\">\n" +
                                    "        </td>\n" +
                                    "      </tr>" +
                                    "  </form>"
                    );


                }
                writer.println(
                        "</table>\n"
                );
            }
        }

        if(!delBook.equals("")){
            logger.info("Запущена процедура удаления книги  id=" + delBook );
            DatabaseConnection.deleteBook(delBook);
            logger.info("Книга удалена");
            listBooks = DatabaseConnection.getListBook();
        }

        if(addOrUpdateBook != null ){
            if( !bookName.equals("") & !description.equals("") & !place.equals("")  & !pubclishingHouse.equals("")) {

                if(addOrUpdateBook.equals("1")){
                    logger.info("Запущена процедура добавление книги");
                    addBook(bookName,pubclishingHouse,place,description);
                    logger.info("Книга добавлена");
                    listBooks = DatabaseConnection.getListBook();
                }

                if( addOrUpdateBook.equals("0")){
                    logger.info("Запущена процедура обновления книги");
                    updateBook(bookName,pubclishingHouse,place,description, Integer.parseInt(bookId));
                    logger.info("Книга обновлена");
                    listBooks = DatabaseConnection.getListBook();

                }

            }
        }



        writer.println(
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        logger.info("Прием данных с страницы /adminPanel");
        String viewTable = req.getParameter("viewTable");
        String bookId = filterAllHtml(req.getParameter("bookId"));
        String bookName = filterAllHtml(req.getParameter("bookName"));
        String description = filterAllHtml(req.getParameter("description"));
        String place = filterAllHtml(req.getParameter("place"));
        String pubclishingHouse = filterAllHtml(req.getParameter("pubclishingHouse"));
        String addOrUpdateBook = filterAllHtml(req.getParameter("addOrUpdateBook"));
        String delBook = filterAllHtml(req.getParameter("delBook"));




        if(viewTable != null){
            //Лист пользователей
            if(viewTable.equals("client")){
                writer.println(
                        "<h3>Просмотр всех пользователей системы</h3>\n" +
                                "  <table >\n" +
                                "    <thead>\n" +
                                "    <tr>\n" +
                                "      <th>ID Пользователя</th>\n" +
                                "      <th>Имя</th>\n" +
                                "      <th>Фамилия</th>\n" +
                                "      <th>Отчество</th>\n" +
                                "      <th>Логин</th>\n" +
                                "      <th>Уровень доступа</th>\\\n" +
                                "      <th>Пароль</th>\n" +
                                "    </tr>\n" +
                                "    </thead>"
                );


                for (Client client : listClients){
                    writer.println(
                            " <tr>\n" +
                                    "       <td>" + client.getIdClient() + "</td>\n" +
                                    "       <td>" + client.getFirstName() + "</td>\n" +
                                    "       <td>" + client.getSecondName() + "</td>\n" +
                                    "       <td>" + client.getPatronymic() + "</td>\n" +
                                    "       <td>" + client.getLogin() + "</td>\n" +
                                    "       <td>" + client.getAccessLevel() + "</td>\n" +
                                    "       <td>" + client.getPassword() + "</td>\n" +
                                    " </tr>"
                    );
                }

                writer.println( "</table>");
            }

            //Лист Книг
            if(viewTable.equals("book")){
                writer.println(
                        "<h3>Выберите книгу которую хотите удалить из базы данных</h3>\n" +
                                "  <form action=\"/adminPanel\" method=\"post\">\n" +
                                "    <table>\n" +
                                "      <thead>\n" +
                                "      <tr>\n" +
                                "        <th>ID книги</th>\n" +
                                "        <th>Название</th>\n" +
                                "        <th>Описание</th>\n" +
                                "        <th>Место печати</th>\n" +
                                "        <th>Типография</th>\n" +
                                "        <th>Действие </th>\n" +
                                "      </tr>\n" +
                                "      </thead>"
                );

                for(Book book : listBooks){
                    writer.println(
                            "<tr>\n" +
                                    "             <td>" + book.getBookId() + "</td>\n" +
                                    "             <td>" + book.getBookName() + "</td>\n" +
                                    "             <td>" + book.getDescription()+ "</td>\n" +
                                    "             <td>" + book.getPlace() + "</td>\n" +
                                    "             <td>" + book.getPubclishingHouse() + "</td>\n" +
                                    "             <td>" + " <form>\n" +
                                    "        <input type=\"text\" name=\"delBook\" value=\"" + book.getBookId() + "\"  hidden=\"hidden\">\n" +
                                    "<input class=\"btn\" type=\"submit\"  value=\"Удалить\">\n" +
                                    "        </td>\n" +
                                    "      </tr>"
                    );


                }
                writer.println(
                        "</table>\n" +
                                "  </form>"
                );
            }
        }

        if(!delBook.equals("")){
            logger.info("Запущена процедура удаления книги  id=" + delBook );
            DatabaseConnection.deleteBook(delBook);
            logger.info("Книга удалена");
            listBooks = DatabaseConnection.getListBook();
        }

        if(addOrUpdateBook != null ){
            if( !bookName.equals("") & !description.equals("") & !place.equals("")  & !pubclishingHouse.equals("")) {

                if(addOrUpdateBook.equals("0")){
                    logger.info("Запущена процедура добавление книги");
                    addBook(bookName,pubclishingHouse,place,description);
                    logger.info("Книга добавлена");
                    listBooks = DatabaseConnection.getListBook();
                }

                if( addOrUpdateBook.equals("1")){
                    logger.info("Запущена процедура обновления книги");
                    updateBook(bookName,pubclishingHouse,place,description, Integer.parseInt(bookId));
                    logger.info("Книга обновлена");
                    listBooks = DatabaseConnection.getListBook();

                }

            }
        }

        writer.println(
                "</body>\n" +
                        "</html>"
        );
    }


}
