<html>

	<head>
		<title> SHIELD </title>
		
		<link rel="stylesheet" type="text/css" href="../Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Inserte los datos para la insercion de lideres</h2>

		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">

	<form action="../ServletLider" method="post">

		<label for="id"> Numero de identificacion >> </label>
		<input id="id_l" type="text" name="id_l">
		
		<br>
		<br>
		
		<label for="nombre"> Nombre >> </label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="equipo_arm">Equipo con el que cuentan(armas) >></label>
		<input id="equipo_arm" type="text" name="equipo_arm">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar uwu">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>
