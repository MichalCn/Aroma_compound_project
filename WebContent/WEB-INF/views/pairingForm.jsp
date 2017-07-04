<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="pairing"> 
		<form:errors path="ingredient1" cssClass="error" element="div"/>
		Ingredient 1: <form:select  path="ingredient1" items="${ingredients}" itemLabel="name" itemValue="id"/><br>
		<form:errors path="ingredient2" cssClass="error" element="div"/>
		Ingredient 2: <form:select  path="ingredient2" items="${ingredients}" itemLabel="name" itemValue="id"/><br>
		<form:errors path="rel" cssClass="error" element="div"/>
		Force:<form:input path="rel" /><br>
		
		<input type="submit" value="Submit">
	</form:form>
	<a href="..${path}/list"> back</a>
	<br>
</body>
</html>