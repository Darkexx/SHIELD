<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Bienvenido Lider de Shield</h2>

	<form action="ServletHeroes" method="get">
		<input type="submit" value="Equipos de Heroes">
	</form>
	
	<form action="ServletIntegrantes" method="get">
		<input type="submit" value="Integrantes de equipos de Heroes">
	</form>
	
	<form action="ServletLider" method="get">
		<input type="submit" value="Lider equipos de Heroes">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Ataques e involucrados">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Info. Ataque">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Agentes de SHIELD">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Juntas pendientes">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Transacciones STARK">
	</form>
	
	<form action="//" method="get">
		<input type="submit" value="Subdivision y lideres>
	</form>
	
</body>
</html>
