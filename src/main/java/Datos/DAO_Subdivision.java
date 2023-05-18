package Datos;

import JavaBeans.JB_Subdivision;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Subdivision {
	public static final String selectSQL = "SELECT * FROM subdivision";
	public static final String insertSQL = "INSERT INTO subdivision(id_sub,nombre) VALUES (?,?)";
	public static final String updateSQL = "UPDATE subdivision SET nombre = ? WHERE id_sub = ?";
	public static final String deleteSQL = "DELETE FROM subdivision WHERE id_sub = ?";
	
	public List<JB_Subdivision> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Subdivision Sub = null;
		
			List<JB_Subdivision> subdiv = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_sub = result.getString("id_sub");
						String nombre = result.getString("nombre");
						
						Sub = new JB_Subdivision(id_sub,nombre);
						subdiv.add(Sub);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Subdivision c: subdiv) {
						System.out.println("id_sube: " + c.getIdSub());
						System.out.println("Nombre: " + c.getNombre());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return subdiv;
		
	}
	
	public int agregar(JB_Subdivision Subdiv) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Subdiv.getIdSub());
			state.setString(2, Subdiv.getNombre());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Subdivision SubdivNvo = new JB_Subdivision();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Subdivision Subdiv) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Subdiv.getIdSub());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Subdivision SubdivDel = new JB_Subdivision();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Subdivision Subdiv) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Subdiv.getNombre());
			state.setString(2,Subdiv.getIdSub());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Subdivision SubdivModi = new JB_Subdivision();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}