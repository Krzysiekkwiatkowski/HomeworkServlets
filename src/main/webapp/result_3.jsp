<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 27.09.18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty books}">
    <c:forEach items="${books}" var="book">
        <c:out value="${book.title} - ${book.author}"/></br>
    </c:forEach>
</c:if>
<c:if test="${empty books}">
   Brak książek do wyświetlenia!
</c:if>
</body>
</html>
