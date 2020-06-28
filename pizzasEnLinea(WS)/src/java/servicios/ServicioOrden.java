/*
    servicioOrden.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package servicios;

import DAO.GestorOrden;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Pizza;
import modelo.orden;

@WebService(serviceName = "ServicioOrden")
public class ServicioOrden {

// <editor-fold defaultstate="collapsed" desc="orden">
    @WebMethod(operationName = "insertOrder")
    public String insertOrder(
            @WebParam(name = "cedula") String Pcedula,
            @WebParam(name = "nombreCompleto") String PnombreCompleto,
            @WebParam(name = "numOrden") String PnumOrden,
            @WebParam(name = "pizzas") String Ppizzas,
            @WebParam(name = "extras") String Pextras,
            @WebParam(name = "fecha") String Pfecha,
            @WebParam(name = "estado") String Pestado,
            @WebParam(name = "metodo_pago") String Pmetodo_pago,
            @WebParam(name = "precio") String Pprecio) {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        ArrayList<String> extras = new ArrayList<String>();
        double precio = 0.0;
        int numOrden = 0;
        int estado = 0;
        Date fecha = null;
        try {
            fecha = new Date(Pfecha);
            numOrden = Integer.parseInt(Pprecio);
            estado = Integer.parseInt(Pestado);
            precio = Double.parseDouble(Pprecio);
            pizzas = (ArrayList<Pizza>) List.class.cast(Ppizzas);
            extras = (ArrayList<String>) List.class.cast(Pextras);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            orden o = new orden(
                    Pcedula,
                    PnombreCompleto,
                    numOrden,
                    pizzas,
                    extras,
                    fecha,
                    estado,
                    Pmetodo_pago,
                    precio);
            GestorOrden.getInstance().insertOrder(o);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "listOrder")
    public String listOrder() {
        try {
            return GestorOrden.getInstance().listOrder();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "getOrder")
    public String getOrder(@WebParam(name = "numero") String Pnumero) {
        int numero = 0;
        try {
            numero = Integer.parseInt(Pnumero);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            return GestorOrden.getInstance().getOrder(numero);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "updateEstado")
    public String updateEstado(
            @WebParam(name = "numero") String Pnumero,
            @WebParam(name = "estado") String Pestado)
    {

        int numero = 0;
        int estado = 0;
        try {
            numero = Integer.parseInt(Pnumero);
            estado = Integer.parseInt(Pestado);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            GestorOrden.getInstance().updateEstado(numero, estado);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    // </editor-fold>
    
}
