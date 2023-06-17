<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Pacientes</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<H1>Lista de Pacientes</H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>DNI</th>
						<th>Accion</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pacientes}" var="pac">
						<tr>
							<td>${pac.nombre}</td>
							<td>${pac.apellido}</td>
							<td>${pac.dni}</td>
							<td>
								<form action="/pacientes/${pac.dni}/turnos" method="get">
    								<button type="submit" name="Reservar" value="Reservar" class="btn-link">Ver Disponibilidad</button>
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