package Datos;

import JavaBeans.JB_Armamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Armamento {
	public static final String selectSQL = "SELECT * FROM armamento";
	public static final String insertSQL = "INSERT INTO armamento(id_ceo,tipo,cantidad,id_h) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE armamento SET tipo = ?, cantidad = ?, id_h = ? WHERE id_ceo = ?";
	public static final String deleteSQL = "DELETE FROM armamento WHERE id_ceo=?";
	public static final String deleteSQLfromTipo = "DELETE FROM armamento WHERE tipo=?";
	public static final String consuArm = "select stark.nombre as ceo,armamento.tipo,armamento.cantidad,heroes.nombre as grupo from armamento join stark on armamento.id_ceo=stark.id_ceo join heroes on armamento.id_h=heroes.id_h";
	
	public List<JB_Armamento> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Armamento Arm = null;
		
			List<JB_Armamento> armamentos = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_ceo = result.getString("id_ceo");
						String tipo = result.getString("tipo");
						int cantidad = result.getInt("cantidad");
						int id_h = result.getInt("id_h");
						
						Arm = new JB_Armamento(id_ceo,tipo,cantidad,id_h);
						armamentos.add(Arm);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Armamento c: armamentos) {
						System.out.println("id_ceo: " + c.getIdCeo());
						System.out.println("Tipo: " + c.getTipo());
						System.out.println("Cantidad: " + c.getCantidad());
						System.out.println("id_h: " + c.getIdH());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return armamentos;
		
	}
	
	//////////////////////////////////////////////////////////////////
	
	public List<JB_Armamento> consuAr(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Armamento Arm = null;
		
			List<JB_Armamento> armamentos = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(consuArm);
				
					while(result.next()) {
						
						String ceo = result.getString("ceo");
						String tipo = result.getString("tipo");
						int cantidad = result.getInt("cantidad");
						String grupo = result.getString("grupo");
						
						Arm = new JB_Armamento(ceo,tipo,cantidad,grupo);
						armamentos.add(Arm);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Armamento c: armamentos) {
						System.out.println("id_ceo: " + c.getIdCeo());
						System.out.println("Tipo: " + c.getTipo());
						System.out.println("Cantidad: " + c.getCantidad());
						System.out.println("id_h: " + c.getIdH());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return armamentos;
		
	}
	
	///////////////////////////////////////////////////////////////////
	
	public int agregar(JB_Armamento armamento) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, armamento.getIdCeo());
			state.setString(2,armamento.getTipo());
			state.setInt(3,armamento.getCantidad());
			state.setInt(4,armamento.getIdH());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Armamento AgenteNvo = new JB_Armamento();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Armamento armamento) {
		
		System.out.println("Llego al dao armamento");
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQLfromTipo);
			
			state.setString(1,armamento.getIdCeo());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Armamento AgenteDlt = new JB_Armamento();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Armamento armamento) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			
			state.setString(1,armamento.getTipo());
			state.setInt(2,armamento.getCantidad());
			state.setInt(3,armamento.getIdH());
			state.setString(4,armamento.getIdCeo());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Armamento AgentModi = new JB_Armamento();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
