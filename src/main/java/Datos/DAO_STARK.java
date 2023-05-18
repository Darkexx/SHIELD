package Datos;

import JavaBeans.JB_STARK;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_STARK {
	public static final String selectSQL = "SELECT * FROM stark";
	public static final String insertSQL = "INSERT INTO stark(id_ceo,nombre) VALUES (?,?)";
	public static final String updateSQL = "UPDATE stark SET nombre = ? WHERE id_ceo = ?";
	public static final String deleteSQL = "DELETE FROM stark WHERE id_ceo = ?";
	
	public List<JB_STARK> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_STARK St = null;
		
			List<JB_STARK> stark = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_ceo = result.getString("id_ceo");
						String nombre = result.getString("nombre");
						
						St = new JB_STARK(id_ceo,nombre);
						stark.add(St);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_STARK c: stark) {
						System.out.println("id_aceo: " + c.getIdCeo());
						System.out.println("Nombre: " + c.getNombre());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return stark;
		
	}
	
	public int agregar(JB_STARK Stark) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Stark.getIdCeo());
			state.setString(2, Stark.getNombre());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_STARK StarkNvo = new JB_STARK();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_STARK Stark) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Stark.getIdCeo());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_STARK starkDlt = new JB_STARK();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_STARK Stark) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Stark.getNombre());
			state.setString(2,Stark.getIdCeo());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_STARK StarkModi = new JB_STARK();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}