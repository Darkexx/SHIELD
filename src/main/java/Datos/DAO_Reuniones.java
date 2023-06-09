package Datos;

import JavaBeans.JB_reuniones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Reuniones {
	public static final String selectSQL = "SELECT * FROM reuniones";
	public static final String insertSQL = "INSERT INTO reuniones(id_l,tema,hora) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE reuniones SET id_l = ? ,tema = ?, hora = ? WHERE tema = ?";
	public static final String deleteSQL = "DELETE FROM reuniones WHERE tema = ?";
	public static final String consu = "Select lider.nombre as lider ,reuniones.tema,reuniones.hora from reuniones join lider on reuniones.id_l=lider.id_l";
	
	public List<JB_reuniones> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_reuniones Re = null;
		
			List<JB_reuniones> reuniones = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						int id_l = result.getInt("id_l");
						String tema = result.getString("tema");
						String hora = result.getString("hora");
						
						Re = new JB_reuniones(id_l,tema,hora);
						reuniones.add(Re);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_reuniones c: reuniones) {
						System.out.println("id_l: " + c.getIdL());
						System.out.println("tema: " + c.getTema());
						System.out.println("hora: " + c.getHora());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return reuniones;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<JB_reuniones> cons(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_reuniones Re = null;
		
			List<JB_reuniones> reuniones = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(consu);
				
					while(result.next()) {
						
						//int id_ls = result.getInt("id_ls");
						String lider = result.getString("lider");
						String tema = result.getString("tema");
						String hora = result.getString("hora");
						
						Re = new JB_reuniones(lider,tema,hora);
						reuniones.add(Re);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_reuniones c: reuniones) {
						System.out.println("id_l: " + c.getLider());
						System.out.println("tema: " + c.getTema());
						System.out.println("hora: " + c.getHora());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return reuniones;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int agregar(JB_reuniones Reunion) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Reunion.getIdL());
			state.setString(2, Reunion.getTema());
			state.setString(3,Reunion.getHora());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_reuniones ReunionNvo = new JB_reuniones();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_reuniones Reunion) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Reunion.getTema());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_reuniones ReunionDLT = new JB_reuniones();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_reuniones Reunion) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,Reunion.getIdL());
			state.setString(2,Reunion.getTema2());
			state.setString(3,Reunion.getHora());
			
			state.setString(4,Reunion.getTema());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_reuniones ReunionModi = new JB_reuniones();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}