package com.fractal.practicante.bibliospa.modelo.validaciones;
/* Se importa la clase Usuario de la carpeta modelo/beans */
import com.fractal.practicante.bibliospa.modelo.beans.Usuario;

/**
 * Clase ValidacionUsuario.java, esta clase se encarga de validar los atributos
 * de un usuario, hay que especificar el tipo de dato que usara la clase 
 * heredada Validacion, en este caso es un tipo Usuario, la clase devuelve un
 * booleano para corroborar que se hicieron las validaciones.
 * @author Jorge Hernandez
 */
public class ValidacionUsuario extends Validacion<Usuario>{
    
    /** Constante tipo string que contiene el regex para el nombre de usuario.*/
    private final String REGEX_NOMBREUSUARIO = 
            "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";
    
    /** Constante tipo string que contiene el regex para la contraseña.*/
    private final String REGEX_CONTRASENIA = 
            "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
    
    /**
     * Metodo reescrito heredado de la clase Validacion, comprueba que los
     * atributos no sean nulos.
     * @param usuario   Objeto al que se le validaran sus atributos.
     * @return          Booleano que confirma si los atributos son nulos o no.
     */
    @Override
    public boolean validarNulos(Usuario usuario) {
        if(usuario.getNombreUsuario() == null || usuario.getContrasenia() == null){
            System.out.println("Datos nulos");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Clase reescrita heredada de la clase Validacion, confirma que todos los 
     * atributos fueron validados con éxito.
     * @param usuario   Objeto al que se le validaran sus atributos.
     * @return          Booleano que confirma que todos los atributos fueron 
     *                  validados con éxito.
     */
    @Override
    public boolean validacionTotal(Usuario usuario) {
        if(validarNulos(usuario)){
            if(validarExpresion(REGEX_NOMBREUSUARIO, usuario.getNombreUsuario())){
                if(validarExpresion(REGEX_CONTRASENIA, usuario.getContrasenia())){
                    System.out.println("Usuario validado con éxito");
                    return true;
                } else {
                    System.out.println("Error en la contraeña");
                    return false;
                }
            } else {
                System.out.println("Error en el nombre de ususario");
                return false;
            }
        } else{
            System.out.println("Datos nulos");
            return false;
        }
    }
}