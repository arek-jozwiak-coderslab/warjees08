
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add Person
</h1>

<form:form method="post" modelAttribute="person">
    <div>firstName<form:input path="firstName" />
        <form:errors path="firstName"  cssStyle="color: red"/>
    </div>
    <div>lastName<form:input path="lastName" />
        <form:errors path="lastName" />
    </div>


    <input type="submit" value="Save">
</form:form>

</body>
</html>
