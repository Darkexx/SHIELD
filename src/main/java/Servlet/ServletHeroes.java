package Servlet;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

import Datos.Conexion;
import JavaBeans.JB_Heroes;
import Datos.DAO_Heroes;

@WebServlet("/ServletHeroes")

public class ServletHeroes extends HttpServlet{
	
	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Heroes herdao = new DAO_Heroes();
			List<JB_Heroes> lista = herdao.seleccionar();
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Editables/Editable_EquipoHer.jsp").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			int id_h = Integer.parseInt(rq.getParameter("id_h"));
			
			try {
				
				String updateSql = "SELECT * FROM heroes WHERE id_h = ?";
				ps = c.prepareStatement(updateSql);
				ps.setInt(1, id_h);
				rs = ps.executeQuery();
				JB_Heroes her = new JB_Heroes();
				while(rs.next()) {
					
					her.setIdH(rs.getInt("id_h"));
					her.setNombre(rs.getString("nombre"));
					her.setIdL(rs.getInt("id_l"));
					her.setIdSub(rs.getString("id_sub"));
					
				}
				rq.setAttribute("heroes", her);
				rq.getRequestDispatcher("/Editables/Editable_EquipoHer.jsp").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}
		
		else if(opc.equals("eliminar")) {
			
			int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			JB_Heroes her = new JB_Heroes(id_h);
			DAO_Heroes herdao = new DAO_Heroes();
			herdao.borrar(her);
			rp.sendRedirect("ServletHeroes");
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		String op;
		op=(String)rq.getSession().getAttribute("op");
		
		if(op.equals("nuevo")) {
			
			int id_h = Integer.parseInt(rq.getParameter("id_h"));
			String nombre = rq.getParameter("nombre");
			int id_l = Integer.parseInt(rq.getParameter("id_l"));
			String id_sub = rq.getParameter("id_sub");
			
			JB_Heroes her = new JB_Heroes(id_h,nombre,id_l,id_sub);
			DAO_Heroes herdao = new DAO_Heroes();
			herdao.agregar(her);
			rp.sendRedirect("/ServletHeroes");
		}
		
	}

}