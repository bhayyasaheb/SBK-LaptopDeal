<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<!-- Breadcrumb -->

		<div class="row">

			<div class="col-xs-12">

				<ol class="breadcrumb">

					<li><a href="${contextRoot}/home">Home</a></li>
					<li><a href="${contextRoot}/show/all/products">Products</a></li>
					<li class="active">${product.name}</li>

				</ol>

			</div>

		</div>

		<div class="row">

			<!--------------------------------- Display the Product Image ------------------------>

			<div class="col-xs-12 col-sm-4">

				<div class="thumbnail">

					<img alt="" src="${images}/${product.code}.jpg"
						class="img img-responsive" />

				</div>

			</div>

			<!------------------- Display the Product Description --------------------------->

			<div class="col-xs-12 col-sm-8"></div>

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr>

			<h4>
				Price: <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />


			<!--------------------- Displaying Out of Stock in Red Color when Quantity is less than Zero----------------------->
			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock</span>
					</h6>

				</c:when>

				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>

			</c:choose>

			<!--------------------- Disable Add to Cart Button when Quantity is less than Zero ------------------------>
			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
							<span class="glyphicon glyphicon-shopping-cart"></span> Add to
							Cart
					</strike></a>
				</c:when>

				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
					</a>
				</c:otherwise>

			</c:choose>

			<!----------------------------------- Back Button --------------------------------------->

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

		</div>

	</div>
</body>
</html>