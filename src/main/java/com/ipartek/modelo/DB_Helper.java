package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Helper implements I_Conexion, I_Metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

			System.out.println("BD conectada");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo conectar a la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {

		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo desconectar de la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
	}

}
