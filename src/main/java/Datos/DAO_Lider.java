package Datos;

import JavaBeans.JB_Lider;
import JavaBeans.JB_Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Lider {
	public static final String selectSQL = "SELECT * FROM lider";
	public static final String insertSQL = "INSERT INTO lider(id_l,nombre,equipo_arm) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE lider SET nombre = ?, equipo_arm = ? WHERE id_l = ?";
	public static final String deleteSQL = "DELETE FROM lider WHERE id_l= ?";
	public static final String retnom = "SELECT nombre FROM lider where id_l = ?";
	
	public List<JB_Lider> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Lider Li = null;
		
			List<JB_Lider> lideres = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						int id_l = result.getInt("id_l");
						String nombre = result.getString("nombre");
						String equipo_arm = result.getString("equipo_arm");
						
						Li = new JB_Lider(id_l,nombre,equipo_arm);
						lideres.add(Li);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Lider c: lideres) {
						System.out.println("id_l: " + c.getIdL());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Equipo_arm: " + c.getEquipoArm());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return lideres;
		
	}
	
	
	
	public String retnom(int id_l) {
		
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		String nombre = null;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(retnom);
			
			state.setInt(1,id_l);
			
			result= state.executeQuery();
			
			if(result.next()) {
				System.out.println("LiderDao=Encontrado");
				nombre = result.getString("nombre");
				
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return nombre;
		
	}
	
	
	
	public int agregar(JB_Lider Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Lider.getIdL());
			state.setString(2, Lider.getNombre());
			state.setString(3, Lider.getEquipoArm());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lider LiderNVO = new JB_Lider();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Lider Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Lider.getIdL());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lider LiderDLT = new JB_Lider();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Lider Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Lider.getNombre());
			state.setString(2,Lider.getEquipoArm());
			state.setInt(3,Lider.getIdL());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lider LiderMod = new JB_Lider();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
