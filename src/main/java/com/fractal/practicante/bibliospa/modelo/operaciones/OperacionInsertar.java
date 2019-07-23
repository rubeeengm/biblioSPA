package com.fractal.practicante.bibliospa.modelo.operaciones;

import java.sql.Connection;
import java.sql.SQLException;

public interface OperacionInsertar<O> {

    public boolean insertar(Connection conexion, O object)  throws SQLException;
}
