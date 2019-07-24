package com.fractal.practicante.bibliospa.modelo.beans;

/**
 * Clase que contiene los datos del Alumno
 * 
 * @author Rubén Gustavo García Málaga
 */
public class Alumno {
    /** id del alumno */
    private int id;
    
    /** nombre del alumno */
    private String nombre;
    
    /** Apellido paterno del alumno */
    private String apellidoPaterno;
    
    /** Apellido materno del alumno */
    private String apellidoMaterno;
    
    /** Número teléfonico del alumno */
    private String telefono;
    
    /** Documento nacional de identidad */
    private String dni;
    
    /** identificador del usuario */
    private int idUsuario;
    
    /**
     * Constructor vacío
     */
    public Alumno() {}
    
    /**
     * 
     * @param nombre            Nombre del alumno
     * @param apellidoPaterno   Apellido paterno del alumno
     * @param apellidoMaterno   Apellido materno del alumno
     * @param telefono          Número teléfonico del alumno
     * @param dni               Documento nacional de identidad
     */
    public Alumno(String nombre, String apellidoPaterno, 
                  String apellidoMaterno, String telefono, 
                  String dni) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.dni = dni;
    }
    
    /**
     * 
     * @param nombre            Nombre del alumno
     * @param apellidoPaterno   Apellido paterno del alumno
     * @param apellidoMaterno   Apellido materno del alumno
     * @param telefono          Número teléfonico del alumno
     * @param dni               Documento nacional de identidad
     * @param idUsuario         Identificador del usuario
     */
    public Alumno(String nombre, String apellidoPaterno, 
                  String apellidoMaterno, String telefono, 
                  String dni, int idUsuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.dni = dni;
        this.idUsuario = idUsuario;
    }
    
    /**
     * 
     * @param id                Id del alumno
     * @param nombre            Nombre del alumno
     * @param apellidoPaterno   Apellido paterno del alumno
     * @param apellidoMaterno   Apellido materno del alumno
     * @param telefono          Número telefónico del alumno
     * @param dni               Documento nacional de identidad
     * @param idUsuario         Identificador del usuario
     */
    public Alumno(int id, String nombre, String apellidoPaterno, 
                  String apellidoMaterno, String telefono, String dni, 
                  int idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.dni = dni;
        this.idUsuario = idUsuario;
    }
    
    /**
     * Recupera el valor del id
     * @return Recupera el id del alumno
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el valor del id
     * @param id id del alumno
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Recupera el nombre
     * @return Recupera el nombre de alumno
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Cambia el valor del nombre
     * @param nombre nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *  Recupera el valor del nombre
     * @return Recupera el nombre del alumno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    /**
     * Cambia el apellido paterno
     * @param apellidoPaterno apellido paterno de alumno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    /**
     * Recupera el apellido paterno
     * @return Recupera el apellido paterno del alumno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    /**
     * Cambia el apellido materno
     * @param apellidoMaterno apellido materno del alumno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Recupera el número telefónico
     * @return Recupera el número telefónico del alumno
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el número telefónico
     * @param telefono número telefónico del alumno
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Recupera el DNI
     * @return Recupera el DNI del alumno
     */
    public String getDni() {
        return dni;
    }

    /**
     * Cambia el DNI
     * @param dni DNI del alumno
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Recupera el id del usuario
     * @return Recupera el id del usuario del alumno
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Cambia el id del usuario
     * @param idUsuario id del usuario del alumno
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}