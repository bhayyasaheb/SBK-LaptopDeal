<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">
		
		<div class="col-md-offset-3 col-md-6">
			
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4 align="center">Login Here</h4>		
				</div>
				
				<div class="panel-body">
					<div class="form-login">
					<!-- FORM ELEMENT -->
					
					
						
						<c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                        
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            
						
						<div class="form-group">
							<label class="control-label col-md-3" for="email">User Name</label>
							<div class="col-md-8">
								<input type="text" name="email"  id="email" required="required" class="form-control"/>
								
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3" for="password">Password</label>
							<div class="col-md-8">
								<input type="password" name="password" id="password" required="required"  class="form-control"/>
								
							</div>
						</div>
						
						<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
						
						<div class="form-group">		
							<div class="col-md-offset-5 col-md-8">	
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
							</div>
						</div>
						
						
					
					</form>
					</div>
				</div>
				
			</div>
			
		</div>
		
	</div>


</div>