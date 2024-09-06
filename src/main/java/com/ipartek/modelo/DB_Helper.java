package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Participante;

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

    @Override
    public int insertarParticipante(Connection con, Participante participanteInsertar) {

	try {

	    CallableStatement cStmt = con.prepareCall(SP_INSERTAR_PARTICIPANTE);

	    cStmt.setString(1, participanteInsertar.getNombre());
	    cStmt.setString(2, participanteInsertar.getApellidos());
	    cStmt.setInt(3, participanteInsertar.getEdad());
	    return cStmt.executeUpdate();
	} catch (SQLException e) {
	    System.out.println("ERROR DE BD: INSERTAR PARTICIPANTE");
	    System.out.println("No se pudo insertar el participante");

	    return 0;
	}
    }

    public List<Participante> obtenerParticipantes(Connection con) {
	List<Participante> lista = new ArrayList<Participante>();

	try {
	    CallableStatement cStmt = con.prepareCall(SP_OBTENER_PARTICIPANTES);

	    boolean tieneSelect = cStmt.execute();

	    if (tieneSelect == true) {
		// cargar la lista

		ResultSet rs = cStmt.getResultSet();

		while (rs.next()) {

		    Participante participante = new Participante();

		    participante.setId(rs.getInt(PARTICIPANTE_ID));
		    participante.setNombre(rs.getString(PARTICIPANTE_NOMBRE));
		    participante.setApellidos(rs.getString(PARTICIPANTE_APELLIDOS));
		    participante.setEdad(rs.getInt(PARTICIPANTE_EDAD));

		    lista.add(participante);
		}

		System.out.println("Lista de todos los participantes obtenida:");
		System.out.println(lista);

		return lista;
	    } else {

		System.out.println("No se pudo obtener una lista de participantes");
		System.out.println("El Stored procedure no tiene un RESULTSET");

		return new ArrayList<Participante>();
	    }
	} catch (SQLException e) {

	    System.out.println("ERROR DE BD: CONSULTA");
	    System.out.println("Error al obtener la lista de todos los participantes");
	    System.out.println(e.getMessage());

	    return new ArrayList<Participante>();
	}
    }

}
