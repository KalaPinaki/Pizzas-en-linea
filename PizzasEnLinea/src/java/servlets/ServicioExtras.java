package servlets;

import PizzaEnLinea.modelo.ingrediente.ServicioIngredientes;
import PizzaEnLinea.modelo.ingrediente.ServicioIngredientes_Service;
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
public class ServicioExtras extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        ServicioIngredientes_Service si = new ServicioIngredientes_Service();
        ServicioIngredientes i = si.getServicioIngredientesPort();

        try (PrintWriter out = response.getWriter()) {

            int opcion = Integer.parseInt(request.getParameter("opcion"));
            StringBuilder resultado = new StringBuilder();
            JSONObject ingrediente = null;

            switch (opcion) {
                case 1://listar extras
                    String ListaExtras = i.listarIngredientes();
                    out.println(ListaExtras);
                    break;
                case 2: //eliminar extras
                    String nomExtra = request.getParameter("nomExt");
                    if (i.deleteIngrediente(nomExtra).equals("exito!")) {
                        resultado.append("{\"result\": \"Extra eliminado correctamente\"}");
                    } else {
                        resultado.append("{\"result\": \"Ocurrió un error inseperado\"}");
                    }
                    out.println(resultado);
                    break;
                case 3: //insertar un ingrediente (o extra)
                    String nomExtra2 = request.getParameter("nombreEx");
                    String precioExtra2 = request.getParameter("precioEx");
                    if (!nomExtra2.isEmpty() && !precioExtra2.isEmpty()) {
                        //verificar que no existe ya ese ingrediente
                        String aux = i.buscarIngrediente(nomExtra2);
                        if (!aux.equals("fallo!")) {//encontró una coincidencia
                            ingrediente = new JSONObject(i.buscarIngrediente(nomExtra2));
                            if (ingrediente.getString("nombre").isEmpty()) {
                                if (i.insertIngredientes(nomExtra2, precioExtra2).equals("exito!")) {
                                    resultado.append("{\"result\": \"Exito\"}");
                                } else {
                                    resultado.append("{\"result\": \"Ocurrió un error inesperado\"}");
                                }
                            } else {
                                resultado.append("{\"result\": \"Ya existe ese extra\"}");
                            }
                        } else {//falló al recuperar el objeto...signiifica que no existe, se puede crear
                            if (i.insertIngredientes(nomExtra2, precioExtra2).equals("exito!")) {
                                resultado.append("{\"result\": \"Exito\"}");
                            } else {
                                resultado.append("{\"result\": \"Ocurrió un error inesperado\"}");
                            }
                        }
                    } else {
                        resultado.append("{\"result\": \"Erro: Campo(s) vacios\"}");
                    }
                    out.print(resultado);
                    break;
                case 4: //actualizar un ingrediente 
                    String oldName = request.getParameter("oldName");
                    String nomExtra3 = request.getParameter("nombreEx");
                    String precioExtra3 = request.getParameter("precioEx");
                    if(!oldName.isEmpty() && !nomExtra3.isEmpty() && !precioExtra3.isEmpty()){
                        if (i.updateIngrediente(oldName, nomExtra3,precioExtra3).equals("exito!")) {
                                resultado.append("{\"result\": \"Exito\"}");
                            } else {
                                resultado.append("{\"result\": \"Ocurrió un error inesperado\"}");
                            }
                    }else{
                        resultado.append("{\"result\": \"Erro: Campo(s) vacios\"}");
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
