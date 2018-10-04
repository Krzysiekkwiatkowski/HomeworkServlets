<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 04.10.18
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/HM5" method="post">
    Odlot: <select name="departure" >
    <c:forEach items="${airports}" var="airport">
        <option value="${airport.name}"> ${airport.name} </option>
    </c:forEach>
</select></br>
    Przylot: <select name="arrival">
    <c:forEach items="${airports}" var="airport">
        <option value="${airport.name}"> ${airport.name} </option>
    </c:forEach>
</select></br>
    Czas odlotu: <input type="datetime-local" name="date" value="2017-06-01T08:30"></br>
    Długość lotu w godzinach: <input type="number" name="length" min="0" step="1"></br>
    Cena: <input type="number" name="price" min="0" step="0.01"></br>
    <input type="submit" value="Zamów">
</form>
</body>
</html>
