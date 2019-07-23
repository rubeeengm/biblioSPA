package com.fractal.practicante.bibliospa.modelo.beans;

/**
 * Clase que contiene todos los datos del usuario
 * 
 * @author Rubén Gustavo García Málaga
 */
public class Usuario {
    /** id del usuario */     
    private int id;
    
    /** usuario */
    private String nombreUsuario;
    
    /** contraseña del usuario */
    private String contrasenia;
    
    /** atributo que indica si el usuario es o no administrador */
    private char admin;
    
    /**
     * Constructor vacío
     */
    public Usuario() {
    }
    
    /**
     * 
     * @param usuario usuario
     * @param contrasenia contraseña del usuario
     */
    public Usuario(String usuario, String contrasenia) {
        this.nombreUsuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    /**
     * 
     * @param id id del usurio
     * @param usuario usuario
     * @param contrasenia contraseña del usuario
     * @param admin rol de admin
     */
    public Usuario(int id, String usuario, String contrasenia, char admin) {
        this.id = id;
        this.nombreUsuario = usuario;
        this.contrasenia = contrasenia;
        this.admin = admin;
    }
    
    /**
     * Recupera el 
     * @return recupera el id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el id
     * @param id id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera el usuario
     * @return recupera el usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Cambia el usuario
     * @param nombreUsuario usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Recupera la contraseña del usuario
     * @return Recupera la contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Cambia la contraseña del usuario
     * @param contrasenia contraseña del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    /**
     * recupera el estado del administrador
     * @return recupera el estado del administrador del usuario
     */
    public char getAdmin() {
        return admin;
    }

    /**
     * Cambia el estado del admin
     * @param admin estado del admin
     */
    public void setAdmin(char admin) {
        this.admin = admin;
    }
}