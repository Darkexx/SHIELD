<!DOCTYPE html>

<html>

	<head>
		<title> Actualizar Integrantes </title>
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	
	<label>Este es el jsp para actualizar integrantes</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="../ServletIntegrantesUpdate" method="get">

		<label for="id"> ID del grupo </label>
		<input id="id_her" type="text" name="id_h">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre de Integrante </label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="id_l"> Numero de identificacion </label>
		<input id="id_i" type="text" name="id_i">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar uwu">
	
	</form>
	
	
</body>
</html>
