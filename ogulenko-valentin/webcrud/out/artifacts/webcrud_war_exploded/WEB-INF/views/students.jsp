<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qwerty
  Date: 17.02.2017
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3><a href="/newContact">New Contact</a></h3>
    <h3></h3>
    <table border="1">
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <c:forEach var="student" items="${listStudents}" varStatus="status">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td><a href="/deleteContact?id=${student.id}">Delete</a></td>
                <td><a href="/editContact?id=${student.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
