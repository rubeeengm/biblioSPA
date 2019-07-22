package com.fractal.practicante.bibliospa.modelo.validaciones;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que contiene las validaciones de los atributos de Libro
 * 
 * @author Rubén Gustavo García Málaga
 */
public class ValidacionLibro {

    public boolean validarLibroNull(Libro objeto) {
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
    
    public boolean validarAutor(String autor) {
        String expresionRegular = "^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]{1,24}[\\s]*)+$";
        
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(autor);
        
        return matcher.matches();
    }
    
    public boolean validarTitulo(String titulo) {
        String expresionRegular = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";
        
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(titulo);
        
        return matcher.matches();
    }

    public boolean validarIsbn(String isbn) {
        String expresionRegular = "^((?:-1[03])?:? )?(?=[0-9X]{10}$|"
            + "(?=(?:[0-9]+[- ]){3})"
            + "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})"
            + "[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]"
            + "+[- ]?[0-9X]$";

        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(isbn);

        return matcher.matches();
    }

    public boolean validarTamanioIsbn(String isbn) {
        if (isbn.length() == 13 || isbn.length() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidacionLibro vl = new ValidacionLibro();

        Libro objeto = new Libro();
        objeto.setNumPaginas(0);
        objeto.setTitulo("HOLA");
        objeto.setAutor("dasdsa");
        objeto.setIsbn("adsa");

        System.out.println(vl.validarLibroNull(objeto));
        System.out.println(vl.validarTamanioIsbn("978-0-596-52068-7"));
        System.out.println(vl.validarTamanioIsbn("978-3-16-148410-0"));
        System.out.println(vl.validarTamanioIsbn("9780596520687"));
        System.out.println(vl.validarTamanioIsbn("978-3-16-148410-0"));
        System.out.println(vl.validarTamanioIsbn("9783161484100"));
    }
}
