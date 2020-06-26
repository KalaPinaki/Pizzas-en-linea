
package PizzaEnLinea.modelo.orden;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.orden package. 
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

    private final static QName _GetOrderResponse_QNAME = new QName("http://servicios/", "getOrderResponse");
    private final static QName _UpdateEstado_QNAME = new QName("http://servicios/", "updateEstado");
    private final static QName _UpdateEstadoResponse_QNAME = new QName("http://servicios/", "updateEstadoResponse");
    private final static QName _InsertOrderResponse_QNAME = new QName("http://servicios/", "insertOrderResponse");
    private final static QName _InsertOrder_QNAME = new QName("http://servicios/", "insertOrder");
    private final static QName _ListOrderResponse_QNAME = new QName("http://servicios/", "listOrderResponse");
    private final static QName _GetOrder_QNAME = new QName("http://servicios/", "getOrder");
    private final static QName _ListOrder_QNAME = new QName("http://servicios/", "listOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.orden
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertOrderResponse }
     * 
     */
    public InsertOrderResponse createInsertOrderResponse() {
        return new InsertOrderResponse();
    }

    /**
     * Create an instance of {@link InsertOrder }
     * 
     */
    public InsertOrder createInsertOrder() {
        return new InsertOrder();
    }

    /**
     * Create an instance of {@link ListOrderResponse }
     * 
     */
    public ListOrderResponse createListOrderResponse() {
        return new ListOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrder }
     * 
     */
    public GetOrder createGetOrder() {
        return new GetOrder();
    }

    /**
     * Create an instance of {@link ListOrder }
     * 
     */
    public ListOrder createListOrder() {
        return new ListOrder();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link UpdateEstado }
     * 
     */
    public UpdateEstado createUpdateEstado() {
        return new UpdateEstado();
    }

    /**
     * Create an instance of {@link UpdateEstadoResponse }
     * 
     */
    public UpdateEstadoResponse createUpdateEstadoResponse() {
        return new UpdateEstadoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getOrderResponse")
    public JAXBElement<GetOrderResponse> createGetOrderResponse(GetOrderResponse value) {
        return new JAXBElement<GetOrderResponse>(_GetOrderResponse_QNAME, GetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateEstado")
    public JAXBElement<UpdateEstado> createUpdateEstado(UpdateEstado value) {
        return new JAXBElement<UpdateEstado>(_UpdateEstado_QNAME, UpdateEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateEstadoResponse")
    public JAXBElement<UpdateEstadoResponse> createUpdateEstadoResponse(UpdateEstadoResponse value) {
        return new JAXBElement<UpdateEstadoResponse>(_UpdateEstadoResponse_QNAME, UpdateEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertOrderResponse")
    public JAXBElement<InsertOrderResponse> createInsertOrderResponse(InsertOrderResponse value) {
        return new JAXBElement<InsertOrderResponse>(_InsertOrderResponse_QNAME, InsertOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertOrder")
    public JAXBElement<InsertOrder> createInsertOrder(InsertOrder value) {
        return new JAXBElement<InsertOrder>(_InsertOrder_QNAME, InsertOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listOrderResponse")
    public JAXBElement<ListOrderResponse> createListOrderResponse(ListOrderResponse value) {
        return new JAXBElement<ListOrderResponse>(_ListOrderResponse_QNAME, ListOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getOrder")
    public JAXBElement<GetOrder> createGetOrder(GetOrder value) {
        return new JAXBElement<GetOrder>(_GetOrder_QNAME, GetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listOrder")
    public JAXBElement<ListOrder> createListOrder(ListOrder value) {
        return new JAXBElement<ListOrder>(_ListOrder_QNAME, ListOrder.class, null, value);
    }

}
