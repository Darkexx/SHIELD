package Datos;

import JavaBeans.JB_Heroes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Heroes {
	public static final String selectSQL = "SELECT * FROM heroes";
	public static final String insertSQL = "INSERT INTO heroes(id_h,nombre,id_l,id_sub) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE heroes SET nombre = ?, id_l = ?, id_sub = ? WHERE id_h = ?";
	public static final String deleteSQL = "DELETE FROM heroes WHERE id_h = ?";
	public static final String consulHer = "select heroes.id_h,heroes.nombre,lider.nombre as Lider,subdivision.nombre as nombre_sub from heroes join lider on heroes.id_l=lider.id_l join subdivision on heroes.id_sub=subdivision.id_sub";
	
	public List<JB_Heroes> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Heroes Ah = null;
		
			List<JB_Heroes> heroes = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						int id_h = result.getInt("id_h");
						String nombre = result.getString("nombre");
						int id_l = result.getInt("id_l");
						String id_sub = result.getString("id_sub");
						
						Ah = new JB_Heroes(id_h,nombre,id_l,id_sub);
						heroes.add(Ah);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Heroes c: heroes) {
						System.out.println("id_h: " + c.getIdH());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("id_l: " + c.getIdL());
						System.out.println("id_sub: " + c.getIdSub());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return heroes;
		
	}
	
	///////////////////-Consulta heroes ids con nombre-//////////////////////////////////////////
	
	public List<JB_Heroes> consulher(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Heroes Ah = null;
		
			List<JB_Heroes> heroes = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(consulHer);
				
					while(result.next()) {
						
						//Aqui me quede
						
						int id_h = result.getInt("id_h");
						String nombre = result.getString("nombre");
						String id_lider = result.getString("Lider");
						String id_subdiv = result.getString("nombre_sub");
						//int id_l = result.getInt("id_l");
						//String id_sub = result.getString("id_sub");
						
						Ah = new JB_Heroes(id_h,nombre,id_lider,id_subdiv);
						heroes.add(Ah);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Heroes c: heroes) {
						System.out.println("id_h: " + c.getIdH());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("id_lider: " + c.getid_lider());
						System.out.println("id_lider: " + c.getid_subdiv());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return heroes;
	}
	///////////////////////////////////////////////////////////////////////
	
	public int agregar(JB_Heroes Heroe) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Heroe.getIdH());
			state.setString(2, Heroe.getNombre());
			state.setInt(3, Heroe.getIdL());
			state.setString(4, Heroe.getIdSub());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Heroes Heroe_nvo = new JB_Heroes();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Heroes Heroe) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1, Heroe.getIdH());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Heroes Heroe_Dlt = new JB_Heroes();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Heroes Heroe) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Heroe.getNombre());
			state.setInt(2,Heroe.getIdL());
			state.setString(3,Heroe.getIdSub());
			state.setInt(4,Heroe.getIdH());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Heroes Heroe_Mod = new JB_Heroes();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}