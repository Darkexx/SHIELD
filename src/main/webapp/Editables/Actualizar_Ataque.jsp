<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Ataque" %>

<html>

	<head>
		<title> Actualizar Involucrados </title>
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	
	<label>Este es el jsp para actualizar ataques</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="ServletAtaqueUpdate" method="get">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Ataque> Ataques = (List<JB_Ataque>) request.getAttribute("ataques");
		
		%>
		
		<label for="inv">Ataques</label>
		<select id="inv" name="id_at">
		
			<% for(JB_Ataque ataque : Ataques){ %>	
		
				<option value = "<%= ataque.getIdAt() %>"> 
				
					<%= ataque.getIdAt()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="nombre"> Nombre </label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="id_m"> Muertes </label>
		<input id="id_i" type="text" name="muertes">
		
		<br>
		<br>
		
		<label for="id_h"> heridos </label>
		<input id="id_i" type="text" name="heridos">
		
		<br>
		<br>
		
		<label for="id_p"> Pais </label>
		<input id="id_i" type="text" name="pais">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar uwu">
	
	</form>
	
	
</body>
</html>