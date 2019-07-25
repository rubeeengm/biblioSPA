package com.fractal.practicante.bibliospa.modelo.beans;

/**
 * Clase Libro.java, representa un libro con sus atributos básicos, contiene 3 
 * constructores para su uso.
 * @author Jorge Hernandez
 */
public class Libro {

    /** Atributo id: entero que identifica al libro */
    private int id;
    
    /** Atributo titulo: string que especifia el titulo del libro */
    private String titulo;
    
    /** Atributo autor: string que especifica el autor del libro */
    private String autor;
    
    /** 
     * Atributo numPaginas: entero que especifica la cantidad de páginas de un
     * libro 
     */
    private int numPaginas;
    
    /** Atributo estado: caracter que especifica el estado del libro */
    private char estado;
    
    /** Atributo isbn: string que identifica el ISBN del libro */
    private String isbn;
    
    /**
     * Constructor básico del libro
     */
    public Libro() {
    }
    
    /**
     * Constructor de Libro que usa los atributos titulo, autor, numPaginas e 
     * isbn
     * @param titulo        Titulo del libro
     * @param autor         Nombre del autor del libro
     * @param numPaginas    Cantidad de páginas del libro
     * @param isbn          ISBN del libro
     */
    public Libro(String titulo, String autor, int numPaginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
    }

    /**
     * Constructor de Libro que usa los atributos id, titulos, autor, 
     * numPaginas, estado e isbn
     * @param id            Id del libro
     * @param titulo        Titulo del libro
     * @param autor         Nombre del autor del libro
     * @param numPaginas    Cantidad de páginas del libro
     * @param estado        Estado del libro
     * @param isbn          ISBN del libro
     */
    public Libro(int id, String titulo, String autor, int numPaginas, 
            char estado, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.estado = estado;
        this.isbn = isbn;
    }    
    
    /**
     * Metodo obtener para el ID
     * @return ID del libro
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo obtener para el titulo
     * @return Titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo establecer para el titulo
     * @param titulo Titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo obtener para el autor
     * @return Autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Metodo establecer para el autor
     * @param autor Autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Metodo obtener para el numero de páginas
     * @return Numero de páginas
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * Metodo establecer para el numero de páginas
     * @param numPaginas Numero de páginas
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * Metodo obtener para el estado
     * @return Estado del libro
     */
    public char getEstado() {
        return estado;
    }

    /**
     * Metodo establecer para el estado
     * @param estado Estado del libro
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * Metodo obtener del isbn
     * @return ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Metodo establecer para el ISBN
     * @param isbn ISBN del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
