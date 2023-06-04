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
import JavaBeans.JB_Integrantes;
import Datos.DAO_Integrantes;

@WebServlet("/ServletIntegrantesNoEdit")

public class ServletIntegrantesNoEdit extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Integrantes intedao = new DAO_Integrantes();
			List<JB_Integrantes> lista = intedao.consu();
			
			if (lista.isEmpty()) {
	          	System.out.println("");
	        }
	        else {
	        	System.out.println("Es es no edit ");
	        	System.out.println("Aqui hay datos ");
	        }
			
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Consultas/c_Int_her.jsp").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			
			try {
				
				String updateSql = "SELECT * FROM integrantes WHERE id_h = ?";
				ps = c.prepareStatement(updateSql);
				ps.setInt(1, id_h);
				rs = ps.executeQuery();
				JB_Integrantes Inte = new JB_Integrantes();
				while(rs.next()) {
					
					Inte.setIdH(rs.getInt("id_h"));
					Inte.setNombre(rs.getString("nombre"));
					
				}
				rq.setAttribute("integrante", Inte);
				rq.getRequestDispatcher("/Consultas/c_Int_her.jsp").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}
		
		else if(opc.equals("eliminar")) {
			
			int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			JB_Integrantes inte = new JB_Integrantes(id_h);
			DAO_Integrantes intedao = new DAO_Integrantes();
			intedao.borrar(inte);
			rp.sendRedirect("ServletIntegrantes");
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		String op;
		op=(String)rq.getSession().getAttribute("op");
		
		if(op.equals("nuevo")) {
			
			int id_h = Integer.parseInt(rq.getParameter(("id_h")));
			String nombre = rq.getParameter("nombre");
			int id_int = Integer.parseInt(rq.getParameter(("id_int")));
			
			JB_Integrantes inte = new JB_Integrantes(id_h,nombre,id_int);
			DAO_Integrantes intedao = new DAO_Integrantes();
			intedao.agregar(inte);
			rp.sendRedirect("/ServletIntegrantes");
		}
		
	}

}