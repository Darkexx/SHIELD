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
import JavaBeans.JB_Ataque;
import Datos.DAO_Ataques;

@WebServlet(name = "ServletAtaque", urlPatterns = {"/ServletAtaque"})

public class ServletAtaque extends HttpServlet{
	
	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Ataques armdao = new DAO_Ataques();
			List<JB_Ataque> lista = armdao.seleccionar();
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("-----Aqui va JSP-----").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			
			String id_at = rq.getParameter("id_at");
			
			
			try {
				
				String updateSql = "SELECT * FROM ataque WHERE id_at = ?";
				ps = c.prepareStatement(updateSql);
				ps.setString(1, id_at);
				rs = ps.executeQuery();
				JB_Ataque at = new JB_Ataque();
				while(rs.next()) {
					
					at.setIdAt(rs.getString("id_at"));
					at.setNombre(rs.getString("nombre"));
					at.setMuertes(rs.getInt("muertes"));
					at.setHeridos(rs.getInt("heridos"));
					at.setPais(rs.getString("pais"));
					
				}
				rq.setAttribute("ataque", at);
				rq.getRequestDispatcher("-----Aqui va JSP-----").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}
		
		else if(opc.equals("eliminar")) {
			
			String id_at = rq.getParameter("id_at");//Duda
			JB_Ataque ata = new JB_Ataque(id_at);
			DAO_Ataques atadao = new DAO_Ataques();
			atadao.borrar(ata);
			rp.sendRedirect("ServletAtaque");
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		String op;
		op=(String)rq.getSession().getAttribute("op");
		
		if(op.equals("nuevo")) {
			
			String id_at = rq.getParameter("id_at");
			String nombre = rq.getParameter("nombre");
			int muertes = Integer.parseInt(rq.getParameter("muertes"));
			int heridos = Integer.parseInt(rq.getParameter("heridos"));
			String pais = rq.getParameter("pais");
			
			JB_Ataque ata = new JB_Ataque(id_at,nombre,muertes,heridos,pais);
			DAO_Ataques atadao = new DAO_Ataques();
			atadao.agregar(ata);
			rp.sendRedirect("/ServletAtaque");
		}
		
	}

}
