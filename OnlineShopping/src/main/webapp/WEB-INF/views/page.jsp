<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shooping -${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">
		<!------------------------------------------- Navigation Bar ----------------------------------------------->

		<%@include file="./shared/navbar.jsp"%>

		<!---------------------------------------------- Page Content ----------------------------------------->

		<div class="content">
			<!-------------------Loading the  Home Content ------------------>

			<c:if test="${isUserClickedHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user is clicked About -->
			<c:if test="${isUserClickedAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicked Contact -->
			<c:if test="${isUserClickedContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when user clicked All Products or Category Products -->
			<c:if
				test="${isUserClickedAllProducts == true or isUserClickedCategoryProducts == true }">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Load only when user clicked Show Product -->
			<c:if test="${isUserClickedShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Load only when user clicked Manage Product -->
			<c:if test="${isUserClickedManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user clicked Register -->
			<c:if test="${userClickedRegister == true}">
				<%@include file="register.jsp"%>
			</c:if>
			
			<!-- Load only when user clicked Login -->
			<c:if test="${isUserClickedLogin == true}">
				<%@include file="login.jsp"%>
			</c:if>
			
			<!-- Load only when user clicked Cart -->
			<c:if test="${isUserClickedCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
			

		</div>

		<!----------------------------------------- Footer ----------------------------------------------->

		<%@include file="./shared/footer.jsp"%>


		<!------------------------------ jQuery ------------------------------------------------->

		<script src="${js}/jquery.js"></script>
			
		<!--------------------------- jQuery Validator  --------------------------->
			
		<script src="${js}/jquery.validate.js"></script>	

		<!----------------------------- Bootstrap Core JavaScript -------------------------------------->

		<script src="${js}/bootstrap.min.js"></script>

		<!------------------------------------ DataTable Plugin ------------------------------------------->

		<script src="${js}/jquery.dataTables.js"></script>

		<!------------------------------------ DataTable Bootstrap Script ------------------------------------------->

		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!----------------------------------- Bootbox ---------------- -->
		
		<script src="${js}/bootbox.min.js"></script>

		<!----------------------------------Self coded javaScript ------------------------>

		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
