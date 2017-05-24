<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<fmt:setLocale value="en_US" scope="session"/>
	
	<div class="page-title">My Cart</div>
	
	<c:if test="${empty cart or empty cart.cartItems }">
		<h2>There is no item in Cart</h2>
		<a href="${contextRoot}/show/all/products">View Product</a>
	</c:if>
	
	<c:if test="${not empty cart or not empty cart.cartItems}">
	
		<sf:form method="POST" modelAttribute="cart" action="${contextRoot}/cart">
		
			<c:forEach items="${cart.cartItems} var="cartItem">
			
			
					<div class="product-preview-container">
						<ul>
							<li><img class="product-image" alt="" src="${contextRoot}/resources/images/'+code+'.jpg"></li>
							
							<li></li>
						</ul>
					</div>
			</c:forEach>
		
		</sf:form>
	</c:if>
	
</body>
</html>
 --%>
 
 <link href="/resources/css/cart.css" rel="stylesheet">
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	
	<c:if test="${isEmpty}">
		<h2>There is no item in Cart</h2>
		<a href="${contextRoot}/show/all/products">View Product</a>
	</c:if>
	
	<c:if test="${!isEmpty}">
	<sf:form method="POST" modelAttribute="cart" action="${contextRoot}/cart">
	
	
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach  var="cartItem"  items="${cartItem}">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${contextRoot}/resources/images/${cartItem.product.code}.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartItem.product.name}</h4>
										<p>${cartItem.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cartItem.product.unitPrice}</td>
							<td data-th="Quantity">${cartItem.quantity}</td>
							<!-- 	<input type="number" class="form-control text-center" value="1">
							</td> -->
							<td data-th="Subtotal" class="text-center">${cartItem.totalAmount}</td>
							<td class="actions" data-th="">
								<!-- <button class="btn btn-info btn-md"><i class="fa fa-refresh"></i></button>
								<button class="btn btn-danger btn-md"><i class="fa fa-trash-o"></i></button> -->
									
								 <a href="${contextRoot}/cart/delete/${cartItem.id}" class="btn btn-primary" data-toggle="tooltip"
										data-placement="bottom" title="Remove"><span class="glyphicon glyphicon-trash"></span></a>							
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total $1.99</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
				
				
				</sf:form>
				</c:if>
</div>