package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Ataques;
import JavaBeans.JB_Ataque;

@WebServlet("/ServletAtaqueUpdate")

public class ServletAtaqueUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		
		String nombre = rq.getParameter("nombre");
		int muertes = Integer.parseInt(rq.getParameter("muertes"));
		int heridos = Integer.parseInt(rq.getParameter("heridos"));
		String pais = rq.getParameter("pais");
		
		String id_at = rq.getParameter("id_at");
		
		JB_Ataque ata = new JB_Ataque("nombre",muertes,heridos,"pais","id_at");
		DAO_Ataques atadao = new DAO_Ataques();
		
		ata.setNombre(nombre);
		ata.setMuertes(muertes);
		ata.setHeridos(heridos);
		ata.setPais(pais);
		ata.setIdAt(id_at);
		
		atadao.modificar(ata);
		
		//JB_Integrantes inte = new JB_Integrantes(id_h,"nombre",id_int);
		//DAO_Integrantes intedao = new DAO_Integrantes();
		
		//inte.setIdH(id_h);
		//inte.setNombre(nombre);
		//inte.setIdInt(id_int);
		
		
		//intedao.modificar(inte);
		rp.sendRedirect("");
		
	}
	
}