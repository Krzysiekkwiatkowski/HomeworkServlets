<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 02.10.18
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="someName" value="Witaj w coderslab."/>
<c:if test="${someName.contains('coderslab')}">
<p>OK</p>
</c:if>
</body>
</html>
