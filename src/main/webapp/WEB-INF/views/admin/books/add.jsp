<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 26/03/2021
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>add</title>
</head>
<body>

<form:form method="post"
           modelAttribute="book">
    isbn:  <form:input path="isbn"/>
    <form:errors path="isbn"/><br/>
    title: <form:input path="title"/>
    <form:errors path="title"/><br/>
    author: <form:input path="author"/>
    <form:errors path="author"/><br/>
    publisher: <form:input path="publisher"/>
    <form:errors path="publisher"/><br/>
    type: <form:input path="type"/>
    <form:errors path="type"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>



