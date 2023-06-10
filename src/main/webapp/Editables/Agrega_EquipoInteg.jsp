<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
		<link rel="stylesheet" type="text/css" href="../Style.css" />
		<script src="sifunc.js"></script>
	</head>


<body>
<h2>Aqui se agregan equipos</h2>

	
	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">
	

	<form action="../ServletIntegrantes" method="post">

		<label for="id"> ID_Grupo >></label>
		<input id="id_her" type="text" name="id_h">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre de Integrante >></label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="id_int"> Nombre de Integrante >></label>
		<input id="nom_her" type="text" name="id_int">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>
