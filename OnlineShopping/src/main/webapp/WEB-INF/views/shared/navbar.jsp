<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">Online
				Shopping</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="about"><a href="${contextRoot}/about">About</a></li>

				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>

				<li id="listProducts"><a
					href="${contextRoot}/show/all/products">View Products</a></li>
					
			<security:authorize access="hasAuthority('ADMIN')">		
				<li id="manageProducts"><a
					href="${contextRoot}/manage/products">Manage Products</a></li>	
			</security:authorize>				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			<security:authorize access="! isAuthenticated()">
				<li id="login"><a
					href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li id="register"><a
					href="${contextRoot}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">	
				<li id="logout"><a
					href="${contextRoot}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>		
			</security:authorize>	
   		   </ul>
			
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>
</body>
</html>