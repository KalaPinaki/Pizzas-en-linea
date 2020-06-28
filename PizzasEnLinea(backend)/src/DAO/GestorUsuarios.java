/*
    GestorUsuario.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import org.bson.Document;

public class GestorUsuarios implements Serializable {

    private static GestorUsuarios instancia = null;//para singleton
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorUsuarios() {//para crear la conexion como un cliente de mongo
        try {
            mongo = MongoClients.create("mongodb://localhost:27017");
            crearConexion();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    private void crearConexion() {
        baseDatos = "pizzeria";
        db = mongo.getDatabase(baseDatos);
        System.out.println("Conexión completada..");
    }

    public static GestorUsuarios getInstance() {//para no estar haciendo instancias a cada rato en memoria
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public void insertUser(Usuario user) {
        MongoCollection<Document> collection = db.getCollection("usuarios");

        Document User = new Document();
        User.append("nombre", user.getNombre()).
                append("apellidos", user.getApellidos()).
                append("cedula", user.getCedula()).
                append("direccion", user.getDireccion()).
                append("contraseña", user.getContraseña()).
                append("telefono", user.getTelefono()).
                append("rol", user.isRol());

        collection.insertOne(User);
    }

    public String listUser() {
        Document doc = new Document();
        List<Document> users = new ArrayList<Document>();
        ArrayList<Document> usuarios = new ArrayList<>();
        MongoCollection<Document> collection = db.getCollection("usuarios");

        users = collection.find().projection(new Document()).into(new ArrayList<Document>());
        for (Document d : users) {
            usuarios.add(new Document().append("nombre", d.getString("nombre"))
                    .append("apellidos", d.getString("apellidos"))
                    .append("cedula", d.getString("cedula"))
                    .append("direccion", d.getString("direccion"))
                    .append("contraseña", d.getString("contraseña"))
                    .append("telefono", d.getString("telefono"))
                    .append("rol", d.getBoolean("rol"))
            );
        }
        doc.append("lista_usuarios", usuarios);
        return doc.toJson();
    }

    public String getUser(String ced) {
        List<Document> users = new ArrayList<Document>();
        Usuario user = new Usuario();

        MongoCollection<Document> collection = db.getCollection("usuarios");
        users = collection.find().projection(new Document()).into(new ArrayList<Document>());

        for (Document d : users) {
            if (d.get("cedula").equals(ced)) {
                user.setNombre(d.getString("nombre"));
                user.setApellidos(d.getString("apellidos"));
                user.setCedula(d.getString("cedula"));
                user.setDireccion(d.getString("direccion"));
                user.setContraseña(d.getString("contraseña"));
                user.setTelefono(d.getString("telefono"));
                user.setRol(d.getBoolean("rol"));
                return user.toString();
            }
        }
        return user.toString();
    }

    public void updateUser(String cedula, String direccion, String telefono) {
        MongoCollection<Document> collection = db.getCollection("usuarios");
        BasicDBObject query = new BasicDBObject();
        query.put("cedula", cedula);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("direccion", direccion);
        newDocument.append("telefono", telefono);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        collection.updateOne(query, updateObject);
    }

    public void updatePassword(String cedula, String newPass) {
        MongoCollection<Document> collection = db.getCollection("usuarios");
        BasicDBObject query = new BasicDBObject();
        query.put("cedula", cedula);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("contraseña", newPass);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        collection.updateOne(query, updateObject);
    }

//    public static void main(String[] args) {
//        GestorUsuarios prueba = getInstance();
////        
//
////
//        Usuario u = new Usuario("Leonardo", "Baldares Gómez", "304950273", "Cartago", "123", "86575093", true);
//        prueba.insertUser(u);
//////        
//        System.out.println(prueba.listUser());
//        System.out.println(prueba.getUser("105710421"));
//        System.out.println(prueba.getUser("304950273"));
//        prueba.updateUser("304950273", "Heredia", "11111111");
//        prueba.updatePassword("304950273", "leo123");
//    }
}
