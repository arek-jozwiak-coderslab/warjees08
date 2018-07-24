
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add StudenTTTT
</h1>

<form:form method="post" modelAttribute="student">
    <div>Imię<form:input path="firstName" /> </div>
    <div>Nazwisko<form:input path="lastName" /></div>
    <div><form:select itemLabel="name" itemValue="id" path="studentGroup.id" items="${studentGroups}"/></div>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
