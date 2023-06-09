<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Involucrados" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Ataques e involucrados </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Ataques e involucrados</h2>

	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">
	
	<jsp:useBean id="invo" class="JavaBeans.JB_Involucrados" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>ID_Ataque</th>
			<th>Grupo de Heroes</th>
			<th>Agente involucrado</th>
			<th>Fecha</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Involucrados> lista = (List<JB_Involucrados>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Involucrados involucrados : lista){
    %>

	<tr>
		<td><%out.print(involucrados.getAtaque());%></td>
		<td><%out.print(involucrados.getHeroe());%></td>
		<td><%out.print(involucrados.getAgente());%></td>
		<td><%out.print(involucrados.getFecha());%></td>
	</tr>

	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
    %>
    
    </table>
    
    <br>
    <br>
    
    <form action="ServletInvolucradosOptionHeroe" method="get">
		<input type="submit" value="Agregar Ataque">
	</form>
	
	<form action="ServletInvolucradosOptionUpdate" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletInvolucradosDelete" method="get">
	
		<input id="id" type="text" name="id_at">
		<input type="submit" value="Eliminar Ataque">
		
	</form>
	
	</div>
	</div>
	
</body>
</html>