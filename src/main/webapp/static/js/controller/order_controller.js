'use strict';

angular.module('myApp').controller('OrderController', ['$scope', 'OrderService', function($scope, OrderService) {
    var self = this;
    self.order={id:'',customerID:'',customerName:'',productName:'',amount:'',status:'',createdDate:''};
    self.orders=[];
    
    self.ordersOfACustomer = [];
    
    self.customers=[];

    self.edit = edit;


    fetchAllOrders();
    
    fetchCustomers();

    function fetchAllOrders(){
        OrderService.fetchAllOrders()
            .then(
            function(d) {
                self.orders = d;
            },
            function(errResponse){
                console.error('Error while fetching Orders');
            }
        );
    }
    
    function fetchCustomers(){
    	OrderService.fetchCustomers()
        .then(
	        function(d) {
	            self.customers = d;
	            $scope.Customs = d;
	        },
	        function(errResponse){
	            console.error('Error while fetching Customer');
	        }
	    );
    }
    
    function fetchOrderOfCustomer(username){
    	OrderService.fetchOrderOfCustomer(username)
        .then(
	        function(d) {
	            self.ordersOfACustomer = d;
	        },
	        function(errResponse){
	            console.error('Error while fetching Orders of customer');
	        }
	    );
    }

    function updateOrder(order, id){
    	OrderService.updateOrder(order, id)
            .then(
            fetchAllOrders,
            function(errResponse){
                console.error('Error while updating asd Order');
            }
        );
    }
    
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.orders.length; i++){
            if(self.orders[i].id === id) {
                self.order = angular.copy(self.orders[i]);
                updateOrder(self.order, id);
                break;
            }
        }
        
        
    }
    
    $scope.GetValue = function (customer2) {
        var customerName = $scope.ddlCustomer;
        fetchOrderOfCustomer(customerName);
    }
    
    

}]);
