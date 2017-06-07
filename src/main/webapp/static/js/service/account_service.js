'use strict';

angular.module('myApp').factory('AccountService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/Spring4MVCAngularJSExample/customer/';
    var REST_SERVICE_URI2 = 'http://localhost:8080/Spring4MVCAngularJSExample/product/';
    var REST_SERVICE_URI3 = 'http://localhost:8080/Spring4MVCAngularJSExample/order/';
    var REST_SERVICE_URI4 = 'http://localhost:8080/Spring4MVCAngularJSExample/order/of/';
    
    var factory = {
    	fetchCustomer: fetchCustomer,
        updateCustomer:updateCustomer,
        fetchAllProducts:fetchAllProducts,
        fetchCustomerOrder:fetchCustomerOrder,
        giveOrder:giveOrder
    };

    return factory;
    
    function fetchCustomer() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'getCustomer/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Customers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchAllProducts() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI2)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Products');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchCustomerOrder() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'getOrders/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Customers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateCustomer(customer, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, customer)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Customer');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function giveOrder(myorder){
    	var deferred = $q.defer();
        $http.post(REST_SERVICE_URI3, myorder)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Csutomer');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    

}]);
