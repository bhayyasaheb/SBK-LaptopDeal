(function(){
	
	
	var app = angular.module("cart",[]);
	
	app.controller('cal',[
							'$http',
							'$scope',
							'$q',
							
							function ($http, $scope,$q){
								$scope.quantity = 1;
								$scope.cartItems = [];
								$scope.grandTotal = 
								$scope.isEmpty = false;
								
								// method to fetch the cart items 
								$scope.fetchCartItems = function() {
									
									fetchCartItemsRest().then(
											function(cartItems) {
												debugger;
												console.log(cartItems);
												
												$scope.cartItems = cartItems;
												if($scope.cartItems.length == 0) {
													$scope.isEmpty = true;
												}
												
												$scope.grandTotal = $scope.cartItems[0].cart.grandTotal;
											},
											function(errRespone) {
												console.log('Failure');
											}
									)
								}
								
								function fetchCartItemsRest() {
									console.log('Now fetching...');
									var deferred = $q.defer();
									
									$http.get('/').then(
											function(response) {
												deferred.resolve(response.data);
											},
											function(errResponse) {
												deferred.reject(errResponse);
											}
									);
									return deferred.promise;
								}
								
								// method to update cart on change of quantity
								
								$scope.update = function(cartItem) {
									debugger;
									console.log(cartItem);
									updateCart(cartItem).then(
												function(cartItem) {
													console.log("Updated the cart Successfully!");
													$scope.fetchCartItems();
												},
												function(errResponse){
													console.log("Failure!");
												}
									)
								}
								
								
								function updateCart(cartItem) {
									
									console.log("Now updating the cart!");
									var deferred = $q.defer();
									console.log(cartItem.id + "has" + cartItem.quantity)
									$http.post('/' + cartItem.id +'/' +cartItem.quantity).then(
											
											function(response) {
												deferred.resolve(response.data);
											},
											function(errResponse){
												deferred.reject(errResponse);
											}
										);
									return deferred.promise;
								}
								
							}
							
							
						]);		
						
						
})();