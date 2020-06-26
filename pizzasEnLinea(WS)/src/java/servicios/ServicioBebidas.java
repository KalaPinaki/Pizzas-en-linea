/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.GestorBebidas;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.bebidas;

/**
 *
 * @author leoba
 */
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
