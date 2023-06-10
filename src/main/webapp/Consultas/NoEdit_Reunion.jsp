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
	
	</div>
	</div>
	
</body>
</html>