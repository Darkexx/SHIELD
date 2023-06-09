package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DAO_Armamento;
import JavaBeans.JB_Armamento;

@WebServlet("/ServletArmamentoUpdate")

public class ServletArmamentoUpdate extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String id_ceo = rq.getParameter("id_ceo");
		String tipo2 =  rq.getParameter("tipo2");
		int cantidad = Integer.parseInt(rq.getParameter("cantidad"));
		int id_h = Integer.parseInt(rq.getParameter("id_h"));
		
		
		String tipo = rq.getParameter("tipo");
		
		JB_Armamento arma = new JB_Armamento("id_ceo","tipo","tipo2",cantidad,id_h);
		DAO_Armamento armadao = new DAO_Armamento();
		
		arma.setIdCeo(id_ceo);
		arma.setTipo2(tipo2);
		arma.setCantidad(cantidad);
		arma.setIdH(id_h);
		arma.setTipo(tipo);
		
		armadao.modificar(arma);

		rp.sendRedirect("");
		
	}
	
}