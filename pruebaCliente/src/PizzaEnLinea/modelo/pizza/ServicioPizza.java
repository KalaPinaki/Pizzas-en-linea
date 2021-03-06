
package PizzaEnLinea.modelo.pizza;

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
@WebService(name = "ServicioPizza", targetNamespace = "http://servicios/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioPizza {


    /**
     * 
     * @param precio
     * @param ingredientes
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertarPizza", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.InsertarPizza")
    @ResponseWrapper(localName = "insertarPizzaResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.InsertarPizzaResponse")
    @Action(input = "http://servicios/ServicioPizza/insertarPizzaRequest", output = "http://servicios/ServicioPizza/insertarPizzaResponse")
    public String insertarPizza(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "precio", targetNamespace = "")
        String precio,
        @WebParam(name = "ingredientes", targetNamespace = "")
        String ingredientes);

    /**
     * 
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPizza", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.BuscarPizza")
    @ResponseWrapper(localName = "buscarPizzaResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.BuscarPizzaResponse")
    @Action(input = "http://servicios/ServicioPizza/buscarPizzaRequest", output = "http://servicios/ServicioPizza/buscarPizzaResponse")
    public String buscarPizza(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

    /**
     * 
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarPizza", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.EliminarPizza")
    @ResponseWrapper(localName = "eliminarPizzaResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.EliminarPizzaResponse")
    @Action(input = "http://servicios/ServicioPizza/eliminarPizzaRequest", output = "http://servicios/ServicioPizza/eliminarPizzaResponse")
    public String eliminarPizza(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPizzas", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.ListarPizzas")
    @ResponseWrapper(localName = "listarPizzasResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.ListarPizzasResponse")
    @Action(input = "http://servicios/ServicioPizza/listarPizzasRequest", output = "http://servicios/ServicioPizza/listarPizzasResponse")
    public String listarPizzas();

    /**
     * 
     * @param precio
     * @param ingredientes
     * @param nombre2
     * @param nombre1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "actualizarPizza", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.ActualizarPizza")
    @ResponseWrapper(localName = "actualizarPizzaResponse", targetNamespace = "http://servicios/", className = "PizzaEnLinea.modelo.pizza.ActualizarPizzaResponse")
    @Action(input = "http://servicios/ServicioPizza/actualizarPizzaRequest", output = "http://servicios/ServicioPizza/actualizarPizzaResponse")
    public String actualizarPizza(
        @WebParam(name = "nombre1", targetNamespace = "")
        String nombre1,
        @WebParam(name = "nombre2", targetNamespace = "")
        String nombre2,
        @WebParam(name = "precio", targetNamespace = "")
        String precio,
        @WebParam(name = "ingredientes", targetNamespace = "")
        String ingredientes);

}
