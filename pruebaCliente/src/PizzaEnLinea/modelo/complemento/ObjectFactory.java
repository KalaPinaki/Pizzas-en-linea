
package PizzaEnLinea.modelo.complemento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.complemento package. 
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

    private final static QName _ListComplements_QNAME = new QName("http://servicios/", "listComplements");
    private final static QName _ListComplementsResponse_QNAME = new QName("http://servicios/", "listComplementsResponse");
    private final static QName _UpdateComplements_QNAME = new QName("http://servicios/", "updateComplements");
    private final static QName _DeleteComplementResponse_QNAME = new QName("http://servicios/", "deleteComplementResponse");
    private final static QName _InsertComplemet_QNAME = new QName("http://servicios/", "insertComplemet");
    private final static QName _DeleteComplement_QNAME = new QName("http://servicios/", "deleteComplement");
    private final static QName _UpdateComplementsResponse_QNAME = new QName("http://servicios/", "updateComplementsResponse");
    private final static QName _GetComplement_QNAME = new QName("http://servicios/", "getComplement");
    private final static QName _GetComplementResponse_QNAME = new QName("http://servicios/", "getComplementResponse");
    private final static QName _InsertComplemetResponse_QNAME = new QName("http://servicios/", "insertComplemetResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.complemento
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteComplementResponse }
     * 
     */
    public DeleteComplementResponse createDeleteComplementResponse() {
        return new DeleteComplementResponse();
    }

    /**
     * Create an instance of {@link InsertComplemet }
     * 
     */
    public InsertComplemet createInsertComplemet() {
        return new InsertComplemet();
    }

    /**
     * Create an instance of {@link DeleteComplement }
     * 
     */
    public DeleteComplement createDeleteComplement() {
        return new DeleteComplement();
    }

    /**
     * Create an instance of {@link UpdateComplementsResponse }
     * 
     */
    public UpdateComplementsResponse createUpdateComplementsResponse() {
        return new UpdateComplementsResponse();
    }

    /**
     * Create an instance of {@link GetComplement }
     * 
     */
    public GetComplement createGetComplement() {
        return new GetComplement();
    }

    /**
     * Create an instance of {@link GetComplementResponse }
     * 
     */
    public GetComplementResponse createGetComplementResponse() {
        return new GetComplementResponse();
    }

    /**
     * Create an instance of {@link InsertComplemetResponse }
     * 
     */
    public InsertComplemetResponse createInsertComplemetResponse() {
        return new InsertComplemetResponse();
    }

    /**
     * Create an instance of {@link ListComplements }
     * 
     */
    public ListComplements createListComplements() {
        return new ListComplements();
    }

    /**
     * Create an instance of {@link ListComplementsResponse }
     * 
     */
    public ListComplementsResponse createListComplementsResponse() {
        return new ListComplementsResponse();
    }

    /**
     * Create an instance of {@link UpdateComplements }
     * 
     */
    public UpdateComplements createUpdateComplements() {
        return new UpdateComplements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComplements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listComplements")
    public JAXBElement<ListComplements> createListComplements(ListComplements value) {
        return new JAXBElement<ListComplements>(_ListComplements_QNAME, ListComplements.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListComplementsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listComplementsResponse")
    public JAXBElement<ListComplementsResponse> createListComplementsResponse(ListComplementsResponse value) {
        return new JAXBElement<ListComplementsResponse>(_ListComplementsResponse_QNAME, ListComplementsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateComplements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateComplements")
    public JAXBElement<UpdateComplements> createUpdateComplements(UpdateComplements value) {
        return new JAXBElement<UpdateComplements>(_UpdateComplements_QNAME, UpdateComplements.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComplementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteComplementResponse")
    public JAXBElement<DeleteComplementResponse> createDeleteComplementResponse(DeleteComplementResponse value) {
        return new JAXBElement<DeleteComplementResponse>(_DeleteComplementResponse_QNAME, DeleteComplementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertComplemet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertComplemet")
    public JAXBElement<InsertComplemet> createInsertComplemet(InsertComplemet value) {
        return new JAXBElement<InsertComplemet>(_InsertComplemet_QNAME, InsertComplemet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteComplement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteComplement")
    public JAXBElement<DeleteComplement> createDeleteComplement(DeleteComplement value) {
        return new JAXBElement<DeleteComplement>(_DeleteComplement_QNAME, DeleteComplement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateComplementsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateComplementsResponse")
    public JAXBElement<UpdateComplementsResponse> createUpdateComplementsResponse(UpdateComplementsResponse value) {
        return new JAXBElement<UpdateComplementsResponse>(_UpdateComplementsResponse_QNAME, UpdateComplementsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComplement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getComplement")
    public JAXBElement<GetComplement> createGetComplement(GetComplement value) {
        return new JAXBElement<GetComplement>(_GetComplement_QNAME, GetComplement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComplementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getComplementResponse")
    public JAXBElement<GetComplementResponse> createGetComplementResponse(GetComplementResponse value) {
        return new JAXBElement<GetComplementResponse>(_GetComplementResponse_QNAME, GetComplementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertComplemetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertComplemetResponse")
    public JAXBElement<InsertComplemetResponse> createInsertComplemetResponse(InsertComplemetResponse value) {
        return new JAXBElement<InsertComplemetResponse>(_InsertComplemetResponse_QNAME, InsertComplemetResponse.class, null, value);
    }

}
