<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>

 <h3>Just login </h3>
    <form name="login" method="post" action="/loging/login">
        <h3>Login:</h3>
        <input type="text" name="login"/>
        <h3>Password:</h3>
        <input type="password"  name="password">
        <input type="submit" value="Отправить">
    </form>

 <h3>OR <a href="/loging/regist">Register NOW!!!</a></h3>

</body>
</html>