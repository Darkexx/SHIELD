<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Tip_Ataque" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Info Mutantes </title>
	</head>


<body>
<h2>Info ataque mutante:</h2>

	<jsp:useBean id="t_at" class="JavaBeans.JB_Tip_Ataque" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>Identificacion Ataque</th>
			<th>Tipo</th>
			<th>Mutantes afectados</th>
			<th>Grupo Atacante</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Tip_Ataque> lista = (List<JB_Tip_Ataque>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Tip_Ataque t_ataque : lista){
    %>

	<tr>
			<td><%out.print(t_ataque.getIdAt());%></td>
			<td><%out.print(t_ataque.getNomTipo());%></td>
			<td><%out.print(t_ataque.getMutantAfect());%></td>
			<td><%out.print(t_ataque.getGrupoAt());%></td>
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
	
</body>
</html>