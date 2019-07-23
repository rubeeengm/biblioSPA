package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Alumno;
import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloTransacciones {

    /**
     * Método que al recibir una conexión y un objeto Alumno, manda a llamar al
     * procedimiento adecuado de la BD para insertar un nuevo Alumno en la tabla
     * de la BD.
     *
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param alumno Objeto Alumno con todos sus atributos con información para
     * poder insertar uno nuevo en la BD con ella.
     * @param usuario Objeto Usuario con todos sus atributos con información
     * para poder insertar uno nuevo en la BD con ella.
     * @return Regresa false de no haberse completado y true de sí haberse
     * realizado.
     */
    public boolean insertarAlumno(Connection conexion, Alumno alumno, Usuario usuario) {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("CALL USP_ALUMNOSUSUARIOS_C (?, ?, ?, ?, ?, ?, ?);");
            consulta.setString(1, alumno.getNombre());
            consulta.setString(2, alumno.getApellidoPaterno());
            consulta.setString(3, alumno.getApellidoMaterno());
            consulta.setString(4, alumno.getTelefono());
            consulta.setString(5, alumno.getDni());
            consulta.setString(6, usuario.getNombreUsuario());
            consulta.setString(7, usuario.getContrasenia());
            consulta.executeUpdate();
            return true;
        } catch (SQLException error) {
            return false;
        }
    }
}
