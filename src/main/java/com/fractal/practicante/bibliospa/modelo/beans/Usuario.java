package com.fractal.practicante.bibliospa.modelo.beans;
public class Usuario {
    private int id;
    private String usuario;
    private String contrasenia;
    private char admin;

    public int getId() {
        return id;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public char getAdmin(){
        return admin;
    }
    
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public Usuario(int id, String usuario, String contrasenia, char admin) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.admin = admin;
    }
    
    public Usuario() {
    }
}
