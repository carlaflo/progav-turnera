<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Pacientes</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

	<nav role="navigation" class="navbar navbar-default">

		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li ><a href="/terapistas">Ver terapistas</a></li>
				<li><a href="/pacientes">Ver pacientes</a></li>
				<li><a href="/add-paciente">Agregar Paciente</a></li>
				<li><a href="/pacientes">Reservar Turno</a></li>
				

			</ul>
		</div>
	</nav>
	<div class="container">
		<H1>Pacientes</H1>

		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>DNI</th>
						<th>Ver turnos</th>
						<th>Reservar turno</th>
						<th>Ver historial</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pacientes}" var="pac">
						<tr>
							<td>${pac.nombre}</td>
							<td>${pac.apellido}</td>
							<td>${pac.dni}</td>
							<td>
								<form action="/pacientes/${pac.dni}" method="get">
									<button type="submit" name="verturnos" value="verturnos"
										class="btn-link">Ver turnos</button>
								</form>
							</td>
							<td>
								<form action="/pacientes/${pac.dni}/turnos" method="get">
									<button type="submit" name="Reservar" value="Reservar"
										class="btn-link">Reservar turno</button>
								</form>
							</td>
							<td>
								<form action="/paciente/${pac.dni}/turnos-historico" method="get">
									<button type="submit" name="verhistorico" value="verHistorico"
										class="btn-link">Ver historial</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>