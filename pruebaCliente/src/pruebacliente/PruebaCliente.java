/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebacliente;

import PizzaEnLinea.modelo.bebida.ServicioBebidas;
import PizzaEnLinea.modelo.bebida.ServicioBebidas_Service;
import PizzaEnLinea.modelo.complemento.ServicioComplemento;
import PizzaEnLinea.modelo.complemento.ServicioComplemento_Service;
import PizzaEnLinea.modelo.ingrediente.ServicioIngredientes;
import PizzaEnLinea.modelo.ingrediente.ServicioIngredientes_Service;
import PizzaEnLinea.modelo.orden.ServicioOrden;
import PizzaEnLinea.modelo.orden.ServicioOrden_Service;
import PizzaEnLinea.modelo.pago.ServicioPago;
import PizzaEnLinea.modelo.pago.ServicioPago_Service;
import PizzaEnLinea.modelo.pizza.ServicioPizza;
import PizzaEnLinea.modelo.pizza.ServicioPizza_Service;
import PizzaEnLinea.modelo.usuario.ServicioUsuario;
import PizzaEnLinea.modelo.usuario.ServicioUsuario_Service;
import java.util.Date;

/**
 *
 * @author leoba
 */
public class PruebaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ServicioBebidas_Service sb = new ServicioBebidas_Service();
//        ServicioBebidas b = sb.getServicioBebidasPort();
//        
//        System.out.println(b.listDrinks() + "\n\n\n");
//        
//        ServicioComplemento_Service sc = new ServicioComplemento_Service();
//        ServicioComplemento c = sc.getServicioComplementoPort();
//        System.out.println(c.listComplements() + "\n\n\n");
        
//        
        ServicioIngredientes_Service si = new ServicioIngredientes_Service();
        ServicioIngredientes i = si.getServicioIngredientesPort();
        System.out.println(i.listarIngredientes() + "\n\n\n");
//        System.out.println(i.buscarIngrediente("tomillo") + "\n\n\n");
//        
//        ServicioPago_Service spa = new ServicioPago_Service();
//        ServicioPago pa = spa.getServicioPagoPort();
//        System.out.println(pa.listarMetodosPago() + "\n\n\n");
//        
//        
//        ServicioUsuario_Service su = new ServicioUsuario_Service();
//        ServicioUsuario u = su.getServicioUsuarioPort();
//        System.out.println(u.listUser() + "\n\n\n");
//        
//        ServicioPizza_Service spi = new ServicioPizza_Service();
//        ServicioPizza pi = spi.getServicioPizzaPort();
//        System.out.println(pi.listarPizzas() + "\n\n\n");
        
        
//        ServicioOrden_Service so = new ServicioOrden_Service();
//        ServicioOrden o = so.getServicioOrdenPort();
//        System.out.println(o.listOrder() + "\n\n\n");
//        
//        
//        Date fecha = new Date();
//        
//        o.insertOrder("304950273", "Leonardo Baldares Gómez", "5", 
//                "\"pizzas\": [{\"nombre\":\"Suprema\",\"precio\":5000},{\"nombre\":\"Napolitana\",\"precio\":5000}]",
//                "\"extras\": [{\"nombre\":\"Coca-Cola\"}, {\"nombre\":\"Papas Fritas\"}]", fecha.toString(), "0", "contado", "500000");
//        
//        System.out.println(o.listOrder() + "\n\n\n");
        
    }
    
}
