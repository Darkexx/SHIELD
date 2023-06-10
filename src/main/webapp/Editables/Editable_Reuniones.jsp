<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="JavaBeans.JB_reuniones" %>
<!DOCTYPE html>

<html>

	<head>
		<title> Juntas (Editable) </title>
		
		<link rel="stylesheet" type="text/css" href="Style.css" />
		<script src="sifunc.js"></script>
		
	</head>

<body>
<h2>Juntas pendientes</h2>

	<div class="overlay"></div>
	<div class="scanline"></div>
	<div class="wrapper">
  	<div class="content clearfix">


	<jsp:useBean id="Integrantes" class="JavaBeans.JB_reuniones" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Lider</th>
			<th>Tema</th>
			<th>Hora</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_reuniones> lista = (List<JB_reuniones>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_reuniones integ : lista){
    %>

	<tr>
		<td><%out.print(integ.getLider());%></td>
		<td><%out.print(integ.getTema());%></td>
		<td><%out.print(integ.getHora());%></td>
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
    
    <form action="ServletReunionesOptionRe" method="get">
		<input type="submit" value="Agrega reunion">
	</form>
	
	<form action="ServletReunionesOptionUp" method="get">
	
		<input type="submit" value="Actualizar reunion">
		
	</form>
	
	<br>
	
	<form action="ServletReunionesDelete" method="get">
	
		<input id="id_int" type="text" name="tema">
		<input type="submit" value="Eliminar reunion(por nombre)">
		
	</form>
	
	</div>
	</div>
	
</body>
</html>