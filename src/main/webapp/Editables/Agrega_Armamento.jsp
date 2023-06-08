<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_STARK" %>
<%@ page import="JavaBeans.JB_Heroes" %>

<html>

	<head>
		<title> Agrega Transaccion </title>
	</head>


<body>
<h2>Inserte los datos para agregar una nueva transaccion</h2>


<!-- 	Aqui no se redirije como ../ServletInvolucrados ya que no viene de otro jsp -->

	<form action="ServletArmamento" method="post">
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_STARK> Starke = (List<JB_STARK>) request.getAttribute("colab");
		
		%>
		
		<label for="her">CEO</label>
		<select id="her" name="id_ceo">
		
			<% for(JB_STARK stark : Starke){ %>	
		
				<option value = "<%= stark.getIdCeo() %>"> 
				
					<%= stark.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		
		
		<label for="arm"> Tipo </label>
		<input id="arm" type="text" name="tipo">
		
		<br>
		<br>
		
		
		
		<label for="cant"> Cantidad </label>
		<input id="cant" type="text" name="cantidad">
		
		<br>
		<br>
		
		<%
			@SuppressWarnings("unchecked")
			List<JB_Heroes> Heroes = (List<JB_Heroes>) request.getAttribute("heroes");
		
		%>
		
		<label for="ag">Heroes</label>
		<select id="ag" name="id_h">
		
			<% for(JB_Heroes heroe : Heroes){ %>	
		
				<option value = "<%= heroe.getIdH() %>"> 
				
					<%= heroe.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<input type="submit" value="Agregar">
	
	</form>
	
	
</body>
</html>