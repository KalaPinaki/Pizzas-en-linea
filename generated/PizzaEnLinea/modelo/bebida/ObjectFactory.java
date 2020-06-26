
package PizzaEnLinea.modelo.bebida;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.bebida package. 
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

    private final static QName _DeleteDrink_QNAME = new QName("http://servicios/", "deleteDrink");
    private final static QName _UpdateDrink_QNAME = new QName("http://servicios/", "updateDrink");
    private final static QName _DeleteDrinkResponse_QNAME = new QName("http://servicios/", "deleteDrinkResponse");
    private final static QName _UpdateDrinkResponse_QNAME = new QName("http://servicios/", "updateDrinkResponse");
    private final static QName _ListDrinks_QNAME = new QName("http://servicios/", "listDrinks");
    private final static QName _GetDrinkResponse_QNAME = new QName("http://servicios/", "getDrinkResponse");
    private final static QName _InsertDrinkResponse_QNAME = new QName("http://servicios/", "insertDrinkResponse");
    private final static QName _InsertDrink_QNAME = new QName("http://servicios/", "insertDrink");
    private final static QName _ListDrinksResponse_QNAME = new QName("http://servicios/", "listDrinksResponse");
    private final static QName _GetDrink_QNAME = new QName("http://servicios/", "getDrink");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.bebida
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListDrinks }
     * 
     */
    public ListDrinks createListDrinks() {
        return new ListDrinks();
    }

    /**
     * Create an instance of {@link GetDrinkResponse }
     * 
     */
    public GetDrinkResponse createGetDrinkResponse() {
        return new GetDrinkResponse();
    }

    /**
     * Create an instance of {@link InsertDrinkResponse }
     * 
     */
    public InsertDrinkResponse createInsertDrinkResponse() {
        return new InsertDrinkResponse();
    }

    /**
     * Create an instance of {@link InsertDrink }
     * 
     */
    public InsertDrink createInsertDrink() {
        return new InsertDrink();
    }

    /**
     * Create an instance of {@link ListDrinksResponse }
     * 
     */
    public ListDrinksResponse createListDrinksResponse() {
        return new ListDrinksResponse();
    }

    /**
     * Create an instance of {@link GetDrink }
     * 
     */
    public GetDrink createGetDrink() {
        return new GetDrink();
    }

    /**
     * Create an instance of {@link DeleteDrink }
     * 
     */
    public DeleteDrink createDeleteDrink() {
        return new DeleteDrink();
    }

    /**
     * Create an instance of {@link UpdateDrink }
     * 
     */
    public UpdateDrink createUpdateDrink() {
        return new UpdateDrink();
    }

    /**
     * Create an instance of {@link DeleteDrinkResponse }
     * 
     */
    public DeleteDrinkResponse createDeleteDrinkResponse() {
        return new DeleteDrinkResponse();
    }

    /**
     * Create an instance of {@link UpdateDrinkResponse }
     * 
     */
    public UpdateDrinkResponse createUpdateDrinkResponse() {
        return new UpdateDrinkResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDrink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteDrink")
    public JAXBElement<DeleteDrink> createDeleteDrink(DeleteDrink value) {
        return new JAXBElement<DeleteDrink>(_DeleteDrink_QNAME, DeleteDrink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDrink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateDrink")
    public JAXBElement<UpdateDrink> createUpdateDrink(UpdateDrink value) {
        return new JAXBElement<UpdateDrink>(_UpdateDrink_QNAME, UpdateDrink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDrinkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "deleteDrinkResponse")
    public JAXBElement<DeleteDrinkResponse> createDeleteDrinkResponse(DeleteDrinkResponse value) {
        return new JAXBElement<DeleteDrinkResponse>(_DeleteDrinkResponse_QNAME, DeleteDrinkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDrinkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateDrinkResponse")
    public JAXBElement<UpdateDrinkResponse> createUpdateDrinkResponse(UpdateDrinkResponse value) {
        return new JAXBElement<UpdateDrinkResponse>(_UpdateDrinkResponse_QNAME, UpdateDrinkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDrinks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listDrinks")
    public JAXBElement<ListDrinks> createListDrinks(ListDrinks value) {
        return new JAXBElement<ListDrinks>(_ListDrinks_QNAME, ListDrinks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDrinkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getDrinkResponse")
    public JAXBElement<GetDrinkResponse> createGetDrinkResponse(GetDrinkResponse value) {
        return new JAXBElement<GetDrinkResponse>(_GetDrinkResponse_QNAME, GetDrinkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDrinkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertDrinkResponse")
    public JAXBElement<InsertDrinkResponse> createInsertDrinkResponse(InsertDrinkResponse value) {
        return new JAXBElement<InsertDrinkResponse>(_InsertDrinkResponse_QNAME, InsertDrinkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertDrink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertDrink")
    public JAXBElement<InsertDrink> createInsertDrink(InsertDrink value) {
        return new JAXBElement<InsertDrink>(_InsertDrink_QNAME, InsertDrink.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDrinksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listDrinksResponse")
    public JAXBElement<ListDrinksResponse> createListDrinksResponse(ListDrinksResponse value) {
        return new JAXBElement<ListDrinksResponse>(_ListDrinksResponse_QNAME, ListDrinksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDrink }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getDrink")
    public JAXBElement<GetDrink> createGetDrink(GetDrink value) {
        return new JAXBElement<GetDrink>(_GetDrink_QNAME, GetDrink.class, null, value);
    }

}
