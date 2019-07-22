package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloLibros {
    /**
     * Método que al recibir una conexión y un objeto Libro, manda a llamar al procedimiento adecuado de la BD para insertar un nuevo Libro en la tabla de la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param libro Objeto Libro con todos sus atributos con información para poder insertar uno nuevo en la BD con ella.
     * @throws SQLException 
     */
    public void insertar(Connection conexion, Libro libro) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("CALL USP_LIBROS_C (?, ?, ?, ?);");
            consulta.setString(1, libro.getTitulo());
            consulta.setString(2, libro.getAutor());
            consulta.setInt(3, libro.getNumPaginas());
            consulta.setString(4, libro.getIsbn());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para regresar un objeto con todos los atributos de un Libro en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Libro por su ID en la BD. 
     * @return Libro cuyo ID es el solicitado y con todos sus atributos con su respectiva información.
     * @throws SQLException 
     */
    public Libro obtener(Connection conexion, int id) throws SQLException{
        Libro libro = null;
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_LIBROS_R (?);");
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            libro = new Libro(Integer.parseInt(resultado.getString("ID")),
                                               resultado.getString("TITULO"),
                                               resultado.getString("AUTOR"),
                                               Integer.parseInt(resultado.getString("NUMPAGINAS")),
                                               resultado.getString("ESTADO").charAt(0),
                                               resultado.getString("ISBN"));
        }
        return libro;
    }
    
    /**
     * Método que al recibir una conexión, manda a llamar al procedimiento adecuado de la BD para regresar un ArrayList con todos los Libros registrados en la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @return ArrayList de objetos de tipo Libro igual al número de Libros registrados en la BD con todos sus datos.
     * @throws SQLException 
     */
    public ArrayList<Libro> obtenerTodos(Connection conexion) throws SQLException{
        ArrayList<Libro> libros = new ArrayList();
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_LIBROS_RTODOS ();");
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            Libro libro = null;
            libro = new Libro(Integer.parseInt(resultado.getString("ID")),
                                               resultado.getString("TITULO"),
                                               resultado.getString("AUTOR"),
                                               Integer.parseInt(resultado.getString("NUMPAGINAS")),
                                               resultado.getString("ESTADO").charAt(0),
                                               resultado.getString("ISBN"));
            libros.add(libro);
        }
        return libros;
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para eliminar un registro con todos los atributos de un Libro en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD.
     * @throws SQLException 
     */
    public void eliminar(Connection conexion, int id) throws SQLException{
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("CALL USP_LIBROS_D (?);");
        consulta.setInt(1, id);
        consulta.executeUpdate();
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para modificar un registro de un Libro en particular, cambiando su estado a 0.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD.
     * @throws SQLException 
     */
    public void ocupar(Connection conexion, int id) throws SQLException{
        Libro libro = null;
        PreparedStatement consulta = conexion.prepareStatement("UPDATE LIBROS"
                +                                              " SET ESTADO = '0'"
                +                                              " WHERE ID = (?);");
        consulta.setInt(1, id);
        consulta.executeUpdate();
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para modificar un registro de un Libro en particular, cambiando su estado a 1.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD.
     * @throws SQLException 
     */
    public void desocupar(Connection conexion, int id) throws SQLException{
        Libro libro = null;
        PreparedStatement consulta = conexion.prepareStatement("UPDATE LIBROS"
                +                                              " SET ESTADO = '1'"
                +                                              " WHERE ID = (?);");
        consulta.setInt(1, id);
        consulta.executeUpdate();
    }
}
