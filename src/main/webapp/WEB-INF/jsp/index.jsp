<%@page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>index</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>gender</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>
</table>

</body>

</html>