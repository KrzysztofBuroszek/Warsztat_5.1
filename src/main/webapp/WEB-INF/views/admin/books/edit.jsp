<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 28/03/2021
  Time: 07:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h1>Edit ID: <c:out value="${bookEdit.get().id}"/></h1>



<form:form method="put" modelAttribute="bookEdit" action="${edit_url}">

<%--    title: <c:out value="${bookEdit.get().title}"/>--%>
    Title: <form:input path="title"/><br>
    Author: <form:input path="author"/><br>
    Isbn: <form:input path="isbn"/><br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
