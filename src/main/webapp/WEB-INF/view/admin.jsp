<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.sstu.entity.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.sstu.entity.domain.Client" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Панель Администратора</title>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>
</head>
<body>
    <jsp:include page="menu.jsp" />
    <jsp:include page="adminMine.jsp" />
    <jsp:include page="footer.jsp" />
</body>
</html>