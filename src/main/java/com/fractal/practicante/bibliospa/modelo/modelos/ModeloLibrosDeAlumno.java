package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.LibroDeAlumno;
import com.fractal.practicante.bibliospa.modelo.operaciones.OperacionInsertar;
import com.fractal.practicante.bibliospa.modelo.operaciones.OperacionObtener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloLibrosDeAlumno implements OperacionObtener<LibroDeAlumno>, OperacionInsertar<LibroDeAlumno> {

    /**
     * Método que al recibir una conexión y un objeto LibroDeAlumno, manda a
     * llamar al procedimiento adecuado de la BD para insertar un nuevo
     * LibroDeAlumno en la tabla de la BD.
     *
     * @param conexion      Conexión a la base de datos que se utilizará.
     * @param libroDeAlumno Objeto LibroDeAlumno con todos sus atributos con
     *                      información para poder insertar uno nuevo en la BD 
     *                      con ella.
     * @return              Regresa false de no haberse completado y true de sí 
     *                      haberse realizado.
     */
    @Override
    public boolean insertar(Connection conexion, LibroDeAlumno libroDeAlumno) {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(
                "CALL USP_LIBROSDEALUMNO_C (?, ?);"
            );
            consulta.setInt(1, libroDeAlumno.getIdAlumno());
            consulta.setInt(2, libroDeAlumno.getIdLibro());
            consulta.executeUpdate();
            return true;
        } catch (SQLException error) {
            return false;
        }

    }

    /**
     * Método que al recibir una conexión y un entero, manda a llamar al
     * procedimiento adecuado de la BD para regresar un objeto con todos los
     * atributos de un LibroDeAlumno en particular.
     *
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param id        Entero que se usará en la búsqueda de un LibroDeAlumno 
     *                  por su ID en la BD.
     * @return          LibroDeAlumno cuyo ID es el solicitado y con todos sus 
     *                  atributos con su respectiva información.
     * @throws SQLException
     */
    @Override
    public LibroDeAlumno obtener(Connection conexion, int id) 
            throws SQLException {
        LibroDeAlumno libroDeAlumno = null;
        PreparedStatement consulta = conexion.prepareStatement(
            "CALL USP_LIBROSDEALUMNO_R (?);"
        );
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            libroDeAlumno = new LibroDeAlumno(
                Integer.parseInt(resultado.getString("ID")),
                Integer.parseInt(resultado.getString("IDALUMNO")),
                Integer.parseInt(resultado.getString("IDLIBRO"))
            );
        }
        return libroDeAlumno;
    }

    /**
     * Método que al recibir una conexión y un entero, manda a llamar al
     * procedimiento adecuado de la BD para eliminar un registro con todos los
     * atributos de un LibroDeAlumno en particular.
     *
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param id        Entero que se usará en la búsqueda de un Alumno por su 
     *                  ID en la BD.
     * @return          Regresa false de no haberse completado y true de sí 
     *                  haberse realizado.
     * @throws SQLException
     */
    public boolean eliminar(Connection conexion, int id) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(
                "CALL USP_LIBROSDEALUMNO_D (?);"
            );
            consulta.setInt(1, id);
            consulta.executeUpdate();
            return true;
        } catch (SQLException error) {
            return false;
        }
    }
}
