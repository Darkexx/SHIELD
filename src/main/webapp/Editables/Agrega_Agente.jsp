<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Agrega agente </title>
		
		<link rel="stylesheet" type="text/css" href="../Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Aqui se agregan agentes</h2>


	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">


	<form action="../ServletAgentes" method="post">

		<label for="id"> ID_Agente >></label>
		<input id="id_her" type="text" name="id_agent">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre de agente >></label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="id_int"> Especializacion >></label>
		<input id="nom_her" type="text" name="especializacion">
		
		<br>
		<br>
		
		<label for="id_int"> Puesto >></label>
		<input id="nom_her" type="text" name="puesto">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar Agente">
	
	</form>
	
	
	</div>
	</div>
	
</body>
</html>
