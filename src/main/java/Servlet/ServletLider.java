package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Lider;
import Datos.DAO_Lider;

@WebServlet("/ServletLider")

public class ServletLider extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Lider lidedao = new DAO_Lider();
			List<JB_Lider> lista = lidedao.seleccionar();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos ");
	        }
			
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Editables/Editable_LiderHer.jsp").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			int id_l = Integer.parseInt(rq.getParameter(("id_l")));
			
			try {
				
				String updateSql = "SELECT * FROM lider WHERE id_l = ?";
				ps = c.prepareStatement(updateSql);
				ps.setInt(1, id_l);
				rs = ps.executeQuery();
				JB_Lider lid = new JB_Lider();
				while(rs.next()) {
					
					lid.setIdL(rs.getInt("id_l"));
					lid.setNombre(rs.getString("nombre"));
					lid.setEquipoArm(rs.getString("equipo_arm"));
					
					
				}
				rq.setAttribute("lider", lid);
				rq.getRequestDispatcher("/Editables/Editable_LiderHer.jsp").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		
			
			//int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			//String nombre = rq.getParameter("nombre");
			//int id_int = Integer.parseInt(rq.getParameter("id_int"));
			
			//JB_Integrantes inte = new JB_Integrantes(id_h,nombre,id_int);
			//DAO_Integrantes intedao = new DAO_Integrantes();
			//intedao.agregar(inte);
			//rp.sendRedirect("");
		
	}

}