<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">back to home</a>
<br />
<br />
<h1>Employee list</h1>
<c:if test="${!empty listEmployees}">
    <table class="tg">
        <tr>
            <th width="100">ID</th>
            <th width="120">Name</th>
            <th width="120">Department</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>
                <td>${employee.empId}</td>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td><a href="<c:url value='/edit/${employee.empId}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${employee.empId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add employee</h1>

<c:url var="addAction" value="/employees/add"/>

<form:form action="${addAction}" commandName="employee">
    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="department">
                    <spring:message text="Department"/>
                </form:label>
            </td>
            <td>
                <form:input path="department"/>
            </td>
        </tr>
        <tr>
            <td >

                <c:if test="${empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Add employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
