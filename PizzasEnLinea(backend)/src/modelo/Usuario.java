package modelo;

/*
    Usuario.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String contraseña;
    private String telefono;
    private boolean rol;

    public Usuario() {
        this.nombre = "";
        this.apellidos = "";
        this.cedula = "";
        this.direccion = "";
        this.contraseña = "";
        this.telefono = "";
        this.rol = false;
    }

    public Usuario(String nombre, String apellidos, String cedula, String direccion, String contraseña, String telefono, boolean rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.rol = rol;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isRol() {
        return rol;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "{\"nombre\":\"" + nombre + "\",\"apellidos\":\"" + apellidos + "\",\"cedula\":\"" + cedula + "\",\"direccion\":\"" + direccion + "\",\"contraseña\":\"" + contraseña + "\",\"telefono\":\"" + telefono + "\",\"rol\":" + rol + '}';
    }    
}
