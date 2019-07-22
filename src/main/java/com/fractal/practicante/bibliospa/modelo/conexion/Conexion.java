package com.fractal.practicante.bibliospa.modelo.conexion;
import java.sql.*;
public class Conexion {
    private Connection conexion = null;
    
    public Connection conectar() throws SQLException, ClassNotFoundException {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PRESTAMO_LIBROS?serverTimezone=UTC", "ruben", "hola");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return conexion;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void desconectar() throws SQLException {
      if (conexion != null) {
         conexion.close();
      }
    }
}
