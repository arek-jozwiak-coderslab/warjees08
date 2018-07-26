<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${infomessage}
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Author</td>
        <td>Akcja</td>
    </tr>
    </thead>
<c:forEach items="${books}" var="book">
<tr>
    <td>${book.id}</td>
    <td>${book.title}</td>
    <td>${book.author.firstName} ${book.author.lastName}</td>
    <td>
        <a href="/delete/${book.id}">Delete</a>
    </td>
</tr>

</c:forEach>

</table>
</body>
</html>
