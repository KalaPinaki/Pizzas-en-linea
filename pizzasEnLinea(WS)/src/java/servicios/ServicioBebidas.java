/*
    servicioBebidas.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package servicios;

import DAO.GestorBebidas;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.bebidas;


@WebService(serviceName = "ServicioBebidas")
public class ServicioBebidas {

// <editor-fold defaultstate="collapsed" desc="bebidas">
    @WebMethod(operationName = "listDrinks")
    public String listDrinks() {
        try {
            return GestorBebidas.getInstance().listDrinks();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "insertDrink")
    public String insertDrink(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "precio") String Pprecio) {
        double precio = 0.0;
        try {
            precio = Double.parseDouble(Pprecio);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            bebidas b = new bebidas(Pnombre, precio);
            GestorBebidas.getInstance().insertDrink(b);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "deleteDrink")
    public String deleteDrink(@WebParam(name = "nombre") String Pnombre) {
        try {
            GestorBebidas.getInstance().deleteDrink(Pnombre);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "updateDrink")
    public String updateDrink(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "campo") String Pcampo,
            @WebParam(name = "value") String Pvalue) {
        try {
            GestorBebidas.getInstance().updateDrink(Pnombre, Pcampo, Pvalue);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "getDrink")
    public String getDrink(@WebParam(name = "nombre") String Pnombre) {
        try {
            return GestorBebidas.getInstance().getDrink(Pnombre);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    // </editor-fold>
    
}
