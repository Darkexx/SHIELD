package Servlet;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import Datos.Conexion;//Archivo conexión
import JavaBeans.JB_Agentes;//JavaBean Agentes
import Datos.DAO_Agentes;//DAO Agentes
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

@WebServlet("/ServletAgentesNoEdit")
public class ServletAgentesNoEdit extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        
            DAO_Agentes clidao = new DAO_Agentes();
            List<JB_Agentes> lista = clidao.seleccionar();
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("/Consultas/NoEdit_AgenteSh.jsp").forward(rq, rp);
       
    }
    
}