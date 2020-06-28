package servlets;

import DAO.GestorOrden;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Pizza;
import modelo.orden;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author leoba
 */
@MultipartConfig

public class ServicioConfirmaOrden extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        StringBuilder resultado = new StringBuilder();
        GestorOrden o = GestorOrden.getInstance();

        try (PrintWriter out = response.getWriter()) {
            switch (opcion) {
                case 1: // Insertar Orden Mongo
                    HttpSession session = request.getSession(true);
                    String orden = request.getParameter("orden");
                    double total = Double.parseDouble(request.getParameter("total"));
                    String metodo = (String)request.getParameter("metodo");
                    if (!orden.isEmpty() && total != 0.0) {
                        JSONArray j = new JSONArray(orden);

                        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
                        ArrayList<String> extras = new ArrayList<>();
                        for (Object or : j) {

                            JSONObject obj = new JSONObject(or.toString());
                            if (obj.getString("tipo").equals("pizza")) {
                                pizzas.add(new Pizza(
                                        obj.getString("nombre"), 
                                        obj.getDouble("subtotal"), 
                                        null));
                            }
                            if (obj.getString("tipo").equals("extra")) {
                                extras.add((obj.getString("nombre") + " Precio: " + obj.getDouble("precio")));
                            }
                        }
                        String nombre = ((JSONObject)session.getAttribute("usuario")).getString("nombre");
                        String apellidos = ((JSONObject)session.getAttribute("usuario")).getString("apellidos");
                        
                        
                        String nombreCompleto = nombre + " " + apellidos;
                        
                        o.insertOrder(new orden(
                                ((JSONObject)session.getAttribute("usuario")).getString("cedula"),nombreCompleto,0, pizzas, extras, new Date(), 0, metodo, total)
                        );
                        
                        resultado.append("{\"result\": \"se realiza la compra con exito!\"}");
                        out.println(resultado);
                    }else{
                        resultado.append("{\"result\": \"no hay datos en la factura!\"}");
                        out.println(resultado);
                    }
                    break;
                case 2: // listar las ordenes
                    out.println(o.listOrder());
                    break;
                case 3: // actualizar el estado de una orden
                    int num = Integer.valueOf(request.getParameter("numOrden"));
                    int estado = Integer.valueOf(request.getParameter("estado"));
                    o.updateEstado(num, estado);
                    resultado.append("{\"result\": \"Exito\"}");
                    out.println(resultado);
                    break;
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
