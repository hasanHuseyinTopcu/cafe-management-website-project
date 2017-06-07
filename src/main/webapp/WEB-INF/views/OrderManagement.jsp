<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Order Page</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">

	<div class="generic-container">
		<div class="panel-heading">
			<span class="lead">Another Management Page </span>
		</div>
		<div class="panel panel-default">
			<div class="form-group col-md-4">
				<a ng-href="CustomerManagement" class="btn btn-primary">Customer-Management</a>
			</div>
			<div class="form-group col-md-4">
				<a ng-href="ProductManagement" class="btn btn-primary">Product
					Management</a>
			</div>


			<div class="form-group col-md-4">
				<a ng-href="Login" class="btn btn-danger">LogOut</a>
			</div>
		</div>
	</div>

	<div class="generic-container" ng-controller="OrderController as ctrl">



		<div class="panel panel-default">

			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Orders </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>OrderID</th>
							<th>customerID</th>
							<th>Customer Name</th>
							<th>Product Name</th>
							<th>Amount</th>
							<th>Status</th>
							<th>Order Date</th>
							<th>Change Status of Order</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="o in ctrl.orders">
							<td><span ng-bind="o.id"></span></td>
							<td><span ng-bind="o.customerID"></span></td>
							<td><span ng-bind="o.customerName"></span></td>
							<td><span ng-bind="o.productName"></span></td>
							<td><span ng-bind="o.amount"></span></td>
							<td><span ng-bind="o.status"></span></td>
							<td><span ng-bind="o.createdDate"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(o.id)"
									class="btn btn-success">Change Status</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>




	<div class="generic-container" ng-controller="OrderController as ctrl">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Orders of A Customer </span>
			</div>





			<label for="repeatSelect"> Filter According to Customer Name:</label>
			<select ng-model="ddlCustomer"
				ng-options="cus.username as cus.username for cus in Customs track by cus.username"
				ng-change="GetValue()">
			</select>



			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>OrderID</th>
							<th>customerID</th>
							<th>Customer Name</th>
							<th>Product Name</th>
							<th>Amount</th>
							<th>Status</th>
							<th>Order Date</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="o in ctrl.ordersOfACustomer">
							<td><span ng-bind="o.id"></span></td>
							<td><span ng-bind="o.customerID"></span></td>
							<td><span ng-bind="o.customerName"></span></td>
							<td><span ng-bind="o.productName"></span></td>
							<td><span ng-bind="o.amount"></span></td>
							<td><span ng-bind="o.status"></span></td>
							<td><span ng-bind="o.createdDate"></span></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/order_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/order_controller.js' />"></script>
</body>
</html>