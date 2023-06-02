package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import JavaBeans.JB_Users;

public class DAO_Users {
	
	public static final String search = "SELECT id_us, pass, roll FROM users where nom_us=?";
	
	public JB_Users busca(String nom_us) {
		
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		JB_Users user = null;
		
		try {
			
			conn = Conexion.getConnection();
			state = conn.prepareStatement(search);
			
			state.setString(1,nom_us);
			
			result= state.executeQuery();
			
			if(result.next()) {
				System.out.println("UsersDao=Encontrado");
				String id = result.getString("id_us");
				String password = result.getString("pass");
				String roll = result.getString("roll");
				
				user = new JB_Users(id,password,roll);
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
		
	}
	
}
