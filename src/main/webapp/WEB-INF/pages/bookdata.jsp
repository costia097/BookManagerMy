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
<h3>Hello  ${user.user_login}</h3>
its you books:
<br>
<c:forEach items="${user.books}" var="books">
  ${books.book_name}<br>
  ${books.book_author}<br>
  <img src="${books.book_url_img}" alt="альтернативный текст" width="200" height="200">
  <br>
  <br>
  <audio controls>
    <source src="${books.book_audio_url}" type="audio/mpeg">
  </audio>
</c:forEach>
</table>
</body>
</html>