<%-- <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />



<link href="${css}/checkout.css" rel="stylesheet">



<div class="container">
	<div class="col-md-offset-2 col-md-8">
				<div class="panel panel-primary">
						<div class="panel-heading">
							<span><i class="glyphicon glyphicon-lock"></i></span> Secure
							Payment
						</div>
						
					<div class="panel-body">
						
							<div class="form-group">
								<label class="control-label col-md-4" for="cardType">Card Type :</label>
									<div class="col-md-8">
										<select id="CreditCardType" name="CreditCardType"
											class="form-control">
											<option value="5">Visa</option>
											<option value="6">MasterCard</option>
											<option value="7">American Express</option>
											<option value="8">Discover</option>
										</select>
									</div>	
							</div>
			
							<div class="form-group">
								<label class="control-label col-md-4" for="cardNumber">Credit Card Number:</label>
									<div class="col-md-8">
										<input  type="text" name="cardNumber" id="cardNumber" placeholder="Card Number" class="form-control"/>	
									</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4" for="cvv"> Card CVV:</label>
									<div class="col-md-8">
										<input  type="text" name="cvv" id="v" placeholder="Card CVV" class="form-control"/>	
									</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4" for="cvv"> Expiration Date:</label>
									<div class="col-md-4">
										<select class="form-control" name="">
										<option value="">Month</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										</select>	
									</div>
									
									<div class="col-md-4">
										<select class="form-control" name="">
										<option value="">Year</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
										<option value="2024">2024</option>
										<option value="2025">2025</option>
										</select>
									</div>
							</div>
						
							<div class="form-group">
								<label class="control-label col-md-4" for="cvv">Pay secure using your credit card</label>
									<div class="col-md-8">
										<ul class="cards">
										<li class="visa hand">Visa</li>
										<li class="mastercard hand">MasterCard</li>
										<li class="amex hand">Amex</li>
										</ul>
										<div class="clearfix"></div>
									</div>
							</div>
						
							<div class="form-group">		
								<div class="col-md-offset-4 col-md-8">	
								<button type="submit" class="btn btn-primary btn-submit-fix">Place
										Order</button>
								</div>
						  </div>
		
					</div>
				</div>
		</div>		
</div> --%>