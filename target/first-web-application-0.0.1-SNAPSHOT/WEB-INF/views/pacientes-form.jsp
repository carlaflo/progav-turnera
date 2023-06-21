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
	<nav role="navigation" class="navbar navbar-default">

		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/terapistas">Ver terapistas</a></li>
				<li><a href="/pacientes">Ver pacientes</a></li>
				<li><a href="/add-paciente">Agregar Paciente</a></li>
				<li><a href="/pacientes">Reservar turno</a></li>

			</ul>
		</div>
	</nav>
	
	<div class="container">
	<h1>Nuevo Paciente</h1>

	<form method="post">

		<fieldset class="form-group">
			<label> DNI </label> 
			<input name="dni" type="text"  required="required" class="form-control" /> 
			
			<label> NOMBRE </label> 
			<input name="nombre" type="text" required="required" class="form-control" /> 
			
			<label> APELLIDO </label> 
			<input name="apellido" type="text"  required="required" class="form-control" />

			<label> PATOLOGIA </label>
			<select name="patologia" class="form-control" >
				<c:forEach var="item" items="${patologias}">
					<option value="${item.id}"
						${item.id == selectedDept ? 'selected="selected"' : ''}>${item.nombre}</option>
				</c:forEach>
			</select>
			<br/>
			<label> PASSWORD </label> 
			<input name="password" type="password" required="required " class="form-control" />

		</fieldset>

		<input class="btn btn-success" type="submit" value="add" />

	</form>

</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>