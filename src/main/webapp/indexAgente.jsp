<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>

	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">

<h2>Bienvenido Agente de Shield</h2>

	<form action="ServletHeroesNoEdit" method="get">
		<input type="submit" value="Equipos de Heroes">
	</form>
	
	<form action="ServletIntegrantesNoEdit" method="get">
		<input type="submit" value="Integrantes de equipos de Heroes">
	</form>
	
	<form action="ServletLiderNoEdit" method="get">
		<input type="submit" value="Lider equipos de Heroes">
	</form>
	
	<form action="ServletInvolucrados" method="get">
		<input type="submit" value="Ataques e involucrados">
	</form>
	
	<form action="ServletAtaque" method="get">
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
	
	</div>
	</div>
	
</body>
</html>
