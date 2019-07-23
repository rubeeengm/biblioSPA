package com.fractal.practicante.bibliospa.modelo.validaciones;
/* Se importa la clase Alumno de la carpeta modelo/beans */
import com.fractal.practicante.bibliospa.modelo.beans.Alumno;

/**
 * Clase ValidacionAlumno.java, se encargara de validar que los atributos de la
 * clase Alumno sean correctos, si es asi devuelve un booleano true. Se le tiene
 * que especificar que tipo de dato manejará la clase Validación, en este caso 
 * es Alumno.
 * @author Jorge Hernandez
 */
public class ValidacionAlumno extends Validacion<Alumno>{
    /** Constante que contiene el regex para el nombre.*/
    private final String REGEX_NOMBRE = "^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]+[\\s]*)+$";
    
    /** Constante que contiene el regex para el apellido paterno.*/
    private final String REGEX_APELLIDOPAT = "^([A-ZÁÉÍÓÚ][a-zñáéíóú]+)+$";
    
    /** Constante que contiene el regex para el apellido materno.*/
    private final String REGEX_APELLIDOMAT = "^([A-ZÁÉÍÓÚ][a-zñáéíóú]+)+$";
    
    /** Constante que contiene el regex para el telefono.*/
    private final String REGEX_TELEFONO = "[0-9]{10}";
    
    /** Constante que contiene el regex para el dni.*/
    private final String REGEX_DNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
    
    /**
     * Metodo reescrito heredado por Validacion, valida que los atributos del
     * alumno no sean nulos.
     * @param alumno    Objeto al que se le validarán sus atributos
     * @return          Devuelve un booleano que indica si todos los atributos 
     *                  cumplieron con la condición de no ser nulos.
     */
    @Override
    public boolean validarNulos(Alumno alumno) {
        String nombre = alumno.getNombre();
        String apellidoPaterno = alumno.getApellidoPaterno();
        String apellidoMaterno = alumno.getApellidoMaterno();
        String telefono = alumno.getTelefono();
        String dni = alumno.getDni();
        
        if(nombre == null || apellidoPaterno == null || apellidoMaterno == null
                || telefono == null || dni == null){
            
            System.out.println("Datos nulos");
            return false;
        } else{
            return true;
        }  
    }
    
    /**
     * Metodo reescrito heredado por Validacion, corrobora que todos los 
     * atributos hayan sido validados con exito, regresa un booleano que lo 
     * confirma.
     * @param alumno    Objeto que será evaluado.
     * @return          Devuelve un booleano que indica que todos los atributos 
     *                  fueron validados exitosamente.
     */
    @Override
    public boolean validacionTotal(Alumno alumno) {
        if(validarNulos(alumno)){
            if(validarExpresion(REGEX_NOMBRE, 
                    alumno.getNombre())){
                if(validarExpresion(REGEX_APELLIDOPAT, 
                        alumno.getApellidoPaterno())){
                    if(validarExpresion(REGEX_APELLIDOMAT, 
                            alumno.getApellidoMaterno())){
                        if(validarExpresion(REGEX_TELEFONO, 
                                alumno.getTelefono())){
                            if(validarExpresion(REGEX_DNI, 
                                    alumno.getDni())){
                                System.out.println("Alumno validado con éxito");
                                return true;
                            } else{
                                System.out.println("Error en el dni");
                                return false;
                            }
                        } else {
                            System.out.println("Error en el telefono");
                            return false;
                        }
                    } else {
                        System.out.println("Error en el AM");
                        return false;
                    }
                } else {
                    System.out.println("Error en el AP");
                    return false;
                }
            } else {
                System.out.println("Error en el Nombre");
                return false;
            }
        } else {
            System.out.println("Valores nulos");
            return false;
        }
    }
}