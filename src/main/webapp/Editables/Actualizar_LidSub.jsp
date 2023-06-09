<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Subdivision" %>
<%@ page import="JavaBeans.JB_Lideres_Subdivision" %>

<html>

	<head>
		<title> Actualizar Lider de Subdivision </title>
	</head>


<body>
<h2>Inserte los datos para actualizar un lider de subdivision</h2>


	<form action="ServletLidSubUpdate" method="get">
	
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Lideres_Subdivision> lidsub = (List<JB_Lideres_Subdivision>) request.getAttribute("lideres");
		
		%>
		
		<label for="her">Lider a actualizar</label>
		<select id="her" name="id_ls">
		
			<% for(JB_Lideres_Subdivision lidsubs : lidsub){ %>	
		
				<option value = "<%= lidsubs.getIdLs() %>"> 
				
					<%= lidsubs.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		
		<br>
		<br>
		
		
		<label for="arm"> Nombre </label>
		<input id="arm" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="arm"> Rango </label>
		<input id="arm" type="text" name="rango">
		
		<br>
		<br>
		
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Subdivision> Subdiv = (List<JB_Subdivision>) request.getAttribute("subs");
		
		%>
		
		<label for="her">Subdivision</label>
		<select id="her" name="id_sub">
		
			<% for(JB_Subdivision sub : Subdiv){ %>	
		
				<option value = "<%= sub.getIdSub() %>"> 
				
					<%= sub.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		
		<input type="submit" value="Actualizar">
	
	
	
	</form>
	
	
</body>
</html>