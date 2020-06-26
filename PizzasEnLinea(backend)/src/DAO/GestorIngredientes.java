/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Ingredientes;
import org.bson.Document;

/**
 *
 * @author Samanta
 */
public class GestorIngredientes implements Serializable {

    private static GestorIngredientes instancia = null;//para singleton
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorIngredientes() {//para crear la conexion como un cliente de mongo
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

    public static GestorIngredientes getInstance() {//para no estar haciendo instancias a cada rato en memoria
        if (instancia == null) {
            instancia = new GestorIngredientes();
        }
        return instancia;
    }

    public boolean insertIngredientes(Ingredientes i) {
        try {
            MongoCollection<Document> collection = db.getCollection("ingredientes");
            Document doc = new Document();
            doc.append("nombre", i.getNombre()).append("precio", i.getPrecio());
            collection.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public boolean deleteIngrediente(String nombre) {
        try {
            MongoCollection<Document> colIngrediente = db.getCollection("ingredientes");
            colIngrediente.deleteOne(eq("nombre", nombre));
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public boolean updateIngrediente(String nombre, String campo, String value) {
        try {
            MongoCollection<Document> collection = db.getCollection("ingredientes");

            BasicDBObject filtro = new BasicDBObject();
            filtro.put("nombre", nombre);

            BasicDBObject campos = new BasicDBObject();
            campos.append(campo, value);
            BasicDBObject updateQuery = new BasicDBObject().append("$set", campos);
            UpdateResult resultTotal = collection.updateOne(filtro, updateQuery);
            if (resultTotal.getMatchedCount() == 0) {
                System.out.println("nop");
            }
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    //listar los ingredientes actuales
    public String listarIngredientes() {
        List<Document> listaIngredientes = new ArrayList<>();
        Document Ingredientes = new Document();
        Ingredientes ing = null;
        try {
            MongoCollection<Document> colIngredientes = db.getCollection("ingredientes");
            FindIterable<Document> cursor = colIngredientes.find();
            for (Document d : cursor) {
                listaIngredientes.add(new Document().
                        append("nombre",  d.getString("nombre")).
                        append("precio", d.getDouble("precio")));
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        Ingredientes.append("Lista_Ingredientes", listaIngredientes);
        return Ingredientes.toJson();
    }

    //buscar un ingrediente (para sacar el precio)...
    //NOTA: puedo devolver solo el precio o solo el nombre
    public String buscarIngrediente(String nombre) {
        MongoCollection<Document> colProductos = db.getCollection("ingredientes");
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("nombre", nombre);
        FindIterable<Document> cursor = colProductos.find(filtro);
        Ingredientes i = null;
        for (Document doc : cursor) {
            try {
                String nombre1 = doc.getString("nombre");
                double precio1 = doc.getDouble("precio");
                i = new Ingredientes(precio1, nombre1);
            } catch (Exception ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
        }
        return i.toString();
    }

//    public static void main(String[] args) {
//        GestorIngredientes prueba = getInstance();
////        System.out.println(prueba.listarIngredientes());
//        System.out.println(prueba.buscarIngrediente("piña"));
//
////        Ingredientes b = new Ingredientes(2000,"zarza");
////        prueba.insertIngredientes(b);
////        System.out.println(prueba.buscarIngrediente("zarza").toString());
////        prueba.updateIngrediente("zarza", "precio", String.valueOf(1500));
////        System.out.println(prueba.buscarIngrediente("zarza").toString());
////        prueba.deleteIngrediente("zarza");
////        System.out.println(prueba.buscarIngrediente("zarza").toString());

//{"precio":200,"_id":"5ef02961ba84d47ba5d34972","nombre":"piña"}
//{"precio":200.0, "nombre":"piña"}
//    }
}
