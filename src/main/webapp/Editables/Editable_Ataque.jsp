<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Ataque" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
	</head>


<body>
<h2>Recuento de ataques:</h2>

	
	
	<jsp:useBean id="Ataque" class="JavaBeans.JB_Heroes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Identificacion Ataque</th>
			<th>Nombre</th>
			<th>Muertes</th>
			<th>Heridos</th>
			<th>Heridos</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Ataque> lista = (List<JB_Ataque>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Ataque ataque : lista){
    %>

	<tr>
			<td><%out.print(ataque.getIdAt());%></td>
			<td><%out.print(ataque.getNombre());%></td>
			<td><%out.print(ataque.getMuertes());%></td>
			<td><%out.print(ataque.getHeridos());%></td>
			<td><%out.print(ataque.getPais());%></td>
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
    
    <form action="Editables/Agrega_Ataque.jsp" method="get">
		<input type="submit" value="Agregar Ataque">
	</form>
	
	<form action="" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletAtaqueDelete" method="get">
	
		<input id="id" type="text" name="id_at">
		<input type="submit" value="Eliminar Ataque">
		
	</form>
</body>
</html>