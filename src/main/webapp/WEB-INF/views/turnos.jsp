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
		
		<a href="<c:url value="/home"/>">Home</a>
		
		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Numero de Turno</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Accion</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${turnos}" var="tur">
						<tr>
							<td>${tur.id}</td>
							<td>${tur.fecha}</td>
							<td>${tur.hora}</td>
							<td>
								<form action="/terapistas/${terap.legajo}/turnos" method="get">
    								<button type="submit" name="turnosbydoc" value="turnosbydoc" class="btn-link">Reservar</button>
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