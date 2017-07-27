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
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet"> 
</head>
<%@ include file="fragments/header.jspf" %>
<%-- <jsp:include page="fragments/header.jspf"/> --%>
<body>

<div class="container">           
  <table class="table table-striped">
	<tr>
		<th>TITLE</th>
		<th>NOTES</th>
		<th>CREATED</th>
		<th>INGREDIENTS<th>
	</tr>
	<c:forEach items="${combinations}" var="combination">
		<tr>
			<td>${combination.title}</td>
			<td>${combination.notes}</td>
			<td>${combination.created}</td>
			<td>${combination.ingredientNames}</td>
			<td><a href="match/${combination.id}" />twist with new match </td>
			<td><a href="edit/${combination.id}" />edit </td>
			<td><a href="delete/${combination.id}" />delete </td>
		</tr>
	</c:forEach>
</table>
</div>
<a href="../user/">back</a>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>

