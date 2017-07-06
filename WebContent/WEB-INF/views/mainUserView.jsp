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
		<div class="panel">
			<a href="../combination/addultimate">Create new composition </a>!ULTIMATE MODE!<br>
		</div>
		<div class="panel">
		<a href="../combination/list">My compositions</a><br>
		</div>
		<div class="panel">
		<a href="../combination/add">Add existing composition</a><br>
		</div>
		<div class="panel">
		<a href="https://s-media-cache-ak0.pinimg.com/originals/b2/63/03/b26303aec913be35375165c57e8e1e24.jpg"> Suprise me!</a>(Recommendation engine - not working, YET!)<br>
		</div>
		<br>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/js1.js" />"></script>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>
