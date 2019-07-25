package com.fractal.practicante.bibliospa.modelo.operaciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz que será implementada por las clases que la necesiten, es necesario
 * especifar el tipo de dato que se manejará.
 * 
 * @author      Marco Lopez.
 * @param <O>   Objeto que será manejado por la interfaz.
 */
public interface OperacionObtenerTodos<O> {

    /**
     * Declaración del método obtenerTodos, permite obtener todos los objetos
     * especificados.
     * 
     * @param conexion  Conexión que se utilizará en la base de datos.
     * @return          Regresa un ArrayList con todos los objetos 
     *                  especificados.
     * @throws SQLException 
     */
    public ArrayList<O> obtenerTodos(Connection conexion) throws SQLException;
}
