package Datos;

import JavaBeans.JB_Ataque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Ataques {
	public static final String selectSQL = "SELECT * FROM ataque";
	public static final String insertSQL = "INSERT INTO ataque(id_at,nombre,muertes,heridos,pais) VALUES (?,?,?,?,?)";
	public static final String updateSQL = "UPDATE ataque SET nombre = ?, muertes = ?, heridos = ?, pais = ? WHERE id_at = ?";
	public static final String deleteSQL = "DELETE FROM ataque WHERE id_at=?";
	
	public List<JB_Ataque> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Ataque At = null;
		
			List<JB_Ataque> ataques = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_at = result.getString("id_at");
						String nombre = result.getString("nombre");
						int muertes = result.getInt("muertes");
						int heridos = result.getInt("heridos");
						String pais = result.getString("pais");
						
						At = new JB_Ataque(id_at,nombre,muertes,heridos,pais);
						ataques.add(At);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Ataque c: ataques) {
						System.out.println("id_at: " + c.getIdAt());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Muertes: " + c.getMuertes());
						System.out.println("Heridos: " + c.getHeridos());
						System.out.println("Pais: " + c.getPais());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return ataques;
		
	}
	
	public int agregar(JB_Ataque Ataque) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Ataque.getIdAt());
			state.setString(2, Ataque.getNombre());
			state.setInt(3, Ataque.getMuertes());
			state.setInt(4,Ataque.getHeridos());
			state.setString(5,Ataque.getPais());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Ataque At_nvo = new JB_Ataque();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Ataque Ataque) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Ataque.getIdAt());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Ataque At_Dlt = new JB_Ataque();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Ataque Ataque) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Ataque.getNombre());
			state.setInt(2,Ataque.getMuertes());
			state.setInt(3,Ataque.getHeridos());
			state.setString(4, Ataque.getPais());
			state.setString(5,Ataque.getIdAt());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Ataque At_mod = new JB_Ataque();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
