package com.fractal.practicante.bibliospa.modelo.validaciones;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;

/**
 * Clase que contiene las validaciones de los atributos de Libro
 *
 * @author Rubén Gustavo García Málaga
 */
public class ValidacionLibro extends Validacion<Libro> {
    /**
     * Valida que contenga un nombre común corrcto
     */
    private final String REGEX_AUTOR
        = "^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]{1,24}[\\s]*)+$";
    
    /**
     * Combinación de espacios, números o caracteres
     */
    private final String REGEX_TITULO
        = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";
    
    /**
     * Que no comience con cero o que sean puros 0
     */
    private final String REGEX_NUM_PAGINAS
        = "^[1-9]\\d*$";
    
    /**
     * Analiza que el ISBN sea correcto
     */
    private final String REGEX_ISBN
        = "^[1-9]\\d{12}$";

    /**
     * Metodo que verifica si los atributos de un libro son nulos
     *
     * @param objeto objeto al que se le analizan los atributos.
     * @return devuelve true si el objeto no contiene atributos nulos
     */
    @Override
    public boolean validarNulos(Libro objeto) {
        String titulo = objeto.getTitulo();
        String autor = objeto.getAutor();
        int numPaginas = objeto.getNumPaginas();
        String isbn = objeto.getIsbn();

        if (numPaginas < 1) {
            System.out.println("Número de páginas inválido");

            return false;
        } else if (titulo == null || autor == null || isbn == null) {
            System.out.println("Valor nulo");

            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Metodo que verifica si los atributos de un libro estan vacios.
     *
     * @param objeto    Objeto al que se le analizan los atributos.
     * @return devuelve True si el objeto no contiene atributos nulos.
     */
    @Override
    public boolean validarVacios(Libro objeto) {
        String titulo = objeto.getTitulo();
        String autor = objeto.getAutor();
        int numPaginas = objeto.getNumPaginas();
        String isbn = objeto.getIsbn();

        if (numPaginas < 1) {
            System.out.println("Número de páginas inválido");

            return false;
        } else if (titulo.equals("") || autor.equals("") || isbn.equals("")) {
            System.out.println("Valor nulo");

            return false;
        } else {
            return true;
        }
    }

    /**
     * Verifica el tamaño del isbn, que debe tener 13 o 10 dígitos
     *
     * @param isbn
     * @return devuelve true si el tamaño es correcto
     */
    public boolean validarTamanioIsbn(String isbn) {
        if (isbn.length() == 13 || isbn.length() == 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica que los atributos del objeto sean correctos
     * 
     * @param objeto objeto a analizar
     * @return devuelve true si el objeto tiene datos correctos
     */
    @Override
    public boolean validacionTotal(Libro objeto) {
        String titulo = objeto.getTitulo();
        String autor = objeto.getAutor();
        int numPaginas = objeto.getNumPaginas();
        String isbn = objeto.getIsbn();
        
        if(!validarNulos(objeto)){
            System.out.println("Datos nulos");
            return false;
        } else if(!validarVacios(objeto)){
            System.out.println("Datos vacios");
            return false;
        } else if(!validarExpresion(REGEX_TITULO, titulo)){
            System.out.println("Titulo erroneo");
            return false;
        } else if(!validarExpresion(REGEX_AUTOR, autor)){
            System.out.println("Autor erroneo");
            return false;
        } else if(!validarExpresion(REGEX_NUM_PAGINAS, numPaginas)){
            System.out.println("Numero de paginas erroneo");
            return false;
        } else if(!validarExpresion(REGEX_ISBN, isbn)){
            System.out.println("ISBN erroneo");
            return false;
        } else if(!validarTamanioIsbn(isbn)){
            System.out.println("Tamaño del isbn erroneo");
            return false;
        } else { 
            System.out.println("Datos correctos");
            return true;
        }
    }
    
}