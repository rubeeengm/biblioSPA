package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import com.fractal.practicante.bibliospa.modelo.operaciones.OperacionObtener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo que implementa la interfaz OperacionObtener, nos permite buscar en la 
 * BD los usuarios que solicitemos.
 * @author Marco Lopez
 */
public class ModeloUsuarios implements OperacionObtener<Usuario> {
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al
     * procedimiento adecuado de la BD para regresar un objeto con todos los
     * atributos de un Usuario en particular.
     *
     * @param conexion  Conexión a la base de datos que se utilizará.
     * @param id        Entero que se usará en la búsqueda de un Usuario por su 
     *                  ID en la BD.
     * @return          Usuario cuyo ID es el solicitado y con todos sus 
     *                  atributos con su respectiva información.
     * @throws SQLException
     */
    @Override
    public Usuario obtener(Connection conexion, int id) throws SQLException {
        Usuario usuario = null;
        PreparedStatement consulta = conexion.prepareStatement(
            "CALL USP_USUARIOS_R (?);"
        );
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            usuario = new Usuario(Integer.parseInt(
                resultado.getString("ID")),
                resultado.getString("USUARIO"),
                resultado.getString("CONTRASENIA"),
                resultado.getString("ADMIN").charAt(0)
            );
        }
        return usuario;
    }

    /**
     * Método que al recibir una conexión y objeto Usuario, manda a llamar al
     * procedimiento adecuado para comprobar la existencia de dicho Usuario, 
     * al finalizar regresa el objeto de dicho USuario.
     * @param conexion
     * @param usuario
     * @return
     * @throws SQLException
     */
    public Usuario verificarLogin(Connection conexion, Usuario usuario) 
            throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement(
                "CALL USP_USUARIOSLOGIN_R (?, ?); "
        );
        consulta.setString(1, usuario.getNombreUsuario());
        consulta.setString(2, usuario.getContrasenia());
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            usuario = new Usuario(
                resultado.getInt("ID"),
                resultado.getString("USUARIO"),
                "",
                resultado.getString("ADMIN").charAt(0));
        }
        return usuario;
    }
}
