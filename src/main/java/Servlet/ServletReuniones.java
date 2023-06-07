package Servlet;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import Datos.Conexion;
import JavaBeans.JB_reuniones;
import Datos.DAO_Reuniones;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

@WebServlet("/ServletReuniones")
public class ServletReuniones extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        
        	DAO_Reuniones reudao = new DAO_Reuniones();
            List<JB_reuniones> lista = reudao.cons();
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("/Editables/Editable_Reuniones.jsp").forward(rq, rp);
            
       
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        

    	   	int id_agent = Integer.parseInt(rq.getParameter("id_agent"));
    	   	String nombre = rq.getParameter("nombre");
    	   	String especializacion = rq.getParameter("especializacion");
    	   	String puesto = rq.getParameter("puesto");

            //JB_Agentes agent = new JB_Agentes(id_agent, nombre, especializacion, puesto);
            //DAO_Agentes agentdao = new DAO_Agentes();
            //agentdao.agregar(agent);
            rp.sendRedirect("");
       
    }
}