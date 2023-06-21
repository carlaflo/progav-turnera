<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<!-- ESTA VISTA SE MUESTRA CUANDO SE SELECCIONA UN PACIENTE, PREVIAMENTE EN EL FLOW -->

<title>Reservar Turno</title>

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
					<li><a href="/paciente/${dni}/turnos-historico">Ver Historial</a></li>
				</ul>
			</div>
		</nav>
    </c:when>
    <c:otherwise>
        <label>Lo siento estamos trabajando para usted</label>
    </c:otherwise>
</c:choose>
	
	
	<div class="container">
		<H1>Elija una fecha y un terapista</H1>

		<div>
			<c:set var="pac" scope="session" value="${paciente}" />
			<h2>Turno para ${pac.nombre} ${pac.apellido} con DNI: ${pac.dni}</h2>


			<label>Lista de Terapistas </label> <select>
				<c:forEach var="terap" items="${terapistas}">
					<option value="${terap.legajo}"
						${terap.legajo == selectedDept ? 'selected="selected"' : ''}>${terap.nombre},
						${terap.apellido} - ${terap.legajo}</option>
				</c:forEach>
			</select>

			<form action="/terapistas/turnos" method="POST">
				<label>Fecha inicio: </label> <input type="text" id="fechainicio"
					name="fechainicio" value="${todayBuscarTurnos}" readonly="readonly" />
				<label>Fecha fin: </label> <input type="text" id="fechafin"
					name="fechafin" value="${endDate}" readonly="readonly" /> <label>Legajo
					Terapista </label> <input type="text" id="teraplegajo" name="teraplegajo" />

				<input type="hidden" id="pacdni" name="pacdni" value="${pac.dni}" />

				<input type="submit" value="Ver Disponibilidad" />
			</form>



		</div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>