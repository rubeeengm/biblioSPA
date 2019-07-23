package com.fractal.practicante.bibliospa.modelo.validaciones;

import com.fractal.practicante.bibliospa.modelo.beans.LibroDeAlumno;

/**
 * Clase que contiene las validaciones del objeto LibroAlumno
 * 
 * @author Rubén Gustavo García Málaga
 */
public class ValidacionLibroAlumno {
    /**
     * Verificamos que el idUsuario y idLibro sean positivos
     * 
     * @param objeto LibroDeAlumno al que se le evaluan los atributos
     * @return devuelve true si sus datos son correctos
     */
    public boolean validarLibroAlumno(LibroDeAlumno objeto) {
        int idUsuario = objeto.getId();
        int idLibro = objeto.getIdLibro();
        
        if (idUsuario < 1) {
            System.out.println("id usuario negativo");

            return false;
        } else if (idLibro < 1) {
            System.out.println("id libro negativo");

            return false;
        } else {
            System.out.println("id's correctos");

            return true;
        }
    }
}
