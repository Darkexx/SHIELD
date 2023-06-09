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

@WebServlet("/ServletHeroesNoEdit")

public class ServletHeroesNoEdit extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
			
			DAO_Heroes herdao = new DAO_Heroes();
			List<JB_Heroes> lista = herdao.consulher();
			rq.setAttribute("lista",lista);
			rq.getRequestDispatcher("/Consultas/NoEdit_EquipoHer.jsp").forward(rq, rp);
			
	}

}