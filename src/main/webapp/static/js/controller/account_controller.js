'use strict';

angular.module('myApp').controller('AccountController', ['$scope', 'AccountService', function($scope, AccountService) {
    var self = this;
    self.customer={id:'',username:'',password:'',firstName:'',lastName:'',buildingNo:'',floorNo:'',roomNo:''};
    
    
    
    self.myorder={id:null, customerID:'', customerName:'', productName:'', amount:'', status:'', createdDate:''};
    
    self.products = [];
    
    
    self.orders = [];
    
    self.submit = submit;
    self.gorder = gorder;
    
    
    fetchCustomer();
    
    fetchAllProducts();
    
    fetchCustomerOrder();
    
    function fetchAllProducts(){
    	AccountService.fetchAllProducts()
            .then(
            function(d) {
                self.products = d;
                $scope.Products = d;
            },
            function(errResponse){
                console.error('Error while fetching Products');
            }
        );
    }
    
    
    

    function fetchCustomer(){
    	AccountService.fetchCustomer()
            .then(
            function(d) {
                self.customer = d;
                
            },
            function(errResponse){
                console.error('Error while fetching Customer');
            }
        );
    }

    function giveOrder(myorder){
    	AccountService.giveOrder(myorder)
	        .then(
	        		fetchCustomerOrder, 
	        function(errResponse){
	            console.error('Error while updating Customer');
	        }
	    );

    }

    function updateCustomer(customer, id){
    	AccountService.updateCustomer(customer, id)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while updating Customer');
            }
        );
    }

    function fetchCustomerOrder(){
        AccountService.fetchCustomerOrder()
            .then(
            function(d) {
                self.orders = d;
            },
            function(errResponse){
                console.error('Error while fetching Customer Orders');
            }
        );
    }

    function submit() {
        
    	updateCustomer(self.customer, self.customer.id);
        console.log('Csutomer updated with id ', self.customer.id);

    }

    function gorder(){
    	console.log($scope.ddlFruits+'  '+self.myorder.amount);
    	
    	self.myorder.customerID = self.customer.id;
    	self.myorder.customerName = self.customer.username;
    	self.myorder.productName = $scope.ddlProduct;
    	self.myorder.status = 'yeni';
    	self.myorder.createdDate = new Date();
    	
    	giveOrder(self.myorder);
    	
    }


}]);
