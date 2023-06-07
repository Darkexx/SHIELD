<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Lider" %>

<html>

	<head>
		<title> Agregar reuniones </title>
	</head>


<body>
<h2>Actualiza los datos de las reuniones</h2>

	
	<label>Este es el jsp para agregar reuniones</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="ServletReuniones" method="post">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Lider> Lideres = (List<JB_Lider>) request.getAttribute("lideres");
		
		%>
		
		<label for="inv">Lideres</label>
		<select id="inv" name="id_l">
		
			<% for(JB_Lider lider : Lideres){ %>	
		
				<option value = "<%= lider.getIdL() %>"> 
				
					<%= lider.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="nombre"> Tema </label>
		<input id="nom_her" type="text" name="tema">
		
		<br>
		<br>
		
		<label for="id_m"> Hora </label>
		<input id="id_i" type="text" name="hora">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	
</body>
</html>