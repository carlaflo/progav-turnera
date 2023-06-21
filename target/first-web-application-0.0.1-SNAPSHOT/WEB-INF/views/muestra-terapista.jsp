<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Terapista</title>
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
		<H1>Terapista</H1>

		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Legajo</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:set var="terap" scope="session" value="${terapista}" />
					<tr>
						<td>${terap.nombre}</td>
						<td>${terap.apellido}</td>
						<td>${terap.legajo}</td>

					</tr>

				</tbody>
			</table>
		</div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>