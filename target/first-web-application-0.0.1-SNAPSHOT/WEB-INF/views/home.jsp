<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Turnos Online</title>

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

</body>
</html>