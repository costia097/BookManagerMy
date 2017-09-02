<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
  <title>BookData</title>
</head>
<body>
<h1>Book Details</h1>
<h3>Hello  ${user.userLogin}</h3>

Add track: <a href="#">Delete</a>

<form:form action="addBook" commandName="user" >
  <tr>
    <td align="left" width="20%">Login: </td>
    <td align="left" width="40%"><form:input path="userLogin" size="30" autocomplete="false"/></td>
  </tr>
  <tr>
    <td>Url track: </td>
    <td><form:input path="userEmail" size="30" autocomplete="false"/></td>
  </tr>
  <tr>
    <td></td>
    <td align="center"><input type="submit" value="Add Now"/></td>
    <td></td>
  </tr>
</form:form>

Delete track: Soon

its you tracks:
<br>
<c:forEach items="${user.books}" var="books">
  <br>
  <h2>${books.bookName}</h2> <h3>${books.bookAuthor}</h3>
  <img src="${books.bookUrlImg}" alt="альтернативный текст" width="100" height="100">
  <br>
  <audio controls>
    <source src="${books.bookAudioUrl}" type="audio/mpeg">
  </audio>
</c:forEach>
</table>
</body>
</html>