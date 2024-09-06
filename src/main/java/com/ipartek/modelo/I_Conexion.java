package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Conexion {

    // Conexion a la BD
    String BASE_DATOS = "db_participantes";
    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String CONEXION = "jdbc:mysql://192.168.0.66:3306/" + BASE_DATOS;
    String USUARIO = "user";
    String PASS = "12345";

    // tablas y views de la BD

    // Archivos JSP
    String JSP_INDEX = "index.jsp";

    // Tablas y vistas de la BD
    String TABLA_PARTICIPANTES = "participantes";
    String PARTICIPANTE_ID = "id";
    String PARTICIPANTE_NOMBRE = "nombre";
    String PARTICIPANTE_APELLIDOS = "apellidos";
    String PARTICIPANTE_EDAD= "edad";

    String SP_INSERTAR_PARTICIPANTE = "call sp_insertar_participante(?, ?, ?, ?);";
    String SP_OBTENER_PARTICIPANTES = "call sp_obtener_participantes();";

    // Atributos
    String ATR_LISTA_PARTICIPANTES = "atr_lista_participantes";

}
