<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>numberPage</title>
</head>
<body>

<h1>USERS</h1>

<p></p>

<c:url var="mainUrl" value="/javarushtest/main/users"/>
<p>For jump to page ${pageNumber} click <a href="${mainUrl}">HERE</a></p>

</body>
</html>