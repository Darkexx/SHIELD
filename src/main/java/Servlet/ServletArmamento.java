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
import JavaBeans.JB_Armamento;
import Datos.DAO_Armamento;

@WebServlet("/ServletArmamento")

public class ServletArmamento extends HttpServlet{
	
	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";
		
		if(opc.equals("list")) {
			
			DAO_Armamento armdao = new DAO_Armamento();
			List<JB_Armamento> lista = armdao.consuAr();
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Editables/Editable_Armamento.jsp").forward(rq, rp);
			
		}
		
		else if(opc.equals("mostrar")) {
			
			Conexion con = new Conexion();
			Connection c = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			String id_ceo = rq.getParameter("id_ceo");
			
			try {
				
				String updateSql = "SELECT * FROM armamento WHERE id_ceo = ?";
				ps = c.prepareStatement(updateSql);
				ps.setString(1, id_ceo);
				rs = ps.executeQuery();
				JB_Armamento arm = new JB_Armamento();
				while(rs.next()) {
					
					arm.setIdCeo(rs.getString("ceo"));
					arm.setTipo(rs.getString("tipo"));
					arm.setCantidad(rs.getInt("cantidad"));
					arm.setIdH(rs.getInt("grupo"));
					
				}
				rq.setAttribute("armamento", arm);
				rq.getRequestDispatcher("/Editables/Editable_Armamento.jsp").forward(rq, rp);
				
			}catch (SQLException ex) {
				System.out.println("Error en SQL " + ex.getMessage());
			}
		}
		
		else if(opc.equals("eliminar")) {
			
			String id_ceo = rq.getParameter("id_ceo");//Duda
			JB_Armamento arm = new JB_Armamento(id_ceo);
			DAO_Armamento armdao = new DAO_Armamento();
			armdao.borrar(arm);
			rp.sendRedirect("ServletArmamento");
		}	
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
		
			String id_ceo = rq.getParameter("id_ceo");
			String tipo = rq.getParameter("tipo");
			int cantidad = Integer.parseInt(rq.getParameter("cantidad"));
			int id_h = Integer.parseInt(rq.getParameter("id_h"));
			
			JB_Armamento arma = new JB_Armamento(id_ceo,tipo,cantidad,id_h);
			DAO_Armamento armadao = new DAO_Armamento();
			armadao.agregar(arma);
			rp.sendRedirect("");
	}

}
