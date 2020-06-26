
package PizzaEnLinea.modelo.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PizzaEnLinea.modelo.usuario package. 
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

    private final static QName _UpdateUser_QNAME = new QName("http://servicios/", "updateUser");
    private final static QName _ListUser_QNAME = new QName("http://servicios/", "listUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://servicios/", "updateUserResponse");
    private final static QName _InsertUserResponse_QNAME = new QName("http://servicios/", "insertUserResponse");
    private final static QName _ListUserResponse_QNAME = new QName("http://servicios/", "listUserResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://servicios/", "getUserResponse");
    private final static QName _UpdatePasswordResponse_QNAME = new QName("http://servicios/", "updatePasswordResponse");
    private final static QName _InsertUser_QNAME = new QName("http://servicios/", "insertUser");
    private final static QName _UpdatePassword_QNAME = new QName("http://servicios/", "updatePassword");
    private final static QName _GetUser_QNAME = new QName("http://servicios/", "getUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PizzaEnLinea.modelo.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link UpdatePasswordResponse }
     * 
     */
    public UpdatePasswordResponse createUpdatePasswordResponse() {
        return new UpdatePasswordResponse();
    }

    /**
     * Create an instance of {@link InsertUser }
     * 
     */
    public InsertUser createInsertUser() {
        return new InsertUser();
    }

    /**
     * Create an instance of {@link UpdatePassword }
     * 
     */
    public UpdatePassword createUpdatePassword() {
        return new UpdatePassword();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link ListUser }
     * 
     */
    public ListUser createListUser() {
        return new ListUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link InsertUserResponse }
     * 
     */
    public InsertUserResponse createInsertUserResponse() {
        return new InsertUserResponse();
    }

    /**
     * Create an instance of {@link ListUserResponse }
     * 
     */
    public ListUserResponse createListUserResponse() {
        return new ListUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listUser")
    public JAXBElement<ListUser> createListUser(ListUser value) {
        return new JAXBElement<ListUser>(_ListUser_QNAME, ListUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertUserResponse")
    public JAXBElement<InsertUserResponse> createInsertUserResponse(InsertUserResponse value) {
        return new JAXBElement<InsertUserResponse>(_InsertUserResponse_QNAME, InsertUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "listUserResponse")
    public JAXBElement<ListUserResponse> createListUserResponse(ListUserResponse value) {
        return new JAXBElement<ListUserResponse>(_ListUserResponse_QNAME, ListUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updatePasswordResponse")
    public JAXBElement<UpdatePasswordResponse> createUpdatePasswordResponse(UpdatePasswordResponse value) {
        return new JAXBElement<UpdatePasswordResponse>(_UpdatePasswordResponse_QNAME, UpdatePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "insertUser")
    public JAXBElement<InsertUser> createInsertUser(InsertUser value) {
        return new JAXBElement<InsertUser>(_InsertUser_QNAME, InsertUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "updatePassword")
    public JAXBElement<UpdatePassword> createUpdatePassword(UpdatePassword value) {
        return new JAXBElement<UpdatePassword>(_UpdatePassword_QNAME, UpdatePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

}
