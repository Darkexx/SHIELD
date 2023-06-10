<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Subdivision" %>

<html>

	<head>
		<title> Agrega Lider de Subdivision </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Inserte los datos para agregar un nuevo lider de subdivision</h2>

	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">

	<form action="ServletLidSub" method="post">
	
		
		<label for="arm"> Identificacion LiderSub >></label>
		<input id="arm" type="text" name="id_ls">
		
		<br>
		<br>
		
		
		<label for="arm"> Nombre >></label>
		<input id="arm" type="text" name="nombre">
		
		<br>
		<br>
		
		<label for="arm"> Rango >></label>
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
		
		
		<input type="submit" value="Agregar">
	
	
	
	</form>
	
	</div>
	</div>
	
</body>
</html>