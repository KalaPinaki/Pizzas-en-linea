/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utiles.JSONUtils;
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
import modelo.Pizza;
import org.bson.Document;
import org.json.JSONObject;

/**
 *
 * @author Samanta
 */
public class GestorPizzas implements Serializable {

    private static GestorPizzas instancia = null;//para singleton
    private static MongoClient mongo = null;
    private String baseDatos;
    MongoDatabase db;

    private GestorPizzas() {//para crear la conexion como un cliente de mongo
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

    public static GestorPizzas getInstance() {
        if (instancia == null) {
            instancia = new GestorPizzas();
        }
        return instancia;
    }

    //insertar una pizza
    public boolean insertarPizza(Pizza p) {
        try {
            MongoCollection<Document> colPizzas = db.getCollection("pizzas");
            Document doc = new Document();
            ArrayList<Document> ingr = new ArrayList<>();
            for (String s : p.getIngredientes()) {
                System.out.println(s);
                ingr.add(new Document("nombre", s));
            }
            doc.append("nombre", p.getNombre()).append("precioBase", p.getPrecio()).append("ingredientes", ingr);
            colPizzas.insertOne(doc);
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    //listar todas las pizzas disponibles
    public String listarPizzas() {
        MongoCollection<Document> colProductos = db.getCollection("pizzas");
        FindIterable<Document> cursor = colProductos.find();
        Document listaPizzas = new Document();
        List<Document> lista = new ArrayList<>();
        
        ArrayList<String> ingred = null;
        String nomPizza = null;
        double precio = 0.0;
        try {
            for (Document doc : cursor) {
                //System.out.println(doc.toString());
                nomPizza = doc.get("nombre").toString();
                precio = Double.valueOf(doc.get("precioBase").toString());
                ArrayList<Document> ingredAux = (ArrayList<Document>) doc.get("ingredientes");
                //System.out.println(ingredAux.toString());
                ingred = new ArrayList<>();
                for (Document obj : ingredAux) {
                    //System.out.println(obj.toString());
                    ingred.add(obj.get("nombre").toString());
                }
                //System.out.println(ingred.toString());
                //Pizza pizza = new Pizza(nomPizza, precio, ingred);
                lista.add(new Document().append("nombre", nomPizza).append("precio", precio).append("ingredientes", ingredAux));
            }
            listaPizzas.append("lista_pizzas", lista);
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaPizzas.toJson();
    }

    //buscar una pizza
    public String buscarPizza(String nombre) {
        MongoCollection<Document> colPizzas = db.getCollection("pizzas");
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("nombre", nombre);
        FindIterable<Document> cursor = colPizzas.find(filtro);
        Document pizza = new Document();
        for (Document r : cursor) {
            ArrayList<Document> ingredientes = (ArrayList<Document>) r.get("ingredientes");
             pizza.append("Nombre", r.getString("nombre"));
            pizza.append("Precio", r.getDouble("precioBase"));
            pizza.append("ingredientes", ingredientes);
        }
                
        return pizza.toJson();
    }

    //eliminar una pizza
    public boolean eliminarPizza(String nombre) {
        try {
            MongoCollection<Document> colPizzas = db.getCollection("pizzas");
            colPizzas.deleteOne(eq("nombre", nombre));
            return true;
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    //actualizar una pizza
    public void actualizarPizza(String nom, Pizza p) {
        try {
            MongoCollection<Document> colPizzas = db.getCollection("pizzas");
            Document doc = new Document();
            ArrayList<Document> ingr = new ArrayList<>();
            for (String s : p.getIngredientes()) {
                System.out.println(s);
                ingr.add(new Document("nombre", s));
            }
            doc.append("nombre", p.getNombre()).append("precioBase", p.getPrecio()).append("ingredientes", ingr);
            BasicDBObject updateQuery = new BasicDBObject().append("$set", doc);
            BasicDBObject filtro = new BasicDBObject();//filtro para obtener el numero de factura
            filtro.put("nombre", nom);

            UpdateResult resultTotal = colPizzas.updateOne(filtro, updateQuery);
            if (resultTotal.getMatchedCount() == 0) {//verifica que se hizo la actualizacion
                System.out.println("nop");
            }
            System.out.println("yep");
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

//    public static void main(String[] args) {
//        GestorPizzas gP = GestorPizzas.getInstance();
//        System.out.println(gP.listarPizzas());
//        ArrayList<String> ingredientes = new ArrayList<>();
//        ingredientes.add("ajo");
//        ingredientes.add("queso");
//        System.out.println(gP.insertarPizza(new Pizza("Cheese", 1500.0, ingredientes)));
//        ingredientes.add("quesox2");
//        gP.actualizarPizza("Cheese", new Pizza("Cheese", 1500.0, ingredientes));
//       System.out.println(gP.eliminarPizza("Cheese"));
//        System.out.println(gP.buscarPizza("Napolitana"));
//
//    }

}
