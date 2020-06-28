/*
    servicioPago.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package servicios;

import DAO.GestorMetodoPago;
import javax.jws.WebService;
import javax.jws.WebMethod;


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
