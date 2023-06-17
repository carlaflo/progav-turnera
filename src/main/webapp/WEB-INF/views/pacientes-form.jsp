<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Paciente</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container"></div>
	<h1> Nuevo Paciente </h1>
	
	<a href="<c:url value="home"/>">Home</a>

	<form method="post">
	
		<fieldset class="form-group">
			<label> DNI </label> 
			<input name="dni" type="text" class="form-control" required="required" />
			<label> NOMBRE </label> 
			<input name="nombre" type="text" class="form-control" required="required" />
			<label> APELLIDO </label> 
			<input name="apellido" type="text" class="form-control" required="required" />
			
			<select name="patologia">
			    <c:forEach var="item" items="${patologias}">
			        <option value="${item.id}" ${item.id == selectedDept ? 'selected="selected"' : ''}>${item.nombre}</option>
			    </c:forEach>
			</select>
			
		</fieldset>
		
		<input class="btn btn-success" type="submit" value="add" />

	</form>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script> <script
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>