<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HR Rest Services</title>
</head>
<body>
    <h1>HR</h1>
    <ul>
        <li><a href="<c:url value='/rest/application.wadl/'/>">WADL</a>
        <li><a href="<c:url value='/rest/employees/'/>">Get All Employees (text or html)</a>
    </ul>
</body>
</html>


