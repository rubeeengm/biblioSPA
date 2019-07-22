package com.fractal.practicante.bibliospa.modelo.beans;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;
    private char estado;
    private String isbn;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Libro(String titulo, String autor, int numPaginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
    }

    public Libro(int id, String titulo, String autor, int numPaginas, char estado, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.estado = estado;
        this.isbn = isbn;
    }

    public Libro() {
    }
}
