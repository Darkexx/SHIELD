package Datos;

import JavaBeans.JB_Agentes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Agentes {
	public static final String selectSQL = "SELECT * FROM agentes";
	public static final String insertSQL = "INSERT INTO agentes(id_agent,nombre,especializacion,puesto) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE agentes SET nombre = ?, especializacion = ?, puesto = ? WHERE id_agent = ?";
	public static final String deleteSQL = "DELETE FROM agentes WHERE id_agent=?";
	
	public List<JB_Agentes> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Agentes Ag = null;
		
			List<JB_Agentes> agentes = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						int id_agent = result.getInt("id_agent");
						String nombre = result.getString("nombre");
						String especializacion = result.getString("especializacion");
						String puesto = result.getString("puesto");
						
						Ag = new JB_Agentes(id_agent,nombre,especializacion,puesto);
						agentes.add(Ag);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Agentes c: agentes) {
						System.out.println("id_agente: " + c.getIdAgent());
						System.out.println("Nombre: " + c.getNombre());
						System.out.println("Especializacion: " + c.getEspecializacion());
						System.out.println("Puesto: " + c.getPuesto());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return agentes;
		
	}
	
	public int agregar(JB_Agentes Agente) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1, Agente.getIdAgent());
			state.setString(2, Agente.getNombre());
			state.setString(3,Agente.getEspecializacion());
			state.setString(4,Agente.getPuesto());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Agentes AgenteNvo = new JB_Agentes();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Agentes Agente) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Agente.getIdAgent());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Agentes AgenteDlt = new JB_Agentes();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Agentes Agentes) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,Agentes.getIdAgent());
			state.setString(2,Agentes.getNombre());
			state.setString(3,Agentes.getEspecializacion());
			state.setString(4,Agentes.getPuesto());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Agentes AgentModi = new JB_Agentes();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}
