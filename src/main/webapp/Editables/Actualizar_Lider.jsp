<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Aqui se actualizan lideres</h2>


	<form action="../ServletLiderUpdate" method="get">

		<label for="id"> Numero de identificacion </label>
		<input id="id_l" type="text" name="id_l">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre </label>
		<input id="nom_lid" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="id_l"> Armamento </label>
		<input id="arm_lid" type="text" name="equipo_arm">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar">
	
	</form>
	
	
</body>
</html>