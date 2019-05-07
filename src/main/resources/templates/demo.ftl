<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarket</title>
</head>
<body>
<div>
    <table border="1" align="center" width="50%">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>gender</td>
        </tr>
        <#list userList as user>
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.gender}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>