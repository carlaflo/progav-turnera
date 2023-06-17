<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Terapistas</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<H1>Lista de Terapistas</H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Legajo</th>
						<th>Turnos</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${terapistas}" var="terap">
						<tr>
							<td>${terap.nombre}</td>
							<td>${terap.apellido}</td>
							<td>${terap.legajo}</td>
							<td>
								<form action="/terapistas/${terap.legajo}/turnos" method="get">
    								<button type="submit" name="turnosbydoc" value="turnosbydoc" class="btn-link">Ver Disponibilidad</button>
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