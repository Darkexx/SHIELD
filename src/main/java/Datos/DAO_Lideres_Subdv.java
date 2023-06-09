package Datos;

import JavaBeans.JB_Lideres_Subdivision;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Lideres_Subdv {
	public static final String selectSQL = "SELECT * FROM lideres_subdivision";
	public static final String insertSQL = "INSERT INTO lideres_subdivision(id_ls,nombre,rango,id_sub) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE lideres_subdivision SET nombre = ?, rango = ?, id_sub = ? WHERE id_ls = ?";
	public static final String deleteSQL = "DELETE FROM lideres_subdivision WHERE id_ls=?";
	public static final String consuLid = "SELECT lideres_subdivision.id_ls,lideres_subdivision.nombre,lideres_subdivision.rango,subdivision.nombre as Subdivision  FROM lideres_subdivision join subdivision on lideres_subdivision.id_sub=subdivision.id_sub";
	
	public List<JB_Lideres_Subdivision> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Lideres_Subdivision Lis = null;
		
			List<JB_Lideres_Subdivision> lidsub = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_ls = result.getString("id_ls");
						String nombre = result.getString("nombre");
						String rango = result.getString("rango");
						String id_sub = result.getString("id_sub");
						
						Lis = new JB_Lideres_Subdivision(id_ls,nombre,rango,id_sub);
						lidsub.add(Lis);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Lideres_Subdivision c: lidsub) {
						System.out.println("id_ls: " + c.getIdLs());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Rango: " + c.getRango());
						System.out.println("id_sub: " + c.getIdSub());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return lidsub;
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public List<JB_Lideres_Subdivision> consuLid(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Lideres_Subdivision Lis = null;
		
			List<JB_Lideres_Subdivision> lidsub = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(consuLid);
				
					while(result.next()) {
						
						String id_ls = result.getString("id_ls");
						String nombre = result.getString("nombre");
						String rango = result.getString("rango");
						String Subdivision = result.getString("Subdivision");
						
						Lis = new JB_Lideres_Subdivision(id_ls,nombre,rango,Subdivision);
						lidsub.add(Lis);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Lideres_Subdivision c: lidsub) {
						System.out.println("id_ls: " + c.getIdLs());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Rango: " + c.getRango());
						System.out.println("id_sub: " + c.getIdSub());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return lidsub;
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	public int agregar(JB_Lideres_Subdivision Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Lider.getIdLs());
			state.setString(2, Lider.getNombre());
			state.setString(3, Lider.getRango());
			state.setString(4, Lider.getIdSub());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lideres_Subdivision LidSubNvo = new JB_Lideres_Subdivision();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Lideres_Subdivision Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1,Lider.getIdLs());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lideres_Subdivision LidSubDLT = new JB_Lideres_Subdivision();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Lideres_Subdivision Lider) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Lider.getNombre());
			state.setString(2,Lider.getRango());
			state.setString(3,Lider.getIdSub());
			state.setString(4,Lider.getIdLs());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Lideres_Subdivision LidSubModi = new JB_Lideres_Subdivision();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}