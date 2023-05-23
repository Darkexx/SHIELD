
import java.sql.*;
import java.util.*;


import Datos.*;
import JavaBeans.*;

public class main {
	
	public static void main(String[] args) {
		Conexion conn = new Conexion();
		Connection connection = null;
		
		//JB_Agentes ag = new JB_Agentes();
		//DAO_Agentes agdao = new DAO_Agentes();
		
		//JB_Integrantes ig = new JB_Integrantes();
		DAO_Integrantes igdao = new DAO_Integrantes();
		
		System.out.println(igdao.consu());
		
		//JB_Agentes ag = new JB_Agentes(43,"Luis Angel Arias Romero","Agente informatico","Conserje");
		//DAO_Agentes agdao = new DAO_Agentes();
		
		//agdao.agregar(ag);
	}

}
