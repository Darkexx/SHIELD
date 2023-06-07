package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;

import Datos.Conexion;
import JavaBeans.JB_Tip_Ataque;
import Datos.DAO_TipoAt;

@WebServlet("/ServletTipAtaque")

public class ServletTipAtaque extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//-----Get-----
	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String t_at=rq.getParameter("t_ataque");
		
			DAO_TipoAt atqdao = new DAO_TipoAt();
			List<JB_Tip_Ataque> lista = atqdao.selecConsu(t_at);
			rq.setAttribute("lista",lista);
		
		if(t_at.equals("Invasion territorial")){
			
			rq.getRequestDispatcher("/Editables/VistEditInvTer.jsp").forward(rq, rp);
			
		}	
		
		else if(t_at.equals("Amenaza extraterrestre")){
			
			rq.getRequestDispatcher("/Editables/VistEditAmExt.jsp").forward(rq, rp);
		
		}
			
		
		else if(t_at.equals("Economicos")) {
			
			rq.getRequestDispatcher("/Editables/VistEditEcon.jsp").forward(rq, rp);
			
		}
		
		
		else if(t_at.equals("Mutantes")) {
			
			rq.getRequestDispatcher("/Editables/VistEditMut.jsp").forward(rq, rp);
			
		}
		
		else {
			System.out.println("Error ahhhh");
		}
		
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
		
			String id_at = rq.getParameter("id_at");
			String nombre = rq.getParameter("nombre");
			int muertes = Integer.parseInt(rq.getParameter("muertes"));
			int heridos = Integer.parseInt(rq.getParameter("heridos"));
			String pais = rq.getParameter("pais");
			
			//JB_Ataque ata = new JB_Ataque(id_at,nombre,muertes,heridos,pais);
			//DAO_Ataques atadao = new DAO_Ataques();
			//atadao.agregar(ata);
			//rp.sendRedirect("");
			
	}

}
