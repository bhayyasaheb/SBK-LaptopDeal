<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">


	<div class="row">
		<c:if test="${not empty message}">
	
			<div class="col-xs-12">
	
				<div class="alert alert-success alert-dismissible">
					
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					
					${message}
					
				</div>
	
			</div>

		</c:if>

	
	
	
	
	
	
		<div class="col-md-offset-2 col-md-8">
			
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					
					<h4 align="center">Register</h4>
					
				</div>
				
				<div class="panel-body">
				
					<!-- FORM ELEMENT -->
					<sf:form  class="form-horizontal" modelAttribute="register"
							action="${contextRoot}/register" method="POST">
					
						<div class="form-group">
							<label class="control-label col-md-4" for="first name">Enter First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="first_name" id="first name" placeholder="First Name" class="form-control"/>
								<sf:errors path="first_name" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="last name">Enter Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="last_name" id="last name" placeholder="Last Name" class="form-control"/>
								<sf:errors path="last_name" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
					     
					   <div class="form-group">
							<label class="control-label col-md-4" for="password">Enter Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password" placeholder="Enter Password" class="form-control"/>
								<sf:errors path="password" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<%-- <div class="form-group">
							<label class="control-label col-md-4" for="password">Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password" placeholder="Confirm Password" class="form-control"/>
								<sf:errors path="password" cssClass="help-block" element="em"/> 
							</div>
						</div> --%>
												
						<div class="form-group">
							<label class="control-label col-md-4" for="email">Enter Email Id</label>
							<div class="col-md-8">
								<sf:input type="email" path="email" id="email" placeholder="Email Id" class="form-control"/>
								<sf:errors path="email" cssClass="help-block" element="em"/> 
							</div>
						</div> 
						
						<div class="form-group">
							<label class="control-label col-md-4" for="contact_number">Enter Contact Number</label>
							<div class="col-md-8">
								<sf:input type="tel" path="contact_number" id="contactNumber" placeholder="Contact Number" class="form-control"/>
								<sf:errors path="contact_number" cssClass="help-block" element="em"/> 
							</div>
						</div> 
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="role">Select Role</label>
							<div class="col-md-8">
           						<label class="radio-inline">
     								 <sf:radiobutton path="role" name="user" value="USER"/>User
  						    	</label>
  						   		<label class="radio-inline">
     								 <sf:radiobutton path="role" name="supplier" value="SUPPLIER"/>Supplier
  						   		</label>
  						   		<sf:errors path="role" cssClass="help-block" element="em"/>
        					</div>
						</div>
						
						
						<div class="form-group">		
							<div class="col-md-offset-4 col-md-8">	
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
								
								<!-- Hidden fields for User -->
								<sf:hidden path="id"/>
								<sf:hidden path="enabled"/>
							</div>
						</div>
					</sf:form>
					
				</div>
				
			</div>
			
		</div>
	
	</div>

</div>