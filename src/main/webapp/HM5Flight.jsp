<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 06.10.18
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px solid black" style="text-align: center">
    <tr>
        <th> Departure </th>
        <th> Arrival </th>
        <th> Flight length </th>
        <th> Price </th>
    </tr>
    <tr>
        <td> ${flight.departure} </td>
        <td> ${flight.arrival} </td>
        <td> ${length} h </td>
        <td> ${flight.price} zł </td>
    </tr>
</table>
</body>
</html>
