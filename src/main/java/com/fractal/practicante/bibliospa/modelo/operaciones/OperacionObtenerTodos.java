package com.fractal.practicante.bibliospa.modelo.operaciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OperacionObtenerTodos<O> {

    public ArrayList<O> obtenerTodos(Connection conexion) throws SQLException;
}
