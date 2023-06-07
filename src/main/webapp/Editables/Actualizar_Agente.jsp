<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Agentes" %>

<html>

	<head>
		<title> Actualizar agentes </title>
	</head>


<body>
<h2>Introduzca los datos a actualizar</h2>

	
	<label>Este es el jsp para actualizar agentes</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="ServletAgentesUpdate" method="get">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Agentes> Agentes = (List<JB_Agentes>) request.getAttribute("agentes");
		
		%>
		
		<label for="inv">Agente a actualizar:</label>
		<select id="inv" name="id_agent">
		
			<% for(JB_Agentes agente : Agentes){ %>	
		
				<option value = "<%= agente.getIdAgent() %>"> 
				
					<%= agente.getNombre()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="nombre"> Nombre </label>
		<input id="nom_her" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="esp"> Especializacion </label>
		<input id="esp" type="text" name="especializacion">
		
		<br>
		<br>
		
		<label for="pues"> Puesto </label>
		<input id="pues" type="text" name="puesto">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar">
	
	</form>
	
	
</body>
</html>