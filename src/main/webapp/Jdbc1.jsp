<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 27.09.18
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add-book" method="post">
    Title: <input type="text" name="title">
    Author: <input type="text" name="author">
    Isbn: <input type="text" name="isbn">
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
