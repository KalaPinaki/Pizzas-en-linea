/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.GestorPizzas;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Pizza;

/**
 *
 * @author leoba
 */
@WebService(serviceName = "ServicioPizza")
public class ServicioPizza {

// <editor-fold defaultstate="collapsed" desc="pizza">
    @WebMethod(operationName = "insertarPizza")
    public String insertarPizza(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "precio") String Pprecio,
            @WebParam(name = "ingredientes") String Pingredientes) {
        List<String> ingredientes = new ArrayList<>();
        double precio = 0.0;
        try {
            precio = Double.parseDouble(Pprecio);
            ingredientes = List.class.cast(Pingredientes);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            Pizza p = new Pizza(
                    Pnombre,
                    precio,
                    (ArrayList<String>) ingredientes);
            GestorPizzas.getInstance().insertarPizza(p);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "eliminarPizza")
    public String eliminarPizza(@WebParam(name = "nombre") String Pnombre) {
        try {
            GestorPizzas.getInstance().eliminarPizza(Pnombre);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "actualizarPizza")
    public String actualizarPizza(
            @WebParam(name = "nombre1") String Pnombre1,
            @WebParam(name = "nombre2") String Pnombre2,
            @WebParam(name = "precio") String Pprecio,
            @WebParam(name = "ingredientes") String Pingredientes) {

        List<String> ingredientes = new ArrayList<>();
        double precio = 0.0;
        try {
            precio = Double.parseDouble(Pprecio);
            ingredientes = List.class.cast(Pingredientes);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            Pizza p = new Pizza(Pnombre2, precio, (ArrayList<String>) ingredientes);
            GestorPizzas.getInstance().actualizarPizza(Pnombre1, p);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "buscarPizza")
    public String buscarPizza(@WebParam(name = "nombre") String Pnombre) {
        try {
            return GestorPizzas.getInstance().buscarPizza(Pnombre);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "listarPizzas")
    public String listarPizzas() {
        try {
            return GestorPizzas.getInstance().listarPizzas();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    // </editor-fold>
    
}
