package com.fractal.practicante.bibliospa.modelo.operaciones;

import java.sql.Connection;
import java.sql.SQLException;

public interface OperacionObtener<O> {

    public O obtener(Connection conexion, int id) throws SQLException;
}
