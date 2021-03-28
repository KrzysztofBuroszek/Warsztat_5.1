<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 26/03/2021
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>get</title>
</head>
<body>

<h1>Książka o ID:<c:out value="${idBook}"/></h1>


title: <c:out value="${title}"/><br>
author: <c:out value="${author}"/><br>
isbn: <c:out value="${isbn}"/><br>


</body>
</html>
