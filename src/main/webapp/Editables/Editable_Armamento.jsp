<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaBeans.JB_Armamento" %>

<!DOCTYPE html>

<html>

	<head>
		<title> Transacciones Stark </title>
	</head>


<body>
<h2>Compras a Stark</h2>

	
	
	<jsp:useBean id="armamento" class="JavaBeans.JB_Armamento" scope="request"/>
		<table width="100%">
		
	<thead>
	
		<tr>
			<th>CEO</th>
			<th>Tipo</th>
			<th>Cantidad</th>
			<th>Grupos que comparon</th>
		
		</tr>
	
	</thead>
	
	<%

  		@SuppressWarnings("unchecked")
		List<JB_Armamento> lista = (List<JB_Armamento>) request.getAttribute("lista");
        if (lista != null){
        	for (JB_Armamento arma : lista){
    %>

	<tr>
		<td><%out.print(arma.getCeo());%></td>
		<td><%out.print(arma.getTipo());%></td>
		<td><%out.print(arma.getCantidad());%></td>
		<td><%out.print(arma.getGrupo());%></td>
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
    
    <form action="ServletArmamentoOptAg" method="get">
		<input type="submit" value="Agregar Transaccion">
	</form>
	
	<form action="" method="get">
	
		<input type="submit" value="Actualizar datos">
		
	</form>
	
	<br>
	
	
	<form action="ServletArmamentoDelete" method="get">
	
<!-- 		<input id="id" type="text" name="id_h"> -->
<!-- 		<input type="submit" value="Eliminar Transaccion"> -->
	<%
			@SuppressWarnings("unchecked")
			List<JB_Armamento> Armas = (List<JB_Armamento>) request.getAttribute("lista");
		
		%>
		
		<label for="ag">Transaccion a eliminar</label>
		<select id="ag" name="tipo">
		
			<% for(JB_Armamento Armamento : Armas){ %>	
		
				<option value = "<%= Armamento.getTipo() %>"> 
				
					<%= Armamento.getTipo() %> 
				
				</option>
			
			<%}%>
			
		</select>
		
		<input type="submit" value="Eliminar Transaccion">
		
	</form>
	
</body>
</html>