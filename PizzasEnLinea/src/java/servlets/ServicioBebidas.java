package servlets;

import PizzaEnLinea.modelo.bebida.ServicioBebidas_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author leoba
 */
@MultipartConfig
public class ServicioBebidas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("applicatio/json;charset=UTF-8");

        ServicioBebidas_Service sb = new ServicioBebidas_Service();
        PizzaEnLinea.modelo.bebida.ServicioBebidas b = sb.getServicioBebidasPort();

        try (PrintWriter out = response.getWriter()) {
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            StringBuilder resultado = new StringBuilder();
            JSONObject bebida = null;
            switch (opcion) {
                case 1: // listar bebidas
                    String listaBebidas = b.listDrinks();
                    out.println(listaBebidas);
                    break;
                case 2: //eliminar una bebida
                    String nomBeb = request.getParameter("nomBeb");
                    if( b.deleteDrink(nomBeb).equals("exito!") ){
                        resultado.append("{\"result\": \"Bebida eliminada correctamente\"}");
                    }else{
                        resultado.append("{\"result\": \"Ocurrió un error inseperado\"}");
                    }
                    out.println(resultado);
                    break;
                case 3: //insertar una bebida 
                    String nomBeb2 = request.getParameter("nombreD");
                    String precioBeb2 = request.getParameter("precioD");
                    if (!nomBeb2.isEmpty() && !precioBeb2.isEmpty()) {
                        //verificar que no existe ya esa bebida
                        bebida = new JSONObject(b.getDrink(nomBeb2));
                        if (bebida.getString("nombre").equals("null")) {
                            if (b.insertDrink(nomBeb2, precioBeb2).equals("exito!")) {
                                resultado.append("{\"result\": \"Exito\"}");
                            } else {
                                resultado.append("{\"result\": \"Ocurrió un error inesperado\"}");
                            }
                        } else {
                            resultado.append("{\"result\": \"Ya existe ese extra\"}");
                        }
                    } else {
                        resultado.append("{\"result\": \"Error: Campo(s) vacios\"}");
                    }
                    out.print(resultado);
                    break;

                case 4: //actualizar un complemento 
                    String oldName = request.getParameter("oldName");
                    String nomBeb3 = request.getParameter("nombreD");
                    String precioBeb3 = request.getParameter("precioD");

                    if (!oldName.isEmpty()
                            && !nomBeb3.isEmpty() && !precioBeb3.isEmpty()) {
                        if (b.updateDrink(oldName, nomBeb3, precioBeb3).equals("exito!")) {
                            resultado.append("{\"result\": \"Exito\"}");
                        } else {
                            resultado.append("{\"result\": \"Ocurrió un error inesperado\"}");
                        }
                    } else {
                        resultado.append("{\"result\": \"Error: Campo(s) vacios\"}");
                    }

                    out.print(resultado);
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
