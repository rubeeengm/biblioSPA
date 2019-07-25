package com.fractal.practicante.bibliospa.modelo.operaciones;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que será implementada por las clases que la necesiten, es necesario
 * especifar el tipo de dato que se manejará.
 * 
 * @author      Marco Lopez.
 * @param <O>   Objeto que será manejado por la interfaz.
 */
public interface OperacionInsertar<O> {

    /**
     * Declaración de método insertar, permite hacer la inserción del objeto 
     * especificado en la base de datos.
     * @param conexion  Conexión que se utilizará en la base de datos.
     * @param object    Objeto especificado en la interfaz.
     * @return          Regresa un true si la inserción fue exitosa.
     * @throws SQLException 
     */
    public boolean insertar(Connection conexion, O object)  throws SQLException;
}
