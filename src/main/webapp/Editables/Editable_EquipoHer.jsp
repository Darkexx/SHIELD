<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Heroes" %>

<!DOCTYPE html>

<html>

	<head>
		<title> SHIELD </title>
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>


<body>
<h2>Bienvenido a SHIELD</h2>

	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">
	
	<jsp:useBean id="Heroes" class="JavaBeans.JB_Heroes" scope="request"/>
		<table>
		
	<thead>
	
		<tr>
			<th>ID_Grupo</th>
			<th>Nombre</th>
			<th>Lider</th>
			<th>Subdivision</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Heroes> lista = (List<JB_Heroes>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Heroes hero : lista){
    %>

	<tr>
		<td><%out.print(hero.getIdH());%></td>
		<td><%out.print(hero.getNombre());%></td>
		<td><%out.print(hero.getid_lider());%></td>
		<td><%out.print(hero.getid_subdiv());%></td>
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
    
    <form action="Editables/Agrega_EquipoHer.jsp" method="get">
		<input type="submit" value="Agregar Equipo">
	</form>
	
	<form action="Editables/Actualizar_EquipoHer.jsp" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletHeroesDelete" method="get">
	
		<input id="id" type="text" name="id_h">
		<input type="submit" value="<< Eliminar Equipo">
		
	</form>
	
	</div>
	</div>
	
</body>
</html>
