package modelo;
/*
    Pizzas.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
import java.io.Serializable;
import java.util.ArrayList;

public class Pizza implements Serializable{
    private String nombre;
    private double precio; //fijo
    private ArrayList<String> ingredientes;

    public Pizza() {
        this(null,0.0, null);
    }

    public Pizza(String nombre, double precio, ArrayList<String> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "{\"nombre\":" + nombre + ",\"precio\":" + precio + ",\"ingredientes\":" + ingredientes.toString() + "}\n";
    }
    

    
    
}
