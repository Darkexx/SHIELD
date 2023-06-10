<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Ataque" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
	</head>

	


<body>
<h2>Recuento de ataques:</h2>

		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">
	
	<jsp:useBean id="Ataque" class="JavaBeans.JB_Heroes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Identificacion Ataque</th>
			<th>Nombre</th>
			<th>Muertes</th>
			<th>Heridos</th>
			<th>Heridos</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Ataque> lista = (List<JB_Ataque>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Ataque ataque : lista){
    %>

	<tr>
			<td><%out.print(ataque.getIdAt());%></td>
			<td><%out.print(ataque.getNombre());%></td>
			<td><%out.print(ataque.getMuertes());%></td>
			<td><%out.print(ataque.getHeridos());%></td>
			<td><%out.print(ataque.getPais());%></td>
	</tr>

	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
    %>
    
    </table>
    
    <br>
    <br>
    
    <form action="Editables/Agrega_Ataque.jsp" method="get">
		<input type="submit" value="Agregar Ataque">
	</form>
	
	<form action="ServletAtaqueOptionUpdate" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletAtaqueDelete" method="get">
	
		<input id="id" type="text" name="id_at">
		<input type="submit" value="Eliminar Ataque">
		
	</form>
	
	<form action="ServletTipAtaque" method="get">
	
		<label>Mas informacion de ataques :</label>
		<br>
		
		<label>Selecciona el tipo de ataque que desees</label>
		
		<select name = "t_ataque">
			
			<option value="Invasion territorial">Invasion territorial</option>
			<option value="Amenaza extraterrestre">Amenaza extraterrestre</option>
			<option value="Economicos">Economicos</option>
			<option value="Mutantes">Mutantes</option>
		
		</select>
		
		<input type="submit" value="OK">
		
	</form>
	
	</div>
	</div>
	
</body>
</html>