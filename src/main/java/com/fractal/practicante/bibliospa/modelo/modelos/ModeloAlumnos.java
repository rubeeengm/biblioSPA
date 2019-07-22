package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloAlumnos{
    /**
     * Método que al recibir una conexión y un objeto Alumno, manda a llamar al procedimiento adecuado de la BD para insertar un nuevo Alumno en la tabla de la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param alumno Objeto Alumno con todos sus atributos con información para poder insertar uno nuevo en la BD con ella.
     * @throws SQLException 
     */
    public void insertar(Connection conexion, Alumno alumno) throws SQLException{
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("CALL USP_ALUMNOS_C (?, ?, ?, ?, ?, ?);");
        consulta.setString(1, alumno.getNombre());
        consulta.setString(2, alumno.getApellidoPaterno());
        consulta.setString(3, alumno.getApellidoMaterno());
        consulta.setString(4, alumno.getTelefono());
        consulta.setString(5, alumno.getDni());
        consulta.setInt(6, alumno.getIdUsuario());
        consulta.executeUpdate();
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para regresar un objeto con todos los atributos de un Alumno en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD. 
     * @return Alumno cuyo ID es el solicitado y con todos sus atributos con su respectiva información.
     * @throws SQLException 
     */
    public Alumno obtener(Connection conexion, int id) throws SQLException{
        Alumno alumno = null;
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_ALUMNOS_R (?);");
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            alumno = new Alumno(Integer.parseInt(resultado.getString("ID")),
                                                 resultado.getString("NOMBRE"),
                                                 resultado.getString("PAPELLIDO"),
                                                 resultado.getString("SAPELLIDO"),
                                                 resultado.getString("TELEFONO"),
                                                 resultado.getString("DNI"),
                                Integer.parseInt(resultado.getString("IDUSUARIO")));
        }
        return alumno;
    }
    
    /**
     * Método que al recibir una conexión, manda a llamar al procedimiento adecuado de la BD para regresar un ArrayList con todos los Alumnos registrados en la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @return ArrayList de objetos de tipo Alumno igual al número de Alumnos registrados en la BD con todos sus datos.
     * @throws SQLException 
     */
    public ArrayList<Alumno> obtenerTodos(Connection conexion) throws SQLException{
        ArrayList<Alumno> alumnos = new ArrayList();
        
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_ALUMNOS_RTODOS ();");
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            Alumno alumno = null;
            alumno = new Alumno(Integer.parseInt(resultado.getString("ID")),
                                                 resultado.getString("NOMBRE"),
                                                 resultado.getString("PAPELLIDO"),
                                                 resultado.getString("SAPELLIDO"),
                                                 resultado.getString("TELEFONO"),
                                                 resultado.getString("DNI"),
                                Integer.parseInt(resultado.getString("IDUSUARIO")));
            alumnos.add(alumno);
        }
        return alumnos;
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para eliminar un registro con todos los atributos de un Alumno en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD.
     * @throws SQLException 
     */
    public void eliminar(Connection conexion, int id) throws SQLException{
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("CALL USP_ALUMNOS_D (?);");
        consulta.setInt(1, id);
        consulta.executeUpdate();
    }
}
