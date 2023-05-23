
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import Datos.DAO_Agentes;
import JavaBeans.JB_Agentes;

public class main {
	
	public static void main(String[] args) {
		Conexion conn = new Conexion();
		Connection connection = null;
		
		JB_Agentes ag = new JB_Agentes();
		DAO_Agentes agdao = new DAO_Agentes();
		
		System.out.println(agdao.seleccionar());
	}

}
