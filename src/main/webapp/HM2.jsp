<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 02.10.18
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${numbers}" var="number" begin="1"  step="2">
${number}</br>
</c:forEach>
</body>
</html>
