package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.bebidas;
import org.bson.Document;

public class GestorBebidas implements Serializable{

    private static GestorBebidas instancia = null;
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorBebidas() {
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

    public static GestorBebidas getInstance() {
        if (instancia == null) {
            instancia = new GestorBebidas();
        }
        return instancia;
    }

    public boolean insertDrink(bebidas b) {
        try {
            MongoCollection<Document> collection = db.getCollection("bebidas");
            Document doc = new Document();
            doc.append("nombre", b.getNombre()).append("precio", b.getPrecio());
            collection.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public boolean deleteDrink(String nombre) {
        try {
            MongoCollection<Document> colBebidas = db.getCollection("bebidas");
            colBebidas.deleteOne(eq("nombre", nombre));
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public boolean updateDrink(String nombre, String campo, String value) {
        try {
            MongoCollection<Document> collection = db.getCollection("bebidas");

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

    public String listDrinks() {
        List<Document> drinks = new ArrayList<Document>();
        List<Document> drink = new ArrayList<Document>();
        Document bebidas = new Document();
        MongoCollection<Document> collection = db.getCollection("bebidas");
        drinks = collection.find().projection(new Document()).into(new ArrayList<Document>());
        
        for(Document b : drinks){
            drink.add(new Document().
                    append("nombre", b.getString("nombre")).
                    append("precio", b.getDouble("precio")));
        }
        
        bebidas.append("Lista_Bebidas", drink);
        
        return bebidas.toJson();
    }

    public String getDrink(String nom) {
        List<Document> drinks = new ArrayList<Document>();
        bebidas bebidas = new bebidas();

        MongoCollection<Document> collection = db.getCollection("bebidas");
        drinks = collection.find().projection(new Document()).into(new ArrayList<Document>());

        for (Document d : drinks) {
            if (d.get("nombre").equals(nom)) {
                bebidas.setNombre((String)d.get("nombre"));
                bebidas.setPrecio((double)d.get("precio"));
                return bebidas.toString();
            }
        }
        return bebidas.toString();
    }
//
//    public static void main(String[] args) {
//        GestorBebidas prueba = getInstance();
//////
//        System.out.println(prueba.listDrinks());
//        System.out.println(prueba.getDrink("Coca-cola"));
////        System.out.println(prueba.deleteDrink("Coca-cola"));
////        bebidas b = new bebidas("zarza", 2000);
////        prueba.insertDrink(b);
////        System.out.println(prueba.getDrink("zarza").toString());
////        prueba.updateDrink("zarza", "precio", String.valueOf(1500));
////        System.out.println(prueba.getDrink("zarza").toString());
////        prueba.deleteDrink("zarza");
////        System.out.println(prueba.getDrink("zarza").toString());
//    }

}
