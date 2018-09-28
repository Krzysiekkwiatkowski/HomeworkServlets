<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 28.09.18
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit-book" method="post">
    <input type="hidden" name="id" value="${book.id}">
    Title: <input type="text" name="title" value="${book.title}">
    Author: <input type="text" name="author" value="${book.author}">
    Isbn: <input type="text" name="isbn" value="${book.isbn}">
    <input type="submit" value="Edytuj">
</form>
</body>
</html>
