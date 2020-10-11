<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 11.10.2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Person form with binding</title>
</head>
<body>
<div>Person form with binding:</div>
    <form:form method="post" modelAttribute="person">
        <div>
            <label for="login">Login</label>
            <form:input path="login"/>
        </div>
        <div>
            <label for="password">Password</label>
            <form:password path="password"/>
        </div>
        <div>
            <label for="email">Email</label>
            <form:input path="email" type="email"/>
        </div>
        <div>
            <label for="hobbies">Hobbies</label>
            <form:select path="hobbies" items="${hobbies}"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
