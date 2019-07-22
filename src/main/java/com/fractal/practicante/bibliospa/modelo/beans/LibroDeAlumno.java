package com.fractal.practicante.bibliospa.modelo.beans;

public class LibroDeAlumno {

    private int id;
    private int idUsuario;
    private int idLibro;

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public LibroDeAlumno(int idUsuario, int idLibro) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }
    
    public LibroDeAlumno(int id, int idUsuario, int idLibro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }
    
    public LibroDeAlumno() {
    }
}
