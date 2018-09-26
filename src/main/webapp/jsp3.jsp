<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 26.09.18
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> a = ${empty param.a ? "brak" : param.a} b = ${empty param.b ? "brak" : param.b} </h3>
</body>
</html>
