<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Terapista</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container"></div>
	<h1> Add Terapista 	</h1>
	
	<a href="<c:url value="home"/>">Home</a>

	<form method="post">
	
		<fieldset class="form-group">
			<label> description </label> 
			<input name="nombre" type="text" class="form-control" required="required" />
			<input name="apellido" type="text" class="form-control" required="required" />
			<input name="legajo" type="text" class="form-control" required="required" />
		</fieldset>
		
		<input class="btn btn-success" type="submit" value="add" />

	</form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script> <script
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>