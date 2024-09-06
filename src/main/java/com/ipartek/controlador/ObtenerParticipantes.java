package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Participante;
import com.ipartek.modelo.I_Conexion;

/**
 * Servlet implementation class ObtenerParticipantes
 */
@WebServlet("/ObtenerParticipantes")
public class ObtenerParticipantes extends HttpServlet implements I_Conexion  {
	private static final long serialVersionUID = 1L;
       

    public ObtenerParticipantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("VAMO A LEER LA BASE DE DATOS");
		//3 Creo el objeto base de datos y lo uso
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		//4 Actuar en la base de datos
		List<Participante> listaParticipantes = db.obtenerParticipantes(con);
		System.out.println("Lista Participantes:"+listaParticipantes);
		//5 Desconecto la base de datos
		db.desconectar(con);
		//Pasar valores al jsp
		request.setAttribute(ATR_LISTA_PARTICIPANTES, listaParticipantes);
		
		// TODO Auto-generated method stub
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
