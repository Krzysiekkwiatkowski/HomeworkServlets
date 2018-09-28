<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 28.09.18
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
<tr>
    <th> Id </th>
    <th> Title </th>
    <th> Author </th>
    <th> Isbn </th>
    <th> Action </th>
</tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td> ${book.id} </td>
        <td> ${book.title} </td>
        <td> ${book.author} </td>
        <td> ${book.isbn} </td>
        <td> <a href="http://localhost:8080/edit-book?id=${book.id}"> Edit </a> / <a href="http://localhost:8080/delete-book?id=${book.id}"> Delete </a> </td>
    </tr>
</c:forEach>
</table>
</br>
<form action="/search-book" method="post">
    Podaj tytuł lub jego część: <input type="text" name="title">
    <input type="submit" value="Szukaj">
</form>
</body>
</html>
