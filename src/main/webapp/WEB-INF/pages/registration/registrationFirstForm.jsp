<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Registration form</h2>
    <table border="0" width="90%">
        <form:form action="registration" commandName="userRegist">
            <tr>
                <td align="left" width="20%">Login: </td>
                <td align="left" width="40%"><form:input path="user_login" size="30"/></td>
                <td align="left"><form:errors path="user_login" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:password path="user_password" size="30"/></td>
                <td><form:errors path="user_password" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><form:input path="user_email" size="30"/></td>
                <td><form:errors path="user_email" cssClass="error"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><input type="submit" value="Registrate Now"/></td>
                <td></td>
            </tr>
        </form:form>
    </table>

    <a href="/">Go back toMain menu</a>
</div>
</body>
</html>