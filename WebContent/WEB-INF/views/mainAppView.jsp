<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div class="main">
		<h3>Hello page!</h3>
		<br>
		<a href="./user/login"> Login</a><br>
		<a href="./user/register"> Register</a><br>
		<br>
		<a href="./combination/add"> Add combination</a><br>
		<br>
		<h4 class="sliders"> Admin</h4>
		<div class="nonvisible">
			<a href="./user/list"> Users list</a><br>
			<a href="./user/authenticated"> Authenticated</a><br>
			<a href="./ingredient/add1"> Generate ingredients</a><br>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/js1.js" />"></script>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>
