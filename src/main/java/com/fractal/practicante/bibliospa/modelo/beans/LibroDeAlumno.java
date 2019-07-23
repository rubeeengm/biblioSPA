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
    
    /** Atributo idAlumno: entero que representa al usuario dueño del libro */
    private int idAlumno;
    
    /** Atributo idLibro: entero que representa al libro del dueño */
    private int idLibro;
    
    /**
     * Constructor básico de LibroDeAlumno
     */
    public LibroDeAlumno() {
    }
    
    /**
     * Constructor de LibroDeAlumno que usa los atributos idUsuario e idLibro
     * @param idAlumno     ID del Alumno
     * @param idLibro       ID del libro
     */
    public LibroDeAlumno(int idAlumno, int idLibro) {
        this.idAlumno = idAlumno;
        this.idLibro = idLibro;
    }
    
    /**
     * Constructor de LibroDeAlumno que usa los atributos id, idAlumno 
     * e idLibro
     * @param id            ID de la vinculación
     * @param idAlumno     ID del alumno
     * @param idLibro       ID del libro
     */
    public LibroDeAlumno(int id, int idAlumno, int idLibro) {
        this.id = id;
        this.idAlumno = idAlumno;
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
    public int getIdAlumno() {
        return idAlumno;
    }

    /**
     * Metodo obtener del ID del libro
     * @return ID del libro
     */
    public int getIdLibro() {
        return idLibro;
    }
}
