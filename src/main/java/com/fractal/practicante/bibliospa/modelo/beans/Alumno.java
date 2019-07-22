package com.fractal.practicante.bibliospa.modelo.beans;

public class Alumno {

    private int id;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String telefono;
    private String dni;
    private int idUsuario;
    
    public Alumno() {
    }
    
    public Alumno(String nombre, String pApellido, String sApellido, 
                  String telefono, String dni, int idUsuario) {
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.telefono = telefono;
        this.dni = dni;
        this.idUsuario = idUsuario;
    }
    
    public Alumno(int id, String nombre, String pApellido, String sApellido, 
                  String telefono, String dni, int idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.telefono = telefono;
        this.dni = dni;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}