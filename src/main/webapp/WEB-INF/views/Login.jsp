<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>AngularJS $http Example</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">User Login Form </span>
			</div>
			<div class="formcontainer">
				<form action="executeLogin" method="post" class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Username</label>
							<div class="col-md-7">
								<input type="text" name="username"
									class="username form-control input-sm"
									placeholder="Enter your name" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Password</label>
							<div class="col-md-7">
								<input type="password" name="password" class="form-control input-sm"
									placeholder="Enter your Password" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Login" class="btn btn-primary btn-sm">
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/user_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/login_controller.js' />"></script>
</body>
</html>