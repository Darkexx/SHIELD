package Datos;

import JavaBeans.JB_Involucrados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Involucrados {
	public static final String selectSQL = "SELECT * FROM agentes";
	public static final String insertSQL = "INSERT INTO agentes(id_agent,nombre,especializacion,puesto) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE agentes SET nombre = ?, especializacion = ?, puesto = ? WHERE id_agent = ?";
	public static final String deleteSQL = "DELETE FROM agentes WHERE id_agent=?";
	
	public List<JB_Involucrados> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Involucrados Inv = null;
		
			List<JB_Involucrados> involucrados = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_at = result.getString("id_at");
						int id_h = result.getInt("id_h");
						int id_agent = result.getInt("id_agent");
						String fecha = result.getString("fecha");
						
						Inv = new JB_Involucrados(id_at,id_h,id_agent,fecha);
						involucrados.add(Inv);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Involucrados c: involucrados) {
						System.out.println("id_at: " + c.getIdAt());
						System.out.println("id_h: " + c.getIdH());
						System.out.println("id_agent: " + c.getIdAgent());
						System.out.println("fecha: " + c.getFecha());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return involucrados;
		
	}
	
	public int agregar(JB_Involucrados Involucrado) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Involucrado.getIdAt());
			state.setInt(2, Involucrado.getIdH());
			state.setInt(3,Involucrado.getIdAgent());
			state.setString(4,Involucrado.getFecha());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Involucrados InvNVO = new JB_Involucrados();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Involucrados Involucrado) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Involucrado.getIdAt());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Involucrados InvDLT = new JB_Involucrados();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Involucrados Involucrado) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,Involucrado.getIdH());
			state.setInt(2,Involucrado.getIdAgent());
			state.setString(3,Involucrado.getFecha());
			state.setString(4,Involucrado.getIdAt());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Involucrados InvMod = new JB_Involucrados();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
