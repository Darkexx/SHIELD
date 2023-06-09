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

import JavaBeans.JB_Armamento;
import Datos.DAO_Armamento;

@WebServlet("/ServletArmamentoNoEdit")

public class ServletArmamentoNoEdit extends HttpServlet{
	
	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			//Para mostra tabla armamento
			DAO_Armamento armdao = new DAO_Armamento();
			List<JB_Armamento> lista = armdao.consuAr();
			rq.setAttribute("lista",lista);
			
			
			rq.getRequestDispatcher("/Consultas/NoEdit_Armamento.jsp").forward(rq, rp);
		
	}

}