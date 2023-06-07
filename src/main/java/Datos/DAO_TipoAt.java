package Datos;

import JavaBeans.JB_Tip_Ataque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_TipoAt {
	public static final String selectSQL = "SELECT * FROM tip_ataque";
	public static final String selectConsu = "SELECT * FROM tip_ataque Where nom_tipo = ?";
	public static final String insertSQL = "INSERT INTO tip_ataque(id_at,nom_tipo,reg_afect,mutant_afect,grupo_at,alien,bienes) VALUES (?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE tip_ataque SET nom_tipo = ?, reg_afect = ?, grupo_at = ?, alien = ?, bienes = ? WHERE id_at = ?";
	public static final String deleteSQL = "DELETE FROM tip_ataque WHERE id_at=?";
	
	public List<JB_Tip_Ataque> seleccionar(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		JB_Tip_Ataque Tat = null;
		
			List<JB_Tip_Ataque> tipoat = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.createStatement();
				result = state.executeQuery(selectSQL);
				
					while(result.next()) {
						
						String id_at = result.getString("id_at");
						String nom_tipo = result.getString("nom_tipo");
						String reg_afect = result.getString("reg_afect");
						String mutant_afect = result.getString("mutant_afect");
						String grupo_at = result.getString("grupo_at");
						String alien = result.getString("alien");
						String bienes = result.getString("bienes");
						
						Tat = new JB_Tip_Ataque(id_at,nom_tipo,reg_afect,mutant_afect,grupo_at,alien,bienes);
						tipoat.add(Tat);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Tip_Ataque c: tipoat) {
						System.out.println("id_at: " + c.getIdAt());
						System.out.println("Nombre tipo: " + c.getNomTipo());
						System.out.println("reg afect: " + c.getRegAfect());
						System.out.println("mutant afect: " + c.getMutantAfect());
						System.out.println("grupo at: " + c.getGrupoAt());
						System.out.println("alien: " + c.getAlien());
						System.out.println("bienes: " + c.getBienes());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return tipoat;
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<JB_Tip_Ataque> selecConsu(String var){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		JB_Tip_Ataque Tat = null;
		
			List<JB_Tip_Ataque> tipoat = new ArrayList<>();
			
			try {
				
				conn = Conexion.getConnection();
				state = conn.prepareStatement(selectConsu);
				
				state.setString(1, var);
				
				result = state.executeQuery();
				
					while(result.next()) {
						
						String id_at = result.getString("id_at");
						String nom_tipo = result.getString("nom_tipo");
						String reg_afect = result.getString("reg_afect");
						String mutant_afect = result.getString("mutant_afect");
						String grupo_at = result.getString("grupo_at");
						String alien = result.getString("alien");
						String bienes = result.getString("bienes");
						
						Tat = new JB_Tip_Ataque(id_at,nom_tipo,reg_afect,mutant_afect,grupo_at,alien,bienes);
						tipoat.add(Tat);
						
					}
					
					Conexion.close(result);
					Conexion.close(state);
					Conexion.close(conn);
					
					for(JB_Tip_Ataque c: tipoat) {
						System.out.println("id_at: " + c.getIdAt());
						System.out.println("Nombre tipo: " + c.getNomTipo());
						System.out.println("reg afect: " + c.getRegAfect());
						System.out.println("mutant afect: " + c.getMutantAfect());
						System.out.println("grupo at: " + c.getGrupoAt());
						System.out.println("alien: " + c.getAlien());
						System.out.println("bienes: " + c.getBienes());
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return tipoat;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int agregar(JB_Tip_Ataque Tipo) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1, Tipo.getIdAt());
			state.setString(2, Tipo.getNomTipo());
			state.setString(3, Tipo.getRegAfect());
			state.setString(4, Tipo.getMutantAfect());
			state.setString(5, Tipo.getGrupoAt());
			state.setString(6, Tipo.getAlien());
			state.setString(7, Tipo.getBienes());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Tip_Ataque TipNvo = new JB_Tip_Ataque();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(JB_Tip_Ataque Tipo) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setString(1, Tipo.getIdAt());
			registros = state.executeUpdate();
			
			if(registros>0) {
					System.out.println("Registro Eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Tip_Ataque TipoDlt = new JB_Tip_Ataque();
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return registros;
		
	}
	
	public int modificar(JB_Tip_Ataque Tipo) {
		
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1, Tipo.getNomTipo());
			state.setString(2, Tipo.getRegAfect());
			state.setString(3, Tipo.getMutantAfect());
			state.setString(4, Tipo.getGrupoAt());
			state.setString(5, Tipo.getAlien());
			state.setString(6, Tipo.getBienes());
			state.setString(7, Tipo.getIdAt());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro Actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			JB_Tip_Ataque TipoModi = new JB_Tip_Ataque();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return registros;
		
	}
	
}