package com.fractal.practicante.bibliospa.modelo.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase abstracta Validacion.java, esta clase es la plantilla para las 
 * validaciones que se haran en los formularios.
 * @author Jorge Hernandez
 * @param <T> Objeto cuyos atributos se van a validar.
 */
public abstract class Validacion<T> {
    
    /**
     * Metodo validarExpresion, regresa un booleano si la expresion regular y el 
     * atributo coinciden, el atributo tiene que ser de tipo String
     * @param regex     Expresion regular que evaluara al atributo.
     * @param atributo  Atributo que se evaluará, debe ser de tipo String.
     * @return          Booleano que indica si el atributo coincide con el regex.
     */
    public boolean validarExpresion(String regex, String atributo){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(atributo);
        return matcher.matches();
    }
    
    /**
     * Sobrecarga del metodo validarExpresion, regresa un booleano si la 
     * expresion regular y el atributo coinciden, el atributo tiene que ser de 
     * tipo entero.
     * @param regex     Expresion regular que evaluara al atributo.
     * @param atributo  Atributo que se evaluará, debe ser de tipo entero.
     * @return          Booleano que indica si el atributo coincide con el regex.
     */
    public boolean validarExpresion(String regex, int atributo){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Integer.toString(atributo));
        return matcher.matches();
    }
    
    /**
     * Metodo booleano que valida si los atributos están nulos o no, requiere
     * de un objeto para funcionar.
     * @param objeto    Objeto cuyos atributos serán evaluados.
     * @return          Booleano que indica si todos los atributos están nulos 
     *                  o no. 
     */
    public abstract boolean validarNulos(T objeto);
    
    /**
     * Método booleano que valida que todos los atributos hayan pasado con éxito
     * las validaciones indicadas.
     * @param objeto    Objeto que será evaluado.
     * @return          Booleano que indica que todas las validaciones 
     *                  fueron exitosas.
     */
    public abstract boolean validacionTotal(T objeto);
    
}
