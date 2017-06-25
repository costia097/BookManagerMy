<%--
  Created by IntelliJ IDEA.
  User: BeNdEr
  Date: 21.06.2017
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<%--//TODO VALIDATOR!!!--%>
<form action="/loging/register" method="post">
<h3>Login:</h3> <input type="text" name="login"/>
<h3>Password:</h3> <input type="password" name="password"/>
<h3>Email:</h3> <input type="text" name="email"/>
<h3>Bio:</h3> <input type="text" size="200px" height="200px" name="bio">
<input type="submit" value="Регестрация"/>
</form>
</body>
</html>
