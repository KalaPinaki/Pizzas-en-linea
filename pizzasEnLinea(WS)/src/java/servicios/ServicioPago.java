/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.GestorMetodoPago;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author leoba
 */
@WebService(serviceName = "ServicioPago")
public class ServicioPago {

// <editor-fold defaultstate="collapsed" desc="metodos pago">
    @WebMethod(operationName = "listarMetodosPago")
    public String listarMetodosPago() {
        try {
            return GestorMetodoPago.getInstance().listarMetodosPago();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }
    // </editor-fold>
    
}
