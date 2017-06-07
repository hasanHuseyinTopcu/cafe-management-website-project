<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Admin's CRUD Operations</title>
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
				<a ng-href="ProductManagement" class="btn btn-primary">Product
					Management</a>
			</div>
			<div class="form-group col-md-4">
				<a ng-href="OrderManagement" class="btn btn-primary">Order
					Management</a>
			</div>

			<div class="form-group col-md-4">
				<a ng-href="Login" class="btn btn-danger">LogOut</a>
			</div>
		</div>
	</div>

	<div class="generic-container"
		ng-controller="CustomerController as ctrl">




		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">Customer Registration Form </span>
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
									name="username" class="username form-control input-sm"
									placeholder="Enter Username" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Password</label>
							<div class="col-md-7">
								<input type="password" ng-model="ctrl.customer.password"
									name="password" class="password form-control input-sm"
									placeholder="Enter Password" required ng-minlength="3" />
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
									placeholder="Enter Firstname" required ng-minlength="3" />
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
									placeholder="Enter Lastname" required ng-minlength="3" />
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
									placeholder="Enter Building No" required ng-minlength="3" />
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
									placeholder="Enter Floor No" required ng-minlength="3" />
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
									placeholder="Enter Room No" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.customer.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Customers </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>CustomerID</th>
							<th>Username</th>
							<th>Password</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Building No</th>
							<th>Floor No</th>
							<th>Room No</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="c in ctrl.customers">
							<td><span ng-bind="c.id"></span></td>
							<td><span ng-bind="c.username"></span></td>
							<td><span ng-bind="c.password"></span></td>
							<td><span ng-bind="c.firstName"></span></td>
							<td><span ng-bind="c.lastName"></span></td>
							<td><span ng-bind="c.buildingNo"></span></td>
							<td><span ng-bind="c.floorNo"></span></td>
							<td><span ng-bind="c.roomNo"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(c.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(c.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/customer_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
</body>
</html>