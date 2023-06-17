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
	<div class="container">
		<H1>Terapista Probando 1,2,3..</H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
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
					<c:set var="terap" scope="session" value="${terapista}"/>
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