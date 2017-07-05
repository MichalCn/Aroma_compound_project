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
		<h3>User page</h3>
		<br>
		<a href="../combination/list">My combinations</a><br>
		<a href="../combination/add">Create new combination</a><br>
		<a > Upgrade/Twist existing recipe - not working</a><br>
		<a > Suprise me! = Recommend - not working</a><br>
		<br>
		<a href="../"> <-- back to main page</a><br>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/js1.js" />"></script>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>
