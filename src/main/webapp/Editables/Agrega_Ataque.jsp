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
<h2>Aqui se agregan Ataques</h2>

	
		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">

	<form action="../ServletAtaque" method="post">

		<label for="id_at"> ID_Grupo >></label>
		<input id="id_at" type="text" name="id_at">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre de grupo >></label>
		<input id="nom_at" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="muer"> Muertes >></label>
		<input id="muer" type="text" name="muertes">
		
		<br>
		<br>
		
		<label for="heri"> Heridos >></label>
		<input id="her" type="text" name="heridos">
		
		<br>
		<br>
		
		<label for="pais"> Pais >></label>
		<input id="pais" type="text" name="pais">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>