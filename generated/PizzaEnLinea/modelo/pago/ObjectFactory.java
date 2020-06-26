
package PizzaEnLinea.modelo.pago;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.pago package. 
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

    private final static QName _ListarMetodosPagoResponse_QNAME = new QName("http://servicios/", "listarMetodosPagoResponse");
    private final static QName _ListarMetodosPago_QNAME = new QName("http://servicios/", "listarMetodosPago");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.pago
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarMetodosPagoResponse }
     * 
     */
    public ListarMetodosPagoResponse createListarMetodosPagoResponse() {
        return new ListarMetodosPagoResponse();
    }

    /**
     * Create an instance of {@link ListarMetodosPago }
     * 
     */
    public ListarMetodosPago createListarMetodosPago() {
        return new ListarMetodosPago();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMetodosPagoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarMetodosPagoResponse")
    public JAXBElement<ListarMetodosPagoResponse> createListarMetodosPagoResponse(ListarMetodosPagoResponse value) {
        return new JAXBElement<ListarMetodosPagoResponse>(_ListarMetodosPagoResponse_QNAME, ListarMetodosPagoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMetodosPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarMetodosPago")
    public JAXBElement<ListarMetodosPago> createListarMetodosPago(ListarMetodosPago value) {
        return new JAXBElement<ListarMetodosPago>(_ListarMetodosPago_QNAME, ListarMetodosPago.class, null, value);
    }

}
