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
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>
<form method="post">
    First name: <input type="text" name="firstName"><br>
    Last name: <input type="text" name="lastName"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
