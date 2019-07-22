package com.fractal.practicante.bibliospa.modelo.modelos;

import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloUsuarios {
    /**
     * Método que al recibir una conexión y un objeto Usuario, manda a llamar al procedimiento adecuado de la BD para insertar un nuevo Usuario en la tabla de la BD.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param usuario Objeto Usuario con todos sus atributos con información para poder insertar uno nuevo en la BD con ella.
     * @throws SQLException 
     */
    public void insertar(Connection conexion, Usuario usuario) throws SQLException {
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("CALL USP_USUARIOS_C (?, ?);");
        consulta.setString(1, usuario.getUsuario());
        consulta.setString(2, usuario.getContrasenia());
        consulta.executeUpdate();
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para regresar un objeto con todos los atributos de un Usuario en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Usuario por su ID en la BD. 
     * @return Usuario cuyo ID es el solicitado y con todos sus atributos con su respectiva información.
     * @throws SQLException 
     */
    public Usuario obtener(Connection conexion, int id) throws SQLException{
        Usuario usuario = null;
        PreparedStatement consulta = conexion.prepareStatement("CALL USP_USUARIOS_R (?);");
        consulta.setInt(1, id);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            usuario = new Usuario(Integer.parseInt(resultado.getString("ID")),
                                                   resultado.getString("USUARIO"),
                                                   resultado.getString("CONTRASENIA"),
                                                   resultado.getString("ADMIN").charAt(0));
        }
        return usuario;
    }
    
    /**
     * Método que al recibir una conexión y un entero, manda a llamar al procedimiento adecuado de la BD para eliminar un registro con todos los atributos de un Usuario en particular.
     * @param conexion Conexión a la base de datos que se utilizará.
     * @param id Entero que se usará en la búsqueda de un Alumno por su ID en la BD.
     * @throws SQLException 
     */
    public void eliminar(Connection conexion, int id) throws SQLException{
        PreparedStatement consulta;
        consulta = conexion.prepareStatement("CALL USP_USUARIOS_D (?);");
        consulta.setInt(1, id);
        consulta.executeUpdate();
    }
    
    public Usuario verificarLogin(Connection conexion, String nickname, String contrasenia) throws SQLException{
        Usuario usuario = null;
        PreparedStatement consulta = conexion.prepareStatement("SELECT ID,"
                +                                              " USUARIO,"
                +                                              " CONTRASENIA,"
                +                                              " ADMIN"
                +                                              " FROM USUARIOS WHERE USUARIO = (?) AND CONTRASENIA = MD5((?)); ");
            consulta.setString(1, nickname);
            consulta.setString(2, contrasenia);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                usuario = new Usuario(Integer.parseInt(resultado.getString("ID")),
                                                   resultado.getString("USUARIO"),
                                                   resultado.getString("CONTRASENIA"),
                                                   resultado.getString("ADMIN").charAt(0));
            }
            return usuario;
    }
}