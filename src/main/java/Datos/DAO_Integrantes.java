package Datos;

import JavaBeans.JB_Integrantes;
import JavaBeans.JB_Heroes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Integrantes {
	public static final String selectSQL = "SELECT * FROM integrantes";
	public static final String insertSQL = "INSERT INTO integrantes(id_h,nombre,id_int) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE integrantes SET id_h = ? , nombre = ? WHERE id_int = ?";
	public static final String deleteSQL = "DELETE FROM integrantes WHERE id_int = ? ";
	public static final String ConsulHerAgSQL = "select heroes.nombre as Agencia , integrantes.nombre ,integrantes.id_int from integrantes join heroes on integrantes.id_h=heroes.id_h";
	
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
						int id_int = result.getInt("id_int");
						
						In = new JB_Integrantes(id_h,nombre,id_int);
						integrantes.add(In);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Integrantes c: integrantes) {
						System.out.println("id_h: " + c.getIdH());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Id_int: "+c.getIdInt());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return integrantes;
		
	}
	
	//////////////////--Consulta Integrantes/Heroes--//////////////////////////////////////////////////////////////////////////////////
	public List<JB_Integrantes> consu(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Integrantes In = null;
		
			List<JB_Integrantes> integrantes = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(ConsulHerAgSQL);
				
					while(result.next()) {
						
						//int id_h = result.getInt("id_h");
						String nombre = result.getString("Agencia");
						String nombre2 = result.getString("nombre");
						int id_int = result.getInt("id_int");
						
						In = new JB_Integrantes(nombre,nombre2,id_int);
						integrantes.add(In);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					//JB_Heroes he = new JB_Heroes();
					JB_Integrantes in = new JB_Integrantes();
					
					for(JB_Integrantes c: integrantes) {
						System.out.println("Agencia: " + c.getNombre());
						System.out.println("Integrante: " + c.getNombre2());
						//System.out.println("xD: " + c.getNombre());
						//System.out.println("Agencia: " + c.);
						//System.out.println("Nombre: " + he.getNombre());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return integrantes;
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int agregar(JB_Integrantes Integrante) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Integrante.getIdH());
			state.setString(2,Integrante.getNombre());
			state.setInt(3,Integrante.getIdInt());
			
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
			
			state.setInt(1, Integrante.getIdInt());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(registros);
		
		return registros;
		
	}
	
	public int modificar(JB_Integrantes Integrante) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,Integrante.getIdH());
			state.setString(2,Integrante.getNombre());
			state.setInt(3, Integrante.getIdInt());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
