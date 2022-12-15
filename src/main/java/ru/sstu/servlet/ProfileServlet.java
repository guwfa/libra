package ru.sstu.servlet;

import org.apache.log4j.Logger;
import ru.sstu.entity.domain.Book;
import ru.sstu.entity.domain.SubcriptionCard;
import ru.sstu.entity.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.util.Objects.nonNull;
import static ru.sstu.entity.util.Util.filter;
import static ru.sstu.entity.util.Util.filterAllHtml;

@WebServlet(name = "ProfileServlet", value ="/profile")
public class ProfileServlet  extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProfileServlet.class);
    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Вход на страницу /profile");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        logger.info("Прием данных с страницы /profile GET");

        HttpSession session = req.getSession();
        int idClientSession = (int) session.getAttribute("idClient");

        /*Удаление карты*/
        String dellSubCard = filterAllHtml(req.getParameter("dellSubCard"));

        /*Удадение книги у клиента*/
        String bookIdDel = filterAllHtml(req.getParameter("delBook"));

        /*Добавление книги*/
        String bookAddId = filterAllHtml(req.getParameter("addBook"));


        logger.info("Прием данных с страницы /profile  GET завершен. Client id=" + idClientSession);

        logger.info(
                "Данные из форм:" +
                        "\n\tbookAddId=" + bookAddId +
                        "\n\tbookIdDel=" + bookIdDel +
                        "\n\tdellSubCard= " + dellSubCard +
                        "\nДанные сессии: " +
                        "\n\tidClient=" + session.getAttribute("idClient") +
                        "\n\tlogin=" + session.getAttribute("login") +
                        "\n\tpassword=" + session.getAttribute("password") +
                        "\n\trole=" + session.getAttribute("role")

        );


        writer.println(
               "<!DOCTYPE html>\n" +
                       "<html lang=\"en\">\n" +
                       "<head>\n" +
                       "    <meta charset=\"UTF-8\">\n" +
                       "    <title>Профиль</title>\n" +
                       "    <style>\n" +
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
                       "\n" +
                       "    /*Таблицы*/\n" +
                       "    table {\n" +
                       "      border-collapse: collapse;\n" +
                       "      width: 100%;\n" +
                       "    }\n" +
                       "    table, th, td {\n" +
                       "      border: 1px solid;\n" +
                       "    }\n" +
                       "\n" +
                       "  </style>\n" +
                       "</head>\n" +
                       "<body>" +
                       "<main class=\"parent\">"
                );

        //Меню
        writer.println(
                "  <menu>\n" +
                        "    <div class=\"menu\">\n" +
                        "      <div>\n" +
                        "        <a class=\"link\" href=\"/\">Главная страница</a>\n" +
                        "        <div class=\"dropdown\">\n" +
                        "          <button class=\"dropbtn\">Профиль</button>\n" +
                        "          <div class=\"dropdown-content\">\n" +
                        "            <a href=\"/profile\">Профиль</a>\n" +
                        "            <a href=/logout>Выход</a>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "  </menu>"
        );

        writer.println(
                "<h3>Выберите клиентскую карту которую хотите удалить</h3>\n" +
                        "     <table>\n" +
                        "       <thead>\n" +
                        "         <tr>\n" +
                        "           <th>Id  Пользоввательской карты</th>\n" +
                        "           <th>Дата получения</th>\n" +
                        "           <th>Дата выдачи книги</th>\n" +
                        "           <th>Дата планируемового возврата</th>\n" +
                        "           <th>Действие</th>\n" +
                        "         </tr>\n" +
                        "       </thead>"
        );


       /*
       * В if должно быть сравнение с id  пользователя
       * */


        for (SubcriptionCard subcriptionCard : DatabaseConnection.getListSubcriptionCard()){
            if(idClientSession == subcriptionCard.getClientId()){
                writer.println(
                        "   <form action=\"/profile\" method=\"GET\">\n" +
                        "<tr>\n" +
                                "         <td>" + subcriptionCard.getSubcriptionCardId() + "</td>\n" +
                                "         <td>" + subcriptionCard.getDateOfReceiving() + "</td>\n" +
                                "         <td>" + subcriptionCard.getPlanned_date() +"</td>\n" +
                                "         <td>" + subcriptionCard.getReturnDate() +"</td>\n" +
                                "         <td>\n" +
                                "           <input type=\"text\" name=\"dellSubCard\" value=\"" + subcriptionCard.getSubcriptionCardId() + "\"  hidden=\"hidden\">\n" +
                                "           <input type=\"submit\"  value=\"Удалить\">\n" +
                                "         </td>\n" +
                                "       </tr>" +
                                "   </form>"
                );
            }
        }


        writer.println(
                       "     </table>\n"
                        );


        writer.println(
                " <h3>Выберите книгу которую хотите добавить к себе</h3>\n" +
                        "  <i>Учтите, что добавляя книгу вы автоматически создаете новую клиентскую карту</i>\n" +

                        "      <table>\n" +
                        "        <thead>\n" +
                        "          <tr>\n" +
                        "            <th>ID книги</th>\n" +
                        "            <th>Название</th>\n" +
                        "            <th>Описание</th>\n" +
                        "            <th>Место печати</th>\n" +
                        "            <th>Типография</th>\n" +
                        "            <th>Действие </th>\n" +
                        "          </tr>\n" +
                        "        </thead>"
        );





        for(Book book : DatabaseConnection.getListBook()){
            writer.println(
                    "   <form action=\"/profile\" method=\"GET\">\n" +
                    "<tr>\n" +
                            "         <td>" + book.getBookId() + "</td>\n" +
                            "         <td>" + book.getBookName() + "</td>\n" +
                            "         <td>" + book.getDescription() +"</td>\n" +
                            "         <td>" + book.getPlace() +"</td>\n" +
                            "         <td>" + book.getPubclishingHouse() +"</td>\n" +
                            "         <td>\n" +
                            "           <input type=\"text\" name=\"addBook\" value=\"" + book.getBookId() + "\"  hidden=\"hidden\">\n" +
                            "           <input type=\"submit\"  value=\"Добавить\">\n" +
                            "         </td>\n" +
                            "       </tr>" +
                            "    </form>"
            );
        }

         writer.println(
                 "  </table>\n"
                         );



        writer.println(
                "<h3>Выберите книгу которую хотите удалить у себя</h3>\n" +
                        "  <i>Учтите, что удаляя книгу вы автоматически удаляете  клиентскую карту к которой привязана книга</i>\n" +

                        "      <table>\n" +
                        "        <thead>\n" +
                        "        <tr>\n" +
                        "          <th>ID книги</th>\n" +
                        "          <th>Название</th>\n" +
                        "          <th>Описание</th>\n" +
                        "          <th>Место печати</th>\n" +
                        "          <th>Типография</th>\n" +
                        /*"          <th>Действие </th>\n" +*/
                        "        </tr>\n" +
                        "        </thead>"
        );

        //Цикл вывода сделать
        /*
        * Цепочка запросов: Пользователь -> Клиентская карта -> Инстанс -> Книга
        * */
        for(Book book : DatabaseConnection.getAllBookToClientId(String.valueOf(idClientSession))){
            writer.println(
                    "    <form action=\"/profile\" method=\"GET\">\n" +
                    "<tr>\n" +
                            "         <td>" + book.getBookId() + "</td>\n" +
                            "         <td>" + book.getBookName() + "</td>\n" +
                            "         <td>" + book.getDescription() +"</td>\n" +
                            "         <td>" + book.getPlace() +"</td>\n" +
                            "         <td>" + book.getPubclishingHouse() +"</td>\n" /*+
                            "         <td>\n" +
                            "           <input type=\"text\" name=\"delBook\" value=\"" + book.getBookId() + "\"  hidden=\"hidden\">\n" +
                            "           <input type=\"submit\"  value=\"Удалить\">\n"*/ +
                            "         </td>\n" +
                            "       </tr>" +
                            "    </form>"
            );
        }


         writer.println(
                                "      </table>\n"
        );

        writer.println(
                        "</body>\n" +
                        "</html>"
        );


        /*Удаление карты*/
        if(!dellSubCard.equals("")) {
            logger.info("Клиент id=" + idClientSession + " отправляет запрос на удаление пользовательской карты id=" + dellSubCard);
            DatabaseConnection.dellSabCardUser(Integer.parseInt(dellSubCard));
            logger.info("Удаление  пользовательской карты успешно завершено");
        }

        /*Добавление */
        if(!bookAddId.equals("")){
            logger.info("Клиент id=" + idClientSession + "  отправил запрос на добавление книги (читательской карты) id=" + bookAddId);
            DatabaseConnection.addSubcriptionCard(idClientSession,bookAddId);
            logger.info("Добавление книги в пользовательскую карту успешно завершено");
        }

       /* if(!bookIdDel.equals("")){
            logger.info("Клиент id=" + idClientSession + " отправляет запрос на удаление книги id=" + bookIdDel);
            //DatabaseConnection.dellSabCardUser(bookAddId);
            logger.info("Удаление  пользовательской карты успешно завершено");
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        resp.sendRedirect("/profile");
    }
}