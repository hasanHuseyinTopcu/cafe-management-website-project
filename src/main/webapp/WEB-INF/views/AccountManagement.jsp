<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Account Page</title>
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
		<div class="form-group col-md-8"></div>
		<div class="form-group col-md-4">
			<a ng-href="Login" class="btn btn-danger">LogOut</a>
		</div>
	</div>
	</div>



	<div class="generic-container"
		ng-controller="AccountController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Customer Edit Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.customer.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Username</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.username"
									readonly="true" name="username"
									class="username form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Password</label>
							<div class="col-md-7">
								<input type="password" ng-model="ctrl.customer.password"
									name="password" class="username form-control input-sm"
									placeholder="Enter your password" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">First
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.firstName"
									name="firstName" class="username form-control input-sm"
									placeholder="Enter your firstname" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Last
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.lastName"
									name="lastName" class="username form-control input-sm"
									placeholder="Enter your lastname" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Building
								No</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.buildingNo"
									name="buildingNo" class="username form-control input-sm"
									placeholder="Enter your building no" required ng-minlength="1" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Floor No</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.floorNo"
									name="floorNo" class="username form-control input-sm"
									placeholder="Enter your floor no" required ng-minlength="1" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Room No</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.customer.roomNo" name="roomNo"
									class="username form-control input-sm"
									placeholder="Enter your room no" required ng-minlength="1" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<div class="col-md-8"></div>
							<div class="form-actions col-md-4">
								<input type="submit"
									value="{{!ctrl.customer.id ? 'Add' : 'Update'}}"
									class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							</div>
						</div>
					</div>
				</form>
			</div>

			<div class="panel-heading">
				<span class="lead">Add Order Form </span>
			</div>

			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm2" class="form-horizontal">
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Select a Product</label>
							<div class="col-md-7">
								<div class="dropdown">	
									<input type="hidden" ng-model="ctrl.order.id" /> 
									 <select
										ng-model="ddlProduct"
										ng-options="product.name as product.name for product in Products track by product.name">
									</select>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Order amount</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.myorder.amount" name="amount" style="width:100px;"
									class="username form-control input-sm"
									placeholder="Enter Amount of Product" required ng-minlength="1"/>
								<div class="has-error" ng-show="myForm2.$dirty"></div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<div class="col-md-2"></div>
							<div class="form-actions col-md-4">
								<button type="button" ng-click="ctrl.gorder()" class="btn btn-success">Give Order</button>
							</div>
						</div>
					</div>
					
				</form>
			</div>


			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Orders Of a Customer </span>
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
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/account_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/account_controller.js' />"></script>
</body>
</html>