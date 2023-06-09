<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_STARK" %>
<%@ page import="JavaBeans.JB_Armamento" %>
<%@ page import="JavaBeans.JB_Heroes" %>

<html>

	<head>
		<title> Actualizar transacciones </title>
	</head>


<body>
<h2>Actualiza transaccion</h2>

	
	<label>Este es el jsp para actualizar transacciones</label>
	
	<br>
	<br>
	<br>
	<br>
	
	<form action="ServletArmamentoUpdate" method="get">

<!-- 		<label for="id"> ID del grupo </label> -->
<!-- 		<input id="id_her" type="text" name="id_h"> -->
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Armamento> Armas = (List<JB_Armamento>) request.getAttribute("armas");
		
		%>
		
		<label for="inv">Transaccion a actualizar</label>
		<select id="inv" name="tipo">
		
			<% for(JB_Armamento arma : Armas){ %>	
		
				<option value = "<%= arma.getTipo() %>"> 
				
					<%= arma.getTipo()%> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_STARK> Starke = (List<JB_STARK>) request.getAttribute("colab");
		
		%>
		
		<label for="inv">CEO</label>
		<select id="inv" name="id_ceo">
		
			<% for(JB_STARK Stark : Starke){ %>	
		
				<option value = "<%= Stark.getIdCeo()%>"> 
				
					<%= Stark.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		
		<br>
		<br>
		
		<label for="nombre"> Actualizar tipo </label>
		<input id="nom_her" type="text" name="tipo2">
		
		<br>
		<br>
		
		<label for="id_l"> Cantidad </label>
		<input id="id_i" type="text" name="cantidad">
		
		<br>
		<br>
		
		
		<%
		
			@SuppressWarnings("unchecked")
			List<JB_Heroes> Heroes = (List<JB_Heroes>) request.getAttribute("heroes");
		
		%>
		
		<label for="inv">Grupo</label>
		<select id="inv" name="id_h">
		
			<% for(JB_Heroes heroe : Heroes){ %>	
		
				<option value = "<%= heroe.getIdH()%>"> 
				
					<%= heroe.getNombre() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<br>
		<br>
		
		<input type="submit" value="Actualizar">
	
	</form>
	
	
</body>
</html>