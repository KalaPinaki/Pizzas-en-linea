/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.GestorUsuarios;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Usuario;

/**
 *
 * @author leoba
 */
@WebService(serviceName = "ServicioUsuario")
public class ServicioUsuario {

// <editor-fold defaultstate="collapsed" desc="usuarios">
    @WebMethod(operationName = "insertUser")
    public String insertUser(
            @WebParam(name = "nombre") String Pnombre,
            @WebParam(name = "apellidos") String Papellidos,
            @WebParam(name = "cedula") String Pcedula,
            @WebParam(name = "direccion") String Pdireccion,
            @WebParam(name = "contraseña") String Pcontraseña,
            @WebParam(name = "telefono") String Ptelefono,
            @WebParam(name = "rol") String Prol) {
        boolean rol = true;
        try {
            rol = Boolean.parseBoolean(Prol);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        try {
            Usuario u = new Usuario(
                    Pnombre,
                    Papellidos,
                    Pcedula,
                    Pdireccion,
                    Pcontraseña,
                    Ptelefono,
                    rol);
            GestorUsuarios.getInstance().insertUser(u);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "updateUser")
    public String updateUser(
            @WebParam(name = "cedula") String Pcedula,
            @WebParam(name = "direccion") String Pdireccion,
            @WebParam(name = "telefono") String Ptelefono) {
        try {
            GestorUsuarios.getInstance().updateUser(Pcedula, Pdireccion, Ptelefono);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "updatePassword")
    public String updatePassword(
            @WebParam(name = "cedula") String Pcedula,
            @WebParam(name = "newPass") String PnewPass) {
        try {
            GestorUsuarios.getInstance().updatePassword(Pcedula, PnewPass);
            return "exito!";
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "listUser")
    public String listUser() {
        try {
            return GestorUsuarios.getInstance().listUser();
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    @WebMethod(operationName = "getUser")
    public String getUser(@WebParam(name = "cedula") String Pcedula) {
        try {
            return GestorUsuarios.getInstance().getUser(Pcedula);
        } catch (NullPointerException | NumberFormatException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return "fallo!";
    }

    // </editor-fold>
    
}
