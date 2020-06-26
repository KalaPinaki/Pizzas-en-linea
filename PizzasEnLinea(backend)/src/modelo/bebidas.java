package modelo;

import java.io.Serializable;


public class bebidas implements Serializable {
    private String nombre;
    private double precio;

    public bebidas() {
    }

    public bebidas(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{\"nombre\":\"" + nombre + "\",\"precio\":" + precio + "}";
    }    
}
