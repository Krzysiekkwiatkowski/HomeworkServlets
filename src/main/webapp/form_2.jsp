<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 27.09.18
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Mvc152" method="post">
    Title1: <input type="text" name="title1">
    Author1: <input type="text" name="author1">
    Isbn1: <input type="text" name="isbn1"></br>
    Title2: <input type="text" name="title2">
    Author2: <input type="text" name="author2">
    Isbn2: <input type="text" name="isbn2"></br>
    Title3: <input type="text" name="title3">
    Author3: <input type="text" name="author3">
    Isbn3: <input type="text" name="isbn3"></br>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
