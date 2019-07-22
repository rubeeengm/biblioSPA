package com.fractal.practicante.bibliospa.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion = null;

    public Connection conectar() {
        if (conexion == null) {
            try {
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
    
    public Connection getConexion() {
        return conexion;
    }
}