<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 27.09.18
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="number" begin="${start-1}" end="${end}">
    <c:out value="${number}"/>
</c:forEach>
</body>
</html>
