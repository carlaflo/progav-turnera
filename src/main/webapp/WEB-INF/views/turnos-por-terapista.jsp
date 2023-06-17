<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<!-- ESTA VISTA SE MUESTRA CUANDO SE SELECCIONA UN PACIENTE, PREVIAMENTE EN EL FLOW -->

<title>Reservar Turno</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<H1>Elija una fecha y un terapista</H1>
		
		<a href="<c:url value="home"/>">Home</a>
		
		<div>
		<c:set var="pac" scope="session" value="${paciente}"/>
		<h2>Turno para ${pac.nombre} ${pac.apellido} con DNI: ${pac.dni}</h2>
		
		<form action="/terapistas/turnos" method="POST">
			<label>Ingrese fecha: </label>
		    <input type="text" id="turnofecha" name="turnofecha" />
		      
		      
		      <select name="terapistas"   >
			    <c:forEach var="terap" items="${terapistas}">
			        <option id="terapistaId" value="${terap.legajo}" ${terap.legajo == selectedDept ? 'selected="selected"' : ''} >${terap.nombre}, ${terap.apellido}</option>
			    </c:forEach>
			  </select>
			  <input type="hidden" value="terapistaId" />
			  
			<input type="submit" value="Ver Disponibilidad" />
	    </form>
		
		
		
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>