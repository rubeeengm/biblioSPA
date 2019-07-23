package com.fractal.practicante.bibliospa.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    /** objeto para interactuar con la base de datos */
    private Connection conexion = null;
    
    /**
     * Obtiene el objeto que interactua con la base de datos
     * 
     * @return objeto que interactua con la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método que permite crear un objeto para interactuar con la base de datos
     * 
     * @return regresa el objeto que permite la conexion con la base de datos
     */
    public Connection conectar() {
        if (conexion == null) {
            try {
                //Driver de base de datos que se desea cargar
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/PRESTAMO_LIBROS?"
                    + "serverTimezone=UTC",
                    "ruben", //usuario del servidor
                    "hola" //contraseña del servidor
                );
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(
                    Conexion.class.getName()).log(Level.SEVERE, null, ex
                );
            } catch (SQLException ex) {
                Logger.getLogger(
                    Conexion.class.getName()).log(Level.SEVERE, null, ex
                );
            }
        }
        
        return conexion;
    }
    
    /**
     * Cierra la conexión con la base de datos
     */
    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(
                    Conexion.class.getName()).log(Level.SEVERE, null, ex
                );
            }
        }
    }
}