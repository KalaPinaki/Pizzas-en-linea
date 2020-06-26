package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class orden implements Serializable {

    private String cedula;
    private String nombreCompleto;
    private int numOrden;
    private ArrayList<Pizza> pizzas;
    private ArrayList<String> extras;
    private Date fecha;
    private int estado;
    private String metodo_pago;
    private double precio;

    public orden() {
        this.cedula = "";
        this.nombreCompleto = "";
        this.numOrden = 0;
        this.pizzas = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.fecha = null;
        this.estado = 0;
        this.metodo_pago = "";
        this.precio = 0.0;
    }

    public orden(String cedula, String nombreCompleto, int numOrden, ArrayList<Pizza> pizzas, ArrayList<String> extras, Date fecha, int estado, String metodo_pago, double precio) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.numOrden = numOrden;
        this.pizzas = pizzas;
        this.extras = extras;
        this.fecha = fecha;
        this.estado = estado;
        this.metodo_pago = metodo_pago;
        this.precio = precio;
    }

    public orden(String Pcedula, String PnombreCompleto, int numOrden, List<Pizza> pizzas, List<String> extras, String Pfecha, String Pestado, String Pmetodo_pago, double precio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCedula() {
        return cedula;
    }

    public int getEstado() {
        return estado;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getNumOrden() {
        return numOrden;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setExtras(ArrayList<String> extras) {
        this.extras = extras;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{\"cedula\":\"" + cedula + "\",\"nombreCompleto\":\"" + nombreCompleto + "\",\"numOrden\":" + numOrden + ",\"pizzas\":" + pizzas.toString() + ",\"extras\":" + extras.toString() + ",\"fecha\":\"" + fecha + "\",\"estado\":" + estado + ",\"metodo_pago\":\"" + metodo_pago + "\",\"precio\":" + precio + "}";
    }
}
