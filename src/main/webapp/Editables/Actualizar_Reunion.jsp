<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_reuniones" %>
<%@ page import="JavaBeans.JB_Lider" %>

<html>

	<head>
		<title> Actualizar reuniones </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Actualiza reunion</h2>


		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">

	
	<label>Este es el jsp para actualizar reuniones</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="ServletReunionesUpdate" method="get">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_reuniones> Reuniones = (List<JB_reuniones>) request.getAttribute("reuniones");
		
		%>
		
		<label for="inv">Reunion a actualizar</label>
		<select id="inv" name="tema">
		
			<% for(JB_reuniones reunion : Reuniones){ %>	
		
				<option value = "<%= reunion.getTema() %>"> 
				
					<%= reunion.getTema()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		
		
		
		<br>
		<br>
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Lider> Heroes = (List<JB_Lider>) request.getAttribute("heroes");
		
		%>
		
		<label for="inv">Lider</label>
		<select id="inv" name="id_l">
		
			<% for(JB_Lider heroe : Heroes){ %>	
		
				<option value = "<%= heroe.getIdL() %>"> 
				
					<%= heroe.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="nombre"> Actualizar tema >></label>
		<input id="nom_her" type="text" name="tema2">
		
		<br>
		<br>
		
		<label for="id_l"> Hora >></label>
		<input id="id_i" type="text" name="hora">
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>