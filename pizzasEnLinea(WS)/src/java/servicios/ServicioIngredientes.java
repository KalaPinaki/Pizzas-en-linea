/*
    servicioIngredientes.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package servicios;

import DAO.GestorIngredientes;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Ingredientes;

@WebService(serviceName = "ServicioIngredientes")
public class ServicioIngredientes {

// <editor-fold defaultstate="collapsed" desc="ingredientes">
    @WebMethod(operationName = "insertIngredientes")
    public String insertIngredientes(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "precio") String Pprecio) {
        double precio = 0.0;
        try {
            precio = Double.parseDouble(Pprecio);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            Ingredientes i = new Ingredientes(precio, Pnombre);
            GestorIngredientes.getInstance().insertIngredientes(i);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "deleteIngrediente")
    public String deleteIngrediente(@WebParam(name = "nombre") String Pnombre) {
        try {
            GestorIngredientes.getInstance().deleteIngrediente(Pnombre);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "updateIngrediente")
    public String updateIngrediente(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "campo") String Pcampo,
            @WebParam(name = "value") String Pvalue) {
        try {
            GestorIngredientes.getInstance().updateIngrediente(Pnombre, Pcampo, Pvalue);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "listarIngredientes")
    public String listarIngredientes() {
        try {
            return GestorIngredientes.getInstance().listarIngredientes();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "buscarIngrediente")
    public String buscarIngrediente(@WebParam(name = "nombre") String Pnombre) {
        try {
            return GestorIngredientes.getInstance().buscarIngrediente(Pnombre);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    // </editor-fold>
}
