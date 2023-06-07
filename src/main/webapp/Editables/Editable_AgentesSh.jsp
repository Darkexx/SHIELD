<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="JavaBeans.JB_Agentes" %>
<!DOCTYPE html>

<html>

	<head>
		<title> Agentes de Shield (Editable) </title>
	</head>

<body>
<h2>Integrantes de equipos</h2>

	<jsp:useBean id="Integrantes" class="JavaBeans.JB_Agentes" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>id_agent</th>
			<th>Nombre</th>
			<th>Especializacion</th>
			<th>Puesto</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Agentes> lista = (List<JB_Agentes>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Agentes agent : lista){
    %>

	<tr>
		<td><%out.print(agent.getIdAgent());%></td>
		<td><%out.print(agent.getNombre());%></td>
		<td><%out.print(agent.getEspecializacion());%></td>
		<td><%out.print(agent.getPuesto());%></td>
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
    
    <form action="Editables/Agrega_Agente.jsp" method="get">
		<input type="submit" value="Agregar Agente">
	</form>
	
	<form action="ServletAgentesOptionUpdate" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	<form action="ServletAgentesDelete" method="get">
	
		<input id="id_int" type="text" name="id_agent">
		<input type="submit" value="Eliminar Agente">
		
	</form>

</body>
</html>
