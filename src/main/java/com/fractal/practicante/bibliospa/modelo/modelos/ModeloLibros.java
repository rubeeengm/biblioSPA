package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.operaciones.
        OperacionInsertar;
import com.fractal.practicante.bibliospa.modelo.operaciones.
        OperacionObtener;
import com.fractal.practicante.bibliospa.modelo.operaciones.
        OperacionObtenerTodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase que hereda las diferentes interfaces que nos permiten obtener los 
 * objetos de tipo Libro, asi como hacer sus inserciones en la BD.
 * @author Marco Lopez
 */
public class ModeloLibros implements OperacionObtener<Libro>, 
        OperacionObtenerTodos<Libro>, OperacionInsertar<Libro>{
    
    /**
     * Método que al recibir una conexión y un objeto Libro, manda a llamar al 
     * procedimiento adecuado de la BD para insertar un nuevo Libro en la tabla 
     * de la BD.
     * 
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param libro     Objeto Libro con todos sus atributos con información 
     *                  para poder insertar uno nuevo en la BD con ella.
     * @return          Regresa false de no haberse completado y true de sí 
     *                  haberse realizado.
     */
    @Override
    public boolean insertar(Connection conexion, Libro libro) throws SQLException {
        try{
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(
                "CALL USP_LIBROS_C (?, ?, ?, ?);"
            );
            consulta.setString(1, libro.getTitulo());
            consulta.setString(2, libro.getAutor());
            consulta.setInt(3, libro.getNumPaginas());
            consulta.setString(4, libro.getIsbn());
            consulta.executeUpdate();
            return true;
        }catch(SQLException error){
            return false;
        }
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al 
     * procedimiento adecuado de la BD para regresar un objeto con todos los 
     * atributos de un Libro en particular.
     * 
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param id        Entero que se usará en la búsqueda de un Libro por su 
     *                  ID en la BD. 
     * @return          Libro cuyo ID es el solicitado y con todos sus atributos
     *                  con su respectiva información.
     * @throws SQLException 
     */
    @Override
    public Libro obtener(Connection conexion, int id) throws SQLException{
        Libro libro = null;
        PreparedStatement consulta = conexion.prepareStatement(
            "CALL USP_LIBROS_R (?);"
        );
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            libro = new Libro(Integer.parseInt(
                resultado.getString("ID")),
                resultado.getString("TITULO"),
                resultado.getString("AUTOR"),
                Integer.parseInt(resultado.getString("NUMPAGINAS")),
                resultado.getString("ESTADO").charAt(0),
                resultado.getString("ISBN")
            );    
        }
        return libro;
    }
    
    /**
     * Método que al recibir una conexión, manda a llamar al procedimiento 
     * adecuado de la BD para regresar un ArrayList con todos los Libros 
     * registrados en la BD.
     * 
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @return          ArrayList de objetos de tipo Libro igual al número de 
     *                  Libros registrados en la BD con todos sus datos.
     * @throws SQLException 
     */
    
    public ArrayList<Libro> obtenerLibrosAlumno(Connection conexion, int idUsuario) throws SQLException{
        ArrayList<Libro> libros = new ArrayList();
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_LIBROS_USUARIO_R_TODOS (?);");
        consulta.setInt(1,idUsuario);
        ResultSet resultado = consulta.executeQuery();
        
        while(resultado.next()){
            Libro libro = null;
            libro = new Libro(
                            resultado.getString("TITULO"),
                            resultado.getString("AUTOR"),
                            resultado.getInt("NUMPAGINAS")
                        );
            libros.add(libro);
        }
        return libros;
    }
    
    /**
     * Método que al recibir una conexión, manda a llamar al procedimiento adecuado de la BD para regresar un ArrayList con todos los Libros registrados en la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @return ArrayList de objetos de tipo Libro igual al número de Libros registrados en la BD con todos sus datos.
     * @throws SQLException 
     */
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("CALL USP_LIBROS_D (?);");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            return true;
        }catch(SQLException error){
            return false;
        }    
        
    }
    
    /**
     * 
     * @param conexion
     * @return
     * @throws SQLException 
     */      
    @Override
    public ArrayList<Libro> obtenerTodos(Connection conexion) 
            throws SQLException{
        ArrayList<Libro> libros = new ArrayList();
        PreparedStatement consulta = conexion.prepareStatement(
            "CALL USP_LIBROS_RTODOS ();"
        );
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            Libro libro = null;
            libro = new Libro(Integer.parseInt(
                resultado.getString("ID")),
                resultado.getString("TITULO"),
                resultado.getString("AUTOR"),
                Integer.parseInt(resultado.getString("NUMPAGINAS")),
                resultado.getString("ESTADO").charAt(0),
                resultado.getString("ISBN")
            );   
            libros.add(libro);
        }
        return libros;
    }
    
    /**
     * 
     * @param conexion
     * @return
     * @throws SQLException 
     */
    public ArrayList<Libro> obtenerDisponibles(Connection conexion) 
            throws SQLException{
        ArrayList<Libro> libros = new ArrayList();
        PreparedStatement consulta = conexion.prepareStatement(
            "CALL USP_LIBROS_RTODOS ();"
        );
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            if(resultado.getString("ESTADO").charAt(0) == '1'){
                Libro libro = null;
                libro = new Libro(
                    resultado.getInt("ID"),
                    resultado.getString("TITULO"),
                    resultado.getString("AUTOR"),
                    Integer.parseInt(resultado.getString("NUMPAGINAS")),
                    resultado.getString("ESTADO").charAt(0),
                    resultado.getString("ISBN")
                );
                
                libros.add(libro);
            }
            
        }
        return libros;
    }
}
