package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import JavaBeans.JB_Armamento;
import Datos.DAO_Armamento;

@WebServlet("/ServletArmamentoDelete")

public class ServletArmamentoDelete extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
	
			System.out.println("llego al servlet eliminar");
		
			String tipo = rq.getParameter("tipo");
			
			
			JB_Armamento arm = new JB_Armamento(tipo);
			DAO_Armamento armdao = new DAO_Armamento();
			
			armdao.borrar(arm);
		
			//String id_at = rq.getParameter("id_at");
			//JB_Ataque at = new JB_Ataque(id_at);
			//DAO_Ataques atdao = new DAO_Ataques();
		
			//atdao.borrar(at);
			
			rp.sendRedirect("");
	
	}
}