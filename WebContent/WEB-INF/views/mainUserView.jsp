<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">  --%>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link href="<c:url value="/resources/css/sb-admin-2.css" />" rel="stylesheet"> 
</head>
<%@ include file="fragments/header.jspf" %>
<%-- <jsp:include page="fragments/header.jspf"/> --%>
<body>
	<div class="main">
	<h3>User page</h3>
	
	<div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Create new<br>composition</div>
                                    <div></div>
                                </div>
                            </div>
                        </div>
                        <a href="../combination/addultimate">
                            <div class="panel-footer">
                                <span class="pull-left">The ULTIMATE mode! GO!</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right">--></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">My<br>compositions</div>
                                    <div></div>
                                </div>
                            </div>
                        </div>
                        <a href="../combination/list">
                            <div class="panel-footer">
                                <span class="pull-left">Check out Your perfect creations :)</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right">--></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Add existing<br>composition</div>
                                    <div></div>
                                </div>
                            </div>
                        </div>
                       	<a href="../combination/add">
                            <div class="panel-footer">
                                <span class="pull-left">Upload existing recipe and give it a twist!</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right">--></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Suprise me!<br></div>
                                    <div class="huge2">Recommendation engine</div>
                                </div>
                            </div>
                        </div>
                        <a href="https://s-media-cache-ak0.pinimg.com/originals/b2/63/03/b26303aec913be35375165c57e8e1e24.jpg">
                            <div class="panel-footer">
                                <span class="pull-left">Not working... YET!!</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right">--></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/js1.js" />"></script>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>
