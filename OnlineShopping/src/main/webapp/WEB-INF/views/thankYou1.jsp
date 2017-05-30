<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<head>
<spring:url var="css" value="/resources/css" />
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
</head>


<div class="container" style="margin-top:5%;">
	<div class="row">
        <div class="jumbotron" style="box-shadow: 2px 2px 4px #000000;">
        <h2 class="text-center">Your Order is Placed Successfully </h2>
            <h2 class="text-center">Thank you for Visiting <span style="color:#F89406;">The</span><span style="color:#26A65B;"> Online</span><span style="color:#19B5FE;"> Shopping</span></h2>
            <center><div class="btn-group" style="margin-top:50px;">
                <a href="${contextRoot}/home" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-home"></span> Home</a>
            </div></center>
        </div>
	</div>
</div>