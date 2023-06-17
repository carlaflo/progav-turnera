<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Paciente</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<H1>Paciente </H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre    </th>
						<th>Apellido  </th>
						<th>Dni       </th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:set var="pac" scope="session" value="${paciente}"/>
						<tr>
							<td>${pac.nombre}</td>
							<td>${pac.apellido}</td>
							<td>${pac.dni}</td>
							
						</tr>
					
				</tbody>
			</table>
			
			<H2>Turnos </H2>
			
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Terapista Nombre    </th>
						<th>Terapista Apellido </th>
						<th>Numero de Turno    </th>
						<th>Fecha   </th>
						<th>Hora   </th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${turnos}" var="t">
						<tr>
							<td>${t.terapista.nombre}</td>
							<td>${t.terapista.apellido}</td>
							<td>${t.id}</td>
							<td>${t.fecha}</td>
							<td>${t.hora}</td>
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