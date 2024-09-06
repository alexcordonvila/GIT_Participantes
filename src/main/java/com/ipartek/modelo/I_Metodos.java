package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Participante;

public interface I_Metodos {

    Connection conectar();

    void desconectar(Connection con);

    int insertarParticipante(Connection con, Participante contactoInsertar);
    public List<Participante> obtenerParticipantes(Connection con);

}
