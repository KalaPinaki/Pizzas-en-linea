
package PizzaEnLinea.modelo.ingrediente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.ingrediente package. 
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

    private final static QName _DeleteIngrediente_QNAME = new QName("http://servicios/", "deleteIngrediente");
    private final static QName _InsertIngredientesResponse_QNAME = new QName("http://servicios/", "insertIngredientesResponse");
    private final static QName _ListarIngredientes_QNAME = new QName("http://servicios/", "listarIngredientes");
    private final static QName _BuscarIngrediente_QNAME = new QName("http://servicios/", "buscarIngrediente");
    private final static QName _InsertIngredientes_QNAME = new QName("http://servicios/", "insertIngredientes");
    private final static QName _ListarIngredientesResponse_QNAME = new QName("http://servicios/", "listarIngredientesResponse");
    private final static QName _DeleteIngredienteResponse_QNAME = new QName("http://servicios/", "deleteIngredienteResponse");
    private final static QName _BuscarIngredienteResponse_QNAME = new QName("http://servicios/", "buscarIngredienteResponse");
    private final static QName _UpdateIngredienteResponse_QNAME = new QName("http://servicios/", "updateIngredienteResponse");
    private final static QName _UpdateIngrediente_QNAME = new QName("http://servicios/", "updateIngrediente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.ingrediente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteIngredienteResponse }
     * 
     */
    public DeleteIngredienteResponse createDeleteIngredienteResponse() {
        return new DeleteIngredienteResponse();
    }

    /**
     * Create an instance of {@link BuscarIngredienteResponse }
     * 
     */
    public BuscarIngredienteResponse createBuscarIngredienteResponse() {
        return new BuscarIngredienteResponse();
    }

    /**
     * Create an instance of {@link UpdateIngredienteResponse }
     * 
     */
    public UpdateIngredienteResponse createUpdateIngredienteResponse() {
        return new UpdateIngredienteResponse();
    }

    /**
     * Create an instance of {@link UpdateIngrediente }
     * 
     */
    public UpdateIngrediente createUpdateIngrediente() {
        return new UpdateIngrediente();
    }

    /**
     * Create an instance of {@link DeleteIngrediente }
     * 
     */
    public DeleteIngrediente createDeleteIngrediente() {
        return new DeleteIngrediente();
    }

    /**
     * Create an instance of {@link InsertIngredientesResponse }
     * 
     */
    public InsertIngredientesResponse createInsertIngredientesResponse() {
        return new InsertIngredientesResponse();
    }

    /**
     * Create an instance of {@link ListarIngredientes }
     * 
     */
    public ListarIngredientes createListarIngredientes() {
        return new ListarIngredientes();
    }

    /**
     * Create an instance of {@link BuscarIngrediente }
     * 
     */
    public BuscarIngrediente createBuscarIngrediente() {
        return new BuscarIngrediente();
    }

    /**
     * Create an instance of {@link InsertIngredientes }
     * 
     */
    public InsertIngredientes createInsertIngredientes() {
        return new InsertIngredientes();
    }

    /**
     * Create an instance of {@link ListarIngredientesResponse }
     * 
     */
    public ListarIngredientesResponse createListarIngredientesResponse() {
        return new ListarIngredientesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteIngrediente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteIngrediente")
    public JAXBElement<DeleteIngrediente> createDeleteIngrediente(DeleteIngrediente value) {
        return new JAXBElement<DeleteIngrediente>(_DeleteIngrediente_QNAME, DeleteIngrediente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIngredientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertIngredientesResponse")
    public JAXBElement<InsertIngredientesResponse> createInsertIngredientesResponse(InsertIngredientesResponse value) {
        return new JAXBElement<InsertIngredientesResponse>(_InsertIngredientesResponse_QNAME, InsertIngredientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarIngredientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarIngredientes")
    public JAXBElement<ListarIngredientes> createListarIngredientes(ListarIngredientes value) {
        return new JAXBElement<ListarIngredientes>(_ListarIngredientes_QNAME, ListarIngredientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarIngrediente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "buscarIngrediente")
    public JAXBElement<BuscarIngrediente> createBuscarIngrediente(BuscarIngrediente value) {
        return new JAXBElement<BuscarIngrediente>(_BuscarIngrediente_QNAME, BuscarIngrediente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertIngredientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertIngredientes")
    public JAXBElement<InsertIngredientes> createInsertIngredientes(InsertIngredientes value) {
        return new JAXBElement<InsertIngredientes>(_InsertIngredientes_QNAME, InsertIngredientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarIngredientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listarIngredientesResponse")
    public JAXBElement<ListarIngredientesResponse> createListarIngredientesResponse(ListarIngredientesResponse value) {
        return new JAXBElement<ListarIngredientesResponse>(_ListarIngredientesResponse_QNAME, ListarIngredientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteIngredienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteIngredienteResponse")
    public JAXBElement<DeleteIngredienteResponse> createDeleteIngredienteResponse(DeleteIngredienteResponse value) {
        return new JAXBElement<DeleteIngredienteResponse>(_DeleteIngredienteResponse_QNAME, DeleteIngredienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarIngredienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "buscarIngredienteResponse")
    public JAXBElement<BuscarIngredienteResponse> createBuscarIngredienteResponse(BuscarIngredienteResponse value) {
        return new JAXBElement<BuscarIngredienteResponse>(_BuscarIngredienteResponse_QNAME, BuscarIngredienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIngredienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateIngredienteResponse")
    public JAXBElement<UpdateIngredienteResponse> createUpdateIngredienteResponse(UpdateIngredienteResponse value) {
        return new JAXBElement<UpdateIngredienteResponse>(_UpdateIngredienteResponse_QNAME, UpdateIngredienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIngrediente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateIngrediente")
    public JAXBElement<UpdateIngrediente> createUpdateIngrediente(UpdateIngrediente value) {
        return new JAXBElement<UpdateIngrediente>(_UpdateIngrediente_QNAME, UpdateIngrediente.class, null, value);
    }

}
