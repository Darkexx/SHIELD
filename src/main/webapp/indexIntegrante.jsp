<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Bienvenido a integrante de grupo</h2>

	<form action="ServletHeroesNoEdit" method="get">
		<input type="submit" value="Equipos de Heroes">
	</form>
	
	<form action="ServletIntegrantesNoEdit" method="get">
		<input type="submit" value="Integrantes de equipos de Heroes">
	</form>
	
	<form action="ServletLiderNoEdit" method="get">
		<input type="submit" value="Lider equipos de Heroes">
	</form>
	
	<form action="ServletInvolucradosNoEdit" method="get">
		<input type="submit" value="Ataques e involucrados">
	</form>
	
	<form action="ServletAtaqueNoEdit" method="get">
		<input type="submit" value="Info. Ataque">
	</form>
	
	<form action="ServletAgentesNoEdit" method="get">
		<input type="submit" value="Agentes de SHIELD">
	</form>
	
	<form action="ServletReunionesNoEdit" method="get">
		<input type="submit" value="Juntas pendientes">
	</form>
	
	<form action="ServletArmamentoNoEdit" method="get">
		<input type="submit" value="Transacciones STARK">
	</form>
	
	<form action="ServletLidSubNoEdit" method="get">
		<input type="submit" value="Subdivision y lideres">
	</form>
	
</body>
</html>