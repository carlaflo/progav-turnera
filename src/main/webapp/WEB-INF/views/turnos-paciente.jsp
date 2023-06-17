<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Turnos disponibles</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<H1>Turnos disponibles</H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
		<div>
		<c:set var="pac" scope="session" value="${paciente}"/>
		<h2>Hola ${pac.nombre} ${pac.apellido} con DNI: ${pac.dni}</h2>
		
		<table class="table table-striped">

				<thead>
					<tr>
						<th>Turno ID</th>
						<th>Nombre Terapista</th>
						<th>Apellido Terapista</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Action</th>
						<th></th>
					</tr>
				</thead>
				
				
				<tbody>
					<c:forEach items="${turnos}" var="t">
						<tr>
							<td>${t.id}</td>
							<td>${t.terapista.nombre}</td>
							<td>${t.terapista.apellido}</td>
							<td>${t.fecha}</td>
							<td>${t.hora}</td>
							<td>
								<form action="/turnos/${t.id}/pacientes/${pac.dni}" method="post">
    								<button type="submit" name="Reservar" value="Reservar" class="btn-link">Reservar Turno</button>
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