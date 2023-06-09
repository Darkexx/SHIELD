<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Involucrados" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Ataques e involucrados </title>
	</head>


<body>
<h2>Ataques e involucrados</h2>

	
	
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
    
</body>
</html>