'use strict';

angular.module('myApp').factory('OrderService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/Spring4MVCAngularJSExample/order/';
    
    var factory = {
        fetchAllOrders: fetchAllOrders,
        fetchCustomers: fetchCustomers,
        fetchOrderOfCustomer:fetchOrderOfCustomer,
        updateOrder:updateOrder
    };

    return factory;
    
    function fetchAllOrders() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching ORders');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchOrderOfCustomer(username){
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'of/'+username)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching ORders');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchCustomers(){
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'uniqueCustomers/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching ORders');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateOrder(order, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, order)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Order');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
