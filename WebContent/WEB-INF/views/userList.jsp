<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 
</head>
<%@ include file="fragments/header.jspf" %>
<%-- <jsp:include page="fragments/header.jspf"/> --%>
<body>
<table>
	<tr>
		<th>FIRST NAME</th>
		<th>LAST NAME</th>
		<th>EMAIL</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.email}</td>
			<td><a href="edit/${user.id}" />edit </td>
			<td><a href="delete/${user.id}" />delete </td>
		</tr>
	</c:forEach>
</table>
<a href="add"> Add new user</a>
<br>
<a href="../"> Back to main menu</a>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>

