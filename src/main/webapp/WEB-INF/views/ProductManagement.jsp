<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Page</title>
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
				<a ng-href="OrderManagement" class="btn btn-primary">Order
					Management</a>
			</div>
			
			
			
			<div class="form-group col-md-4">
				<a ng-href="Login" class="btn btn-danger">LogOut</a>
			</div>
			
			
		</div>
	</div>
	<div class="generic-container"
		ng-controller="ProductController as ctrl">



		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">Product Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.product.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Product
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.name" name="name"
									class="username form-control input-sm"
									placeholder="Enter Product Name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty"></div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.product.id ? 'Add' : 'Update'}}"
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
				<span class="lead">List of Products </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ProductID</th>
							<th>Product Name</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="p in ctrl.products">
							<td><span ng-bind="p.id"></span></td>
							<td><span ng-bind="p.name"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(p.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(p.id)"
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
	<script src="<c:url value='/static/js/service/product_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/product_controller.js' />"></script>
</body>
</html>