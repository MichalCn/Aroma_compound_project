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
<body>
	<div class="main">
		<h3 id="ten">New user registration</h3>
		<p></p>
		<form:form method="post" modelAttribute="user">

			<span class="error"> <form:errors path="login"
					cssClass="error" element="div" />
			</span>
		Login:<form:input path="login" />required<br>
			<span class="error"> <form:errors path="password"
					cssClass="error" element="div" />
			</span>
		Password: <form:password path="password" />required<br>

			<p>slider start</p>
			<span class="error"> <form:errors path="firstName"
					cssClass="error" element="div" />
			</span>
		First Name:<form:input path="firstName" />not required<br>
			<span class="error"> <form:errors path="lastName"
					cssClass="error" element="div" />
			</span>
		Last Name: <form:textarea path="lastName" />not required<br>
			<span class="error"> <form:errors path="email"
					cssClass="error" element="div" />
			</span>
		Email: <form:input path="email" />not required<br>
			<p>slider finish</p>

			<span class="error"> <form:errors path="acceptRules"
					cssClass="error" element="div" />
			</span>
		I accept rules & conditions:<form:checkbox path="acceptRules" />
			<br>

			<input type="submit" value="Submit">
		</form:form>
	</div>
	<a href="../"> <-- back</a>

</body>
</html>
<%@ include file="fragments/footer.jspf" %>