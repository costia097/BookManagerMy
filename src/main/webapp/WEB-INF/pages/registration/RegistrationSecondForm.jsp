<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email validation</title>
</head>
<body>

On your email was sent message with code. Enter here this code to check
<form:form action="checkCode" commandName="userRegist">
    <td></td>
    ${kode}
    Введите код выше:
    <form:password path="userPassword"/>
    <td></td>
    <form:password path="userCode"/>
    <td></td>
    <td align="center"><input type="submit" value="Check"/></td>
    <td></td>
</form:form>

</body>
</html>
