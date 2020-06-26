
package PizzaEnLinea.modelo.pizza;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.pizza package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarPizza_QNAME = new QName("http://servicios/", "buscarPizza");
    private final static QName _BuscarPizzaResponse_QNAME = new QName("http://servicios/", "buscarPizzaResponse");
    private final static QName _ActualizarPizzaResponse_QNAME = new QName("http://servicios/", "actualizarPizzaResponse");
    private final static QName _ActualizarPizza_QNAME = new QName("http://servicios/", "actualizarPizza");
    private final static QName _EliminarPizza_QNAME = new QName("http://servicios/", "eliminarPizza");
    private final static QName _InsertarPizzaResponse_QNAME = new QName("http://servicios/", "insertarPizzaResponse");
    private final static QName _EliminarPizzaResponse_QNAME = new QName("http://servicios/", "eliminarPizzaResponse");
    private final static QName _ListarPizzasResponse_QNAME = new QName("http://servicios/", "listarPizzasResponse");
    private final static QName _InsertarPizza_QNAME = new QName("http://servicios/", "insertarPizza");
    private final static QName _ListarPizzas_QNAME = new QName("http://servicios/", "listarPizzas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.pizza
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarPizza }
     * 
     */
    public ActualizarPizza createActualizarPizza() {
        return new ActualizarPizza();
    }

    /**
     * Create an instance of {@link EliminarPizza }
     * 
     */
    public EliminarPizza createEliminarPizza() {
        return new EliminarPizza();
    }

    /**
     * Create an instance of {@link InsertarPizzaResponse }
     * 
     */
    public InsertarPizzaResponse createInsertarPizzaResponse() {
        return new InsertarPizzaResponse();
    }

    /**
     * Create an instance of {@link EliminarPizzaResponse }
     * 
     */
    public EliminarPizzaResponse createEliminarPizzaResponse() {
        return new EliminarPizzaResponse();
    }

    /**
     * Create an instance of {@link ListarPizzasResponse }
     * 
     */
    public ListarPizzasResponse createListarPizzasResponse() {
        return new ListarPizzasResponse();
    }

    /**
     * Create an instance of {@link InsertarPizza }
     * 
     */
    public InsertarPizza createInsertarPizza() {
        return new InsertarPizza();
    }

    /**
     * Create an instance of {@link ListarPizzas }
     * 
     */
    public ListarPizzas createListarPizzas() {
        return new ListarPizzas();
    }

    /**
     * Create an instance of {@link BuscarPizza }
     * 
     */
    public BuscarPizza createBuscarPizza() {
        return new BuscarPizza();
    }

    /**
     * Create an instance of {@link BuscarPizzaResponse }
     * 
     */
    public BuscarPizzaResponse createBuscarPizzaResponse() {
        return new BuscarPizzaResponse();
    }

    /**
     * Create an instance of {@link ActualizarPizzaResponse }
     * 
     */
    public ActualizarPizzaResponse createActualizarPizzaResponse() {
        return new ActualizarPizzaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPizza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "buscarPizza")
    public JAXBElement<BuscarPizza> createBuscarPizza(BuscarPizza value) {
        return new JAXBElement<BuscarPizza>(_BuscarPizza_QNAME, BuscarPizza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarPizzaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "buscarPizzaResponse")
    public JAXBElement<BuscarPizzaResponse> createBuscarPizzaResponse(BuscarPizzaResponse value) {
        return new JAXBElement<BuscarPizzaResponse>(_BuscarPizzaResponse_QNAME, BuscarPizzaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPizzaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "actualizarPizzaResponse")
    public JAXBElement<ActualizarPizzaResponse> createActualizarPizzaResponse(ActualizarPizzaResponse value) {
        return new JAXBElement<ActualizarPizzaResponse>(_ActualizarPizzaResponse_QNAME, ActualizarPizzaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarPizza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "actualizarPizza")
    public JAXBElement<ActualizarPizza> createActualizarPizza(ActualizarPizza value) {
        return new JAXBElement<ActualizarPizza>(_ActualizarPizza_QNAME, ActualizarPizza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarPizza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "eliminarPizza")
    public JAXBElement<EliminarPizza> createEliminarPizza(EliminarPizza value) {
        return new JAXBElement<EliminarPizza>(_EliminarPizza_QNAME, EliminarPizza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarPizzaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertarPizzaResponse")
    public JAXBElement<InsertarPizzaResponse> createInsertarPizzaResponse(InsertarPizzaResponse value) {
        return new JAXBElement<InsertarPizzaResponse>(_InsertarPizzaResponse_QNAME, InsertarPizzaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarPizzaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "eliminarPizzaResponse")
    public JAXBElement<EliminarPizzaResponse> createEliminarPizzaResponse(EliminarPizzaResponse value) {
        return new JAXBElement<EliminarPizzaResponse>(_EliminarPizzaResponse_QNAME, EliminarPizzaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPizzasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarPizzasResponse")
    public JAXBElement<ListarPizzasResponse> createListarPizzasResponse(ListarPizzasResponse value) {
        return new JAXBElement<ListarPizzasResponse>(_ListarPizzasResponse_QNAME, ListarPizzasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarPizza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertarPizza")
    public JAXBElement<InsertarPizza> createInsertarPizza(InsertarPizza value) {
        return new JAXBElement<InsertarPizza>(_InsertarPizza_QNAME, InsertarPizza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPizzas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarPizzas")
    public JAXBElement<ListarPizzas> createListarPizzas(ListarPizzas value) {
        return new JAXBElement<ListarPizzas>(_ListarPizzas_QNAME, ListarPizzas.class, null, value);
    }

}
