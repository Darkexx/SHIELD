package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Involucrados;
import Datos.DAO_Involucrados;

@WebServlet("/ServletInvolucradosNoEdit")

public class ServletInvolucradosNoEdit extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Involucrados invodao = new DAO_Involucrados();
			List<JB_Involucrados> lista = invodao.consult();
			
			if (lista.isEmpty()) {
	          	System.out.println("void como el void");
	        }
	        else {
	        	System.out.println("Aqui hay datos we");
	        }
			
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Consultas/NoEdit_Involucrados.jsp").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			int id_at = Integer.parseInt(rq.getParameter(("id_at")));
			
			try {
				
				String updateSql = "SELECT * FROM involucrados WHERE id_at = ?";
				ps = c.prepareStatement(updateSql);
				ps.setInt(1, id_at);
				rs = ps.executeQuery();
				JB_Involucrados inv = new JB_Involucrados();
				while(rs.next()) {
					
					inv.setIdAt(rs.getString("id_at"));
					inv.setIdH(rs.getInt("id_h"));
					inv.setIdAgent(rs.getInt("id_agent"));
					inv.setFecha(rs.getString("fecha"));
					
					
					//lid.setIdL(rs.getInt("id_l"));
					//lid.setNombre(rs.getString("nombre"));
					//lid.setEquipoArm(rs.getString("equipo_arm"));
					
					
				}
				rq.setAttribute("involucrado", inv);
				rq.getRequestDispatcher("/Editables/Editable_Involucrados.jsp").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		
			String id_at = rq.getParameter("id_at");
			int id_h = Integer.parseInt(rq.getParameter("id_h"));
			int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
			String fecha = rq.getParameter("fecha");
			
			//int id_l = Integer.parseInt(rq.getParameter(("id_l")));
			//String nombre = rq.getParameter("nombre");
			//String arma = rq.getParameter("equipo_arm");
			
			JB_Involucrados inv = new JB_Involucrados(id_at,id_h,id_agent,fecha);
			DAO_Involucrados invdao = new DAO_Involucrados();
			
			invdao.agregar(inv);
			
			//JB_Lider lid = new JB_Lider(id_l,nombre,arma);
			//DAO_Lider lidao = new DAO_Lider();
			
			//lidao.agregar(lid);
			rp.sendRedirect("");
		
	}

}