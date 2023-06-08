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

@WebServlet("/ServletArmamento")

public class ServletArmamento extends HttpServlet{
	
	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
			
			//Para mostra tabla armamento
			DAO_Armamento armdao = new DAO_Armamento();
			List<JB_Armamento> lista = armdao.consuAr();
			rq.setAttribute("lista",lista);
			
			
			rq.getRequestDispatcher("/Editables/Editable_Armamento.jsp").forward(rq, rp);
		
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
