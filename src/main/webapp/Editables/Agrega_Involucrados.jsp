<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Heroes" %>
<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Inserte los datos para agregar un nuevo evento</h2>


	<form action="ServletInvolucrados" method="post">

		<label for="id"> Ataque </label>
		<input id="id_l" type="text" name="id_at">
		
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
		
		<label for="equipo_arm"> Agente </label>
		<input id="equipo_arm" type="text" name="id_agent">
		
		<br>
		<br>
		
		<label for="equipo_arm"> Fecha </label>
		<input id="equipo_arm" type="text" name="fecha">
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	
</body>
</html>
