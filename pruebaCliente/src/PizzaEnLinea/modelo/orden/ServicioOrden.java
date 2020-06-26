
package PizzaEnLinea.modelo.orden;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioOrden", targetNamespace = "http://servicios/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioOrden {


    /**
     * 
     * @param numero
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrder", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.GetOrder")
    @ResponseWrapper(localName = "getOrderResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.GetOrderResponse")
    @Action(input = "http://servicios/ServicioOrden/getOrderRequest", output = "http://servicios/ServicioOrden/getOrderResponse")
    public String getOrder(
        @WebParam(name = "numero", targetNamespace = "")
        String numero);

    /**
     * 
     * @param metodoPago
     * @param fecha
     * @param estado
     * @param precio
     * @param pizzas
     * @param cedula
     * @param extras
     * @param nombreCompleto
     * @param numOrden
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertOrder", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.InsertOrder")
    @ResponseWrapper(localName = "insertOrderResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.InsertOrderResponse")
    @Action(input = "http://servicios/ServicioOrden/insertOrderRequest", output = "http://servicios/ServicioOrden/insertOrderResponse")
    public String insertOrder(
        @WebParam(name = "cedula", targetNamespace = "")
        String cedula,
        @WebParam(name = "nombreCompleto", targetNamespace = "")
        String nombreCompleto,
        @WebParam(name = "numOrden", targetNamespace = "")
        String numOrden,
        @WebParam(name = "pizzas", targetNamespace = "")
        String pizzas,
        @WebParam(name = "extras", targetNamespace = "")
        String extras,
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha,
        @WebParam(name = "estado", targetNamespace = "")
        String estado,
        @WebParam(name = "metodo_pago", targetNamespace = "")
        String metodoPago,
        @WebParam(name = "precio", targetNamespace = "")
        String precio);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listOrder", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.ListOrder")
    @ResponseWrapper(localName = "listOrderResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.ListOrderResponse")
    @Action(input = "http://servicios/ServicioOrden/listOrderRequest", output = "http://servicios/ServicioOrden/listOrderResponse")
    public String listOrder();

    /**
     * 
     * @param estado
     * @param numero
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateEstado", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.UpdateEstado")
    @ResponseWrapper(localName = "updateEstadoResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.orden.UpdateEstadoResponse")
    @Action(input = "http://servicios/ServicioOrden/updateEstadoRequest", output = "http://servicios/ServicioOrden/updateEstadoResponse")
    public String updateEstado(
        @WebParam(name = "numero", targetNamespace = "")
        String numero,
        @WebParam(name = "estado", targetNamespace = "")
        String estado);

}