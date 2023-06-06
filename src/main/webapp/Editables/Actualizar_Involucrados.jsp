<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Involucrados" %>

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
	
	<form action="ServletInvolucradosUpdate" method="get">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Involucrados> Involucrados = (List<JB_Involucrados>) request.getAttribute("involucrados");
		
		%>
		
		<label for="inv">Involucrados</label>
		<select id="inv" name="id_at">
		
			<% for(JB_Involucrados involucrado : Involucrados){ %>	
		
				<option value = "<%= involucrado.getIdAt() %>"> 
				
					<%= involucrado.getIdAt()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="nombre"> identificacion heroes </label>
		<input id="nom_her" type="text" name="id_h">
		
		<br>
		<br>
		
		<label for="id_l"> identificacion agente </label>
		<input id="id_i" type="text" name="id_agent">
		
		<br>
		<br>
		
		<label for="id_l"> Fecha </label>
		<input id="id_i" type="text" name="fecha">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar uwu">
	
	</form>
	
	
</body>
</html>