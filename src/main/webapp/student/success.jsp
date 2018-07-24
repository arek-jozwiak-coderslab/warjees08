<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>header.student.title</title>
</head>
<body>

<h3>${student.firstName} - ${student.lastName}</h3>
<h4>${student.studentGroup.name}</h4>
<ul>
    <c:forEach items="${student.drinks}" var="drink">
        <li>${drink.name} - ${drink.vol}</li>
    </c:forEach>
</ul>
</body>
</html>
