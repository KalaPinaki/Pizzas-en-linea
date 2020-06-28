package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Ingredientes;
import modelo.Pizza;
import modelo.orden;
import org.bson.Document;
import org.json.JSONObject;

public class GestorOrden {

    private static GestorOrden instancia = null;
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    public GestorOrden() {
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

    public static GestorOrden getInstance() {
        if (instancia == null) {
            instancia = new GestorOrden();
        }
        return instancia;
    }

    public void insertOrder(orden or) {
        MongoCollection<Document> collection = db.getCollection("ordenes");

        ArrayList<Document> extras = new ArrayList<>();
        for (String s : or.getExtras()) {
            extras.add(new Document("nombre", s));
        }

        ArrayList<Document> pizzas = new ArrayList<>();
        for (Pizza s : or.getPizzas()) {
            pizzas.add(new Document().append("nombre", s.getNombre()).
                    append("precio", s.getPrecio()));
        }
        Document Order = new Document();
        Order.append("ced cliente", or.getCedula()).
                append("nomb cliente", or.getNombreCompleto()).
                append("num orden", getConsecutivo() + 1).
                append("fecha", or.getFecha()).
                append("pizzas", pizzas).
                append("extras", extras).
                append("estado", or.getEstado()).
                append("metodo pago", or.getMetodo_pago()).
                append("precio", or.getPrecio());

        collection.insertOne(Order);
    }

    
    public String listOrder() {
        List<Document> Orders = new ArrayList<Document>();
        ArrayList<Document> ordenes = new ArrayList<>();
        MongoCollection<Document> collection = db.getCollection("ordenes");

        Orders = collection.find().projection(new Document()).into(new ArrayList<Document>());
        for (Document o : Orders) {
            ArrayList<Document> pizzas = (ArrayList<Document>) o.get("pizzas");
            ArrayList<Document> extra = (ArrayList<Document>) o.get("extras");

            ordenes.add(new Document().append("ced cliente",o.getString("ced cliente")).
                        append("nomb cliente", o.getString("nomb cliente")).
                        append("num orden", o.getInteger("num orden")).
                        append("fecha", o.getDate("fecha").toString()).
                        append("pizzas", pizzas).append("extras", extra).
                        append("estado", o.getInteger("estado")).
                        append("metodo pago", o.getString("metodo pago")).
                        append("precio", o.getDouble("precio")));
        }
        
        Document lista = new Document("Lista_Ordenes", ordenes);
        return lista.toJson();
    }

    public String getOrder(int num) {
        List<Document> orders = new ArrayList<Document>();
        Document order = new Document();

        MongoCollection<Document> collection = db.getCollection("ordenes");
        orders = collection.find().projection(new Document()).into(new ArrayList<Document>());

        for (Document d : orders) {
            if (d.get("num orden").equals(num)) {
                order.append("ced cliente",d.getString("ced cliente")).
                        append("nomb cliente", d.getString("nomb cliente")).
                        append("num orden", d.getInteger("num orden")).
                        append("fecha", d.getDate("fecha").toString());
                
                ArrayList<Document> pizzas = (ArrayList<Document>) d.get("pizzas");
                order.append("pizzas", pizzas);

                ArrayList<Document> extra = (ArrayList<Document>) d.get("extras");
                order.append("extras", extra);
                order.append("estado", d.getInteger("estado")).
                        append("metodo pago", d.getString("metodo pago")).
                        append("precio", d.getDouble("precio"));

                return order.toJson();
            }
        }
        return order.toJson();
    }

    public void updateEstado(int num, int estado) {
        MongoCollection<Document> collection = db.getCollection("ordenes");
        BasicDBObject query = new BasicDBObject();
        query.put("num orden", num);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("estado", estado);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        collection.updateOne(query, updateObject);
    }

    public int getConsecutivo() {
        int r = 0;
        try {
            MongoCollection<Document> colFacturas = db.getCollection("ordenes");
            Document d = colFacturas.find().sort(new Document("num orden", -1)).first();
            if (d != null) {
                System.out.println(d.toString());
                r = d.getInteger("num orden");
            }

        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

//    public static void main(String[] args) {
//        GestorOrden prueba = getInstance();
//        GestorPizzas pizza = GestorPizzas.getInstance();
//        GestorBebidas extra = GestorBebidas.getInstance();
//        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
//        ArrayList<String> extras = new ArrayList<String>();
//        
//        JSONObject pizzasAux1 = new JSONObject(pizza.buscarPizza("Suprema"));
//        JSONObject pizzasAux2 = new JSONObject(pizza.buscarPizza("Napolitana"));
//        JSONObject extrasAux1 = new JSONObject(extra.getDrink("Coca-cola"));
//        pizzas.add(new Pizza(pizzasAux1.getString("Nombre"),pizzasAux1.getDouble("Precio"), null ));
//        pizzas.add(new Pizza(pizzasAux2.getString("Nombre"),pizzasAux2.getDouble("Precio"), null ));
//        extras.add(extrasAux1.getString("nombre"));
//        orden u = new orden("304950273", "Leonardo Baldares Gómez", 0, pizzas, extras, new Date(), 0, "contado", 20000);
//        prueba.insertOrder(u);
////        orden u2 = new orden("111111111", "Leonardo", 0, pizzas, extras, new Date(), 0, "contado", 20000);
////        prueba.insertOrder(u2);
//        System.out.println(prueba.listOrder());
//        System.out.println(prueba.getOrder(1));
//        prueba.updateEstado(1, 3);
//        System.out.println(prueba.getOrder(1).toString());
//    }
}
