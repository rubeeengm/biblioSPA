package com.fractal.practicante.bibliospa.modelo.validaciones;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;

/**
 * Clase que contiene las validaciones de los atributos de Libro
 * 
 * @author Rubén Gustavo García Málaga
 */
public class ValidacionLibro{
    /**
     * 
     * @param objeto
     * @return 
     */
    public boolean validarNulo(Libro objeto) {
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
     * 
     * @param isbn
     * @return 
     */
    public boolean validarTamanioIsbn(String isbn) {
        if (isbn.length() == 13 || isbn.length() == 10) {
            return true;
        } else {
            return false;
        }
    }
}