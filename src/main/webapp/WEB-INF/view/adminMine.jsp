<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.sstu.entity.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.sstu.entity.domain.Client" %>
<jsp:useBean id="test" class="ru.sstu.servlet.AdminServlet" />

<%
  PrintWriter writer = response.getWriter();
  writer.println(
          "        <div>" +
                  "<h3>Лист пользователей</h3>\n" +
                  "            <table>\n" +
                  "                <thead>\n" +
                  "                <tr>\n" +
                  "                    <th>ID Пользователя</th>\n" +
                  "                    <th>Имя</th>\n" +
                  "                    <th>Фамилия</th>\n" +
                  "                    <th>Отчество</th>\n" +
                  "                    <th>Логин</th>\n" +
                  "                    <th>Уровень доступа</th>\n" +
                  "                    <th>Пароль</th>\n" +
                  "                </tr>\n" +
                  "                </thead>\n" +
                  "                <tbody>"
  );


  if(request.getAttribute("listClients") != null){
    List<Client> listClients = (List<Client>) request.getAttribute("listClients");
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
  }
  writer.println(
          "  </tbody>\n" +
                  "</table>" +
                  " </div>\n" +
                  "        <br>\n" +
                  "        <br>\n" +
                  "        <div>" +
                  "<h3>Лист книг</h3>\n" +
                  " <table>\n" +
                  "    <thead>\n" +
                  "       <tr>\n" +
                  "             <th>ID книги</th>\n" +
                  "             <th>Название</th>\n" +
                  "             <th>Описание</th>\n" +
                  "              <th>Место печати</th>\n" +
                  "              <th>Типография</th>\n" +
                  "              <th>Действие </th>\n" +
                  "       </tr>\n" +
                  "      </thead>\n" +
                  "  <tbody>"
  );

  if (request.getAttribute("listBooks") != null) {
    List<Book> listBooks = (List<Book>) request.getAttribute("listBooks");
    for(Book book : listBooks){
      writer.println("<tr>\n" +
              "             <td>" + book.getBookId() + "</td>\n" +
              "             <td>" + book.getBookName() + "</td>\n" +
              "             <td>" + book.getDescription()+ "</td>\n" +
              "             <td>" + book.getPlace() + "</td>\n" +
              "             <td>" + book.getPubclishingHouse() + "</td>\n" +
              "             <td>" +
              "                   <p><a href=\"/adminPanel?delBook=" + book.getBookId() + "\">Удалить </a></p>" +
              "             </td>\n" +
              "       </tr>");
    }
  }

  writer.println(
          "    </tbody>\n" +
                  "    </table>"
  );
%>