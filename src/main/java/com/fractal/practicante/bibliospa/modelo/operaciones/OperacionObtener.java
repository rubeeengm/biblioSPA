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
public interface OperacionObtener<O> {

    /**
     * Declaración del método obtener, permite obtener el objeto especificado.
     * 
     * @param conexion  Conexión que se utilizará en la base de datos.
     * @param id        Entero que especifica el objeto que se quiere buscar en
     *                  la base de datos.
     * @return          Regresa el objeto que se buscó.
     * @throws SQLException 
     */
    public O obtener(Connection conexion, int id) throws SQLException;
}
