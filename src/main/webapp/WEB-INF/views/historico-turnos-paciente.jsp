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

	
	<c:choose>
    <c:when test="${role == 'admin'}">
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
    </c:when>
    <c:when test="${role == 'user'}">
        <nav role="navigation" class="navbar navbar-default">
			<div class="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/pacientes/${dni}">Mi Perfil</a></li>
					<li><a href="/pacientes/${dni}/turnos">Reservar turno</a></li>
					<li><a href="//paciente/${dni}/turnos-historico">Ver Historial</a></li>
				</ul>
			</div>
		</nav>
    </c:when>
    <c:otherwise>
        <label>Lo siento estamos trabajando para usted</label>
    </c:otherwise>
</c:choose>
	
	
	<div class="container">
		<H1>Paciente</H1>

		<p>
			<font color="red"> ${errorMessage} </font>
		</p>

		<div>
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Dni</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:set var="pac" scope="session" value="${paciente}" />
					<tr>
						<td>${pac.nombre}</td>
						<td>${pac.apellido}</td>
						<td>${pac.dni}</td>

					</tr>

				</tbody>
			</table>

			<H2>Turnos pasados</H2>

			<table class="table table-striped">

				<thead>
					<tr>
						<th>Terapista Nombre</th>
						<th>Terapista Apellido</th>
						<th>Numero de Turno</th>
						<th>Fecha</th>
						<th>Hora</th>
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
 	
 
	<a href="/excelExport/${dni}" class="btn btn-success">Export data into Excel </a> 

 	
 	
 	
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>