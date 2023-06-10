<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Heroes" %>
<%@ page import="JavaBeans.JB_Agentes" %>
<%@ page import="JavaBeans.JB_Ataque" %>

<html>

	<head>
		<title> SHIELD </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Inserte los datos para agregar un nuevo evento</h2>


		<div class="overlay"></div>
		<div class="scanline"></div>
		<div class="wrapper">
  		<div class="content clearfix">

	<form action="ServletInvolucrados" method="post">

		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Ataque> Ataques = (List<JB_Ataque>) request.getAttribute("ataques");
		
		%>
		
		<label for="her">Ataques</label>
		<select id="her" name="id_at">
		
			<% for(JB_Ataque ataque : Ataques){ %>	
		
				<option value = "<%= ataque.getIdAt() %>"> 
				
					<%= ataque.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Heroes> Heroes = (List<JB_Heroes>) request.getAttribute("heroes");
		
		%>
		
		<label for="her">Heroes</label>
		<select id="her" name="id_h">
		
			<% for(JB_Heroes heroe : Heroes){ %>	
		
				<option value = "<%= heroe.getIdH() %>"> 
				
					<%= heroe.getNombre()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		
		<%
			@SuppressWarnings("unchecked")
			List<JB_Agentes> Agentes = (List<JB_Agentes>) request.getAttribute("agentes");
		
		%>
		
		<label for="ag">Agentes</label>
		<select id="ag" name="id_agent">
		
			<% for(JB_Agentes agente : Agentes){ %>	
		
				<option value = "<%= agente.getIdAgent() %>"> 
				
					<%= agente.getNombre()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<label for="equipo_arm"> Fecha </label>
		<input id="equipo_arm" type="text" name="fecha">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>
