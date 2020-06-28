/*
    GestorMetodoPago.java

    EIF209 - Programación 4 – Proyecto #2
    Junio 2020

    Autores:
    - 116630575 Dafhnne Alfaro
    - 304950273 Leonardo Baldares
*/
package DAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class GestorMetodoPago implements Serializable {

    private static GestorMetodoPago instancia = null;//para singleton
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorMetodoPago() {//para crear la conexion como un cliente de mongo
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

    public static GestorMetodoPago getInstance() {
        if (instancia == null) {
            instancia = new GestorMetodoPago();
        }
        return instancia;
    }

    //listar los metodos de pago actuales actuales
    public String listarMetodosPago() {
        
        List<Document> metodosPago = new ArrayList<>();
        try {
            MongoCollection<Document> colMetodos= db.getCollection("metodosPago");
            FindIterable<Document> cursor = colMetodos.find();
            for (Document d: cursor){
                System.out.println(d.toString());
                String nombre = d.get("nombre").toString();
                metodosPago.add(new Document().append("nombre", nombre));
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return new Document().append("lista_metodosPago", metodosPago).toJson();
    }
    
    
//    public static void main(String[] args) {
//        GestorMetodoPago gMP = GestorMetodoPago.getInstance();
//        System.out.println(gMP.listarMetodosPago());
//    }

}
