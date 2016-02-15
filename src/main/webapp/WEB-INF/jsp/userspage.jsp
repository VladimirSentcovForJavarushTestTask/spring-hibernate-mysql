<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User page</title>
</head>
<br>
<h1>Users on page ${pageNumber}</h1>


<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#ff2c2a">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Is admin</th>
        <th>Age</th>
        <th>Since</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <c:url var="editUrl" value="/javarushtest/main/users/edit?id=${user.id}"/>
        <c:url var="deleteUrl" value="/javarushtest/main/users/delete?id=${user.id}"/>
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.admin}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.date}"/></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

There are currently users in the list.<br/>

<c:url var="addUrl" value="/javarushtest/main/users/add"/>
<a href="${addUrl}">Add a user</a>


<c:url var="setURL" value="/javarushtest/main/users/setName"/>
<br><a href="${setURL}">set name for request </a></html
</br>

<br>
<c:url var="setURLSQL" value="/javarushtest/main/users/setSQL"/>
<a href="${setURLSQL}">set SQL for request </a>
<br>
<c:if test="${!empty name}">You get users with name ${name}</c:if>
<c:if test="${!empty searchFromSQL}">You get users by SQL request ${searchFromSQL}</c:if>
<br>
<br>Pages____________________________________________</br>

<c:forEach items="${pages}" var="page">
    <c:url var="userURL" value="/javarushtest/main/users/page?id=${page}"/>
    <a href="${userURL}"><c:out value="${page}"/></a>
</c:forEach>

</body>

</html>