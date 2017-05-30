

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
		
		<!-- Billing Address -->
				<div class="col-md-offset-2 col-md-8">
			
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					
					<h4 align="center">Shipping Address</h4>
					
				</div>
				
				<div class="panel-body">
				
					<!-- FORM ELEMENT -->
					<sf:form  class="form-horizontal" modelAttribute="shippingAddress"
							action="${contextRoot}/shippingAddress" method="POST">
					
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" id="first name" placeholder="Enter Address Line One" class="form-control"/>
								<sf:errors path="addressLineOne" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo" id="last name" placeholder="Enter Address Line Two" class="form-control"/>
								<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" id="dob" placeholder="Enter City" class="form-control"/>
								<sf:errors path="city" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" id="postalcode" placeholder="Enter Postal code" class="form-control"/>
								<sf:errors path="postalCode" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
					     
					   <div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" id="state" placeholder="Enter State Name" class="form-control"/>
								<sf:errors path="state" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						
						
						<div class="form-group">		
							<div class="col-md-offset-4 col-md-8">	
								<input type="submit" name="submit"  id="submit" value="Next" class="btn btn-primary"/>
								
								<!-- Hidden fields for Shipping Address -->
								<sf:hidden path="id"/>
								<sf:hidden path="shipping"/>
								<sf:hidden path="billing"/>
							</div>
						</div>
						
						
								
								
							
					</sf:form>
					
				</div>
				
			</div>
			
		</div>
		
		
		
			
		
	
		
	</div>

</div>