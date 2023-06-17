<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Turnos Online</title>
</head>


<body>
	
	<div class="topnav">
	  <a href="<c:url value="/terapistas"/>">Terapistas</a>
	  <a href="<c:url value="/pacientes"/>">Pacientes</a>
	  <a href="<c:url value="/add-paciente"/>">Agregar Paciente</a>
	  <a href="#contact">Turnos</a>
	  <a href="#about">Reservar Turno</a>
	</div>

</body>
</html>