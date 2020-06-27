package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import modelo.complementos;
import org.bson.Document;

public class GestorComplementos {

    private static GestorComplementos instancia = null;
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorComplementos() {
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

    public static GestorComplementos getInstance() {
        if (instancia == null) {
            instancia = new GestorComplementos();
        }
        return instancia;
    }

    //insertar complemento
    public boolean insertComplemet(complementos p) {
        try {
            MongoCollection<Document> collection = db.getCollection("complementos");
            Document doc = new Document();
            doc.append("nombre", p.getNombre()).append("precio", p.getPrecio());
            collection.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public String listComplements() {
        List<Document> complements = new ArrayList<Document>();
        ArrayList<Document> complementos = new ArrayList<>();
        MongoCollection<Document> collection = db.getCollection("complementos");
        complements = collection.find().projection(new Document()).into(new ArrayList<Document>());

        for (Document d : complements) {
            complementos.add(new Document().
                    append("nombre",(String) d.get("nombre")).
                    append("precio",(double) d.get("precio")));
        }

        Document lista = new Document("Lista_Complementos",complementos);
        return lista.toJson();
    }

    public String getComplement(String nom) {
        List<Document> complements = new ArrayList<Document>();
        complementos complemento = new complementos();
        MongoCollection<Document> collection = db.getCollection("complementos");
        complements = collection.find().projection(new Document()).into(new ArrayList<Document>());

        for (Document d : complements) {
            if (d.get("nombre").equals(nom)) {
                complemento.setNombre((String) d.get("nombre"));
                complemento.setPrecio((double) d.get("precio"));
                return complemento.toString();
            }
        }
        return complemento.toString();
    }

    //eliminar una complemento
    public boolean deleteComplement(String nombre) {
        try {
            MongoCollection<Document> colPizzas = db.getCollection("complementos");
            colPizzas.deleteOne(eq("nombre", nombre));
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    //actualizar campos
    public boolean updateComplements(String nombre, String campo, String value) {
        try {
            MongoCollection<Document> collection = db.getCollection("complementos");

            BasicDBObject filtro = new BasicDBObject();//filtro para obtener el numero de factura
            filtro.put("nombre", nombre);

            BasicDBObject campos = new BasicDBObject();
            campos.append(campo, value);
            //System.out.println(campos);
            //para poder usar el $set
            BasicDBObject updateQuery = new BasicDBObject().append("$set", campos);
            UpdateResult resultTotal = collection.updateOne(filtro, updateQuery);
            if (resultTotal.getMatchedCount() == 0) {//verifica que se hizo la inserción
                System.out.println("nop");
            }
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

//    public static void main(String[] args) {
//        GestorComplementos prueba = getInstance();
////
//        System.out.println(prueba.listComplements());
//        System.out.println(prueba.getComplement("Pan de ajo"));
////        System.out.println(prueba.deleteComplement("Pan de ajo"));
////        System.out.println(prueba.insertComplemet(new complementos("Pan de ajo", 2000.0)));
////        System.out.println(prueba.updateComplements("Pan de ajo", "precio", String.valueOf(1500.0)));
////        System.out.println(prueba.updateComplements("Pan de ajo", "nombre", "Pan de ajitos"));
//
//
//    }
}
