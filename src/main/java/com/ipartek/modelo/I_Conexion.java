package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Conexion {
	
	//Conexion a la BD
	String BASE_DATOS = "vueltacole";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	//tablas y views de la BD
	
	
	//Archivos JSP
	String JSP_INDEX="index.jsp";




	
	
	


}
