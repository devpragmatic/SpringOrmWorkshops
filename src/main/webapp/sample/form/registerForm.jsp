<%--
  Created by IntelliJ IDEA.
  User: NB42RP
  Date: 2019-06-21
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>
<form:form method="post"
           modelAttribute="student">
    <form:hidden path="firstName" />
    <form:input path="lastName" />
    <form:checkboxes items="${languages}" path="languages" />
    <form:checkboxes  path="skills" items="${skills}"
                      itemLabel="name" itemValue="id" />
    <form:select path="lang">
        <form:option value="-" label="--Please Select--"/>
        <form:option value="F" label="Female"/>
        <form:option value="M" label="Male"/>
    </form:select>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
