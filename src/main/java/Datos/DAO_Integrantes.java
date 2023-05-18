package Datos;

import JavaBeans.JB_Integrantes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Integrantes {
	public static final String selectSQL = "SELECT * FROM integrantes";
	public static final String insertSQL = "INSERT INTO integrantes(id_h,nombre) VALUES (?,?)";
	public static final String updateSQL = "UPDATE integrantes SET nombre = ? WHERE id_h = ?";
	public static final String deleteSQL = "DELETE FROM integrantes WHERE id_h = ?";
	
	public List<JB_Integrantes> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Integrantes In = null;
		
			List<JB_Integrantes> integrantes = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						int id_h = result.getInt("id_h");
						String nombre = result.getString("nombre");
						
						In = new JB_Integrantes(id_h,nombre);
						integrantes.add(In);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Integrantes c: integrantes) {
						System.out.println("id_h: " + c.getIdH());
						System.out.println("Nombre: " + c.getNombre());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return integrantes;
		
	}
	
	public int agregar(JB_Integrantes Integrante) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Integrante.getIdH());
			state.setString(2,Integrante.getNombre());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Integrantes IntNvo= new JB_Integrantes();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Integrantes Integrante) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Integrante.getIdH());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Integrantes IntDLT = new JB_Integrantes();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Integrantes Integrante) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Integrante.getNombre());
			state.setInt(2,Integrante.getIdH());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Integrantes IntModi = new JB_Integrantes();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
