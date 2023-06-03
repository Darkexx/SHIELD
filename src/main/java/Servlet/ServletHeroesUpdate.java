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

import JavaBeans.JB_Heroes;
import Datos.Conexion;
import Datos.DAO_Heroes;

@WebServlet("/ServletHeroesUpdate")

public class ServletHeroesUpdate extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
		String nombre = rq.getParameter("nombre");
		int id_l = Integer.parseInt(rq.getParameter(("id_l")));
		String id_sub = rq.getParameter("id_sub");
		int id_h = Integer.parseInt(rq.getParameter(("id_h")));
		
		JB_Heroes her = new JB_Heroes("nombre",id_l,"id_sub",id_h);
		DAO_Heroes herdao = new DAO_Heroes();
		
		
		her.setNombre(nombre);
		her.setIdL(id_l);
		her.setIdSub(id_sub);
		her.setIdH(id_h);
		
		herdao.modificar(her);
		rp.sendRedirect("");
		
	}
}