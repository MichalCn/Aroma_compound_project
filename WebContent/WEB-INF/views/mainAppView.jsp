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
	<link href="<c:url value="/resources/css/bootstrapBusiness.css" />" rel="stylesheet"> 
	<link href="<c:url value="/resources/css/business-frontpage.css" />" rel="stylesheet">
</head>
<%@ include file="fragments/header.jspf" %>
<%-- <jsp:include page="fragments/header.jspf"/> --%>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="./user/login">Login</a>
                <a class="navbar-brand" href="./user/register">Register</a>
                <a class="navbar-brand" href="./user/">User page</a>
                		
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    <li>
                        <a href="http://developer.foodpairing.com/">Foodpairing</a>
                    </li>
                    <li>
                        <a href="http://docs.foodpairingpublicapi.apiary.io/#">Foodpairing API</a>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Image Background Page Header -->
    <!-- Note: The background image is set within the business-casual.css file. -->
    <header class="business-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="tagline">Food ingredients matched by magic and chemistry</h1>
                </div>
            </div>
        </div>
    </header>

    <!-- Page Content -->
    <div class="container">

        <hr>

        <div class="row">
            <div class="col-sm-8">
                <h2>What We Do</h2>
                <p>Introduce the visitor to the business using clear, informative text. Use well-targeted keywords within your sentences to make sure search engines can find the business.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et molestiae similique eligendi reiciendis sunt distinctio odit? Quia, neque, ipsa, adipisci quisquam ullam deserunt accusantium illo iste exercitationem nemo voluptates asperiores.</p>
                <p>
                    <a class="btn btn-default btn-lg" href="#">Call to Action &raquo;</a>
                </p>
            </div>
            <div class="col-sm-4">
                <h2>Contact Us</h2>
                <address>
                    <strong>Start Bootstrap</strong>
                    <br>3481 Melrose Place
                    <br>Beverly Hills, CA 90210
                    <br>
                </address>
                <address>
                    <abbr title="Phone">P:</abbr>(123) 456-7890
                    <br>
                    <abbr title="Email">E:</abbr> <a href="mailto:#">name@example.com</a>
                </address>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <div class="row">
            <div class="col-sm-4">
                <img class="img-circle img-responsive img-center" src="https://www.foodpairing.com/Media/Image/07b46adb-70e3-4fd4-bf06-e3e933c7212d.jpg" alt="">
                <h2>Marketing Box #1</h2>
                <p>These marketing boxes are a great place to put some information. These can contain summaries of what the company does, promotional information, or anything else that is relevant to the company. These will usually be below-the-fold.</p>
            </div>
            <div class="col-sm-4">
                <img class="img-circle img-responsive img-center" src="https://www.foodpairing.com/Media/Image/7b550f81-2b09-4ebf-bcfc-f0bc0ac8a1d3.jpg" alt="">
                <h2>Marketing Box #2</h2>
                <p>The images are set to be circular and responsive. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
            </div>
            <div class="col-sm-4">
                <img class="img-circle img-responsive img-center" src="https://blog-assets.foodpairing.com/2017/03/FP-header-cooked-artichoke.png" alt="">
                <h2>Marketing Box #3</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; MC 2017</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/js1.js" />"></script>
</body>
</html>
<%@ include file="fragments/footer.jspf" %>
