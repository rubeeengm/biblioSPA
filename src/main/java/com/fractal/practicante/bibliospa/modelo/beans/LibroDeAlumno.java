package com.fractal.practicante.bibliospa.modelo.beans;

/**
 * Clase LibroDeAlumno.java, representa la vinculación que hay entre el alumno 
 * y sus libros.
 * @author Jorge Hernandez
 */
public class LibroDeAlumno {

    /** 
     * Atributo id: entero que representa a la vinculacion del libro y el 
     * alumno 
     */
    private int id;
    
    /** Atributo idUsuario: entero que representa al usuario dueño del libro */
    private int idUsuario;
    
    /** Atributo idLibro: entero que representa al libro del dueño */
    private int idLibro;
    
    /**
     * Constructor básico de LibroDeAlumno
     */
    public LibroDeAlumno() {
    }
    
    /**
     * Constructor de LibroDeAlumno que usa los atributos idUsuario e idLibro
     * @param idUsuario     ID del usuario
     * @param idLibro       ID del libro
     */
    public LibroDeAlumno(int idUsuario, int idLibro) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }
    
    /**
     * Constructor de LibroDeAlumno que usa los atributos id, idUsuario 
     * e idLibro
     * @param id            ID de la vinculación
     * @param idUsuario     ID del usuario
     * @param idLibro       ID del libro
     */
    public LibroDeAlumno(int id, int idUsuario, int idLibro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }    

    /**
     * Metodo obtener para el id
     * @return ID de la vinculación
     */
    public int getId() {
        return id;
    }
    
    /**
     * Metodo obtener del ID del usuario
     * @return ID del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Metodo obtener del ID del libro
     * @return ID del libro
     */
    public int getIdLibro() {
        return idLibro;
    }
}
