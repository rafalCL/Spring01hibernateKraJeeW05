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
    <title>Book add form</title>
</head>
<body>
<div>Add new book:</div>
    <form:form method="post" modelAttribute="book">
        <div>
            <label for="title">title</label>
            <form:input path="title"/>
            <form:errors path="title"/>
        </div>
        <div>
            <label for="rating">rating</label>
            <form:input path="rating" type="number" min="0" max="10"/>
            <form:errors path="rating"/>
        </div>
        <div>
            <label for="description">description</label>
            <form:textarea path="description"/>
            <form:errors path="description"/>
        </div>
        <div>
            <label for="publisher">publisher</label>
            <form:select path="publisher" items="${publishers}" id="publisher" itemLabel="name" itemValue="id"/>
            <form:errors path="publisher"/>
        </div>
        <div>
            <label for="pages">pages</label>
            <form:input path="pages" type="number" min="0"/>
            <form:errors path="pages"/>
        </div>
        <div>
            <form:errors path="*"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>
</body>
</html>
