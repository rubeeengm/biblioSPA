package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Alumno;
import com.fractal.practicante.bibliospa.modelo.operaciones.OperacionObtener;
import com.fractal.practicante.bibliospa.modelo.operaciones.OperacionObtenerTodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase que implenta las clases OperacionObtener y OperacionObtenerTodos, los 
 * metodos devuelven un objeto Alumno extraido de la BD.
 * @author Marco Lopez
 */
public class ModeloAlumnos implements OperacionObtener<Alumno>, 
        OperacionObtenerTodos<Alumno> {

    /**
     * Método que al recibir una conexión y un entero, manda a llamar al
     * procedimiento adecuado de la BD para regresar un objeto con todos los
     * atributos de un Alumno en particular.
     *
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param id        Entero que se usará en la búsqueda de un Alumno por su 
     *                  ID en la BD.
     * @return          Alumno cuyo ID es el solicitado y con todos sus 
     *                  atributos con su respectiva información.
     * @throws SQLException
     */
    @Override
    public Alumno obtener(Connection conexion, int id) throws SQLException {
        Alumno alumno = null;
        PreparedStatement consulta = conexion.prepareStatement(
                "CALL USP_ALUMNOS_R (?);"
        );
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
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
     * Método que al recibir una conexión, manda a llamar al procedimiento
     * adecuado de la BD para regresar un ArrayList con todos los Alumnos
     * registrados en la BD.
     *
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @return          ArrayList de objetos de tipo Alumno igual al número de 
     *                  Alumnos registrados en la BD con todos sus datos.
     * @throws SQLException
     */
    @Override
    public ArrayList<Alumno> obtenerTodos(Connection conexion) 
            throws SQLException {
        ArrayList<Alumno> alumnos = new ArrayList();

        PreparedStatement consulta = conexion.prepareStatement(
                "CALL USP_ALUMNOS_RTODOS ();"
        );
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
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
}
