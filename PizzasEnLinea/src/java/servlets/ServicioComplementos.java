package servlets;

import PizzaEnLinea.modelo.complemento.ServicioComplemento;
import PizzaEnLinea.modelo.complemento.ServicioComplemento_Service;
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
public class ServicioComplementos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        ServicioComplemento_Service sc = new ServicioComplemento_Service();
        ServicioComplemento c = sc.getServicioComplementoPort();

        try (PrintWriter out = response.getWriter()) {
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            StringBuilder resultado = new StringBuilder();
            JSONObject complemento = null;
            switch (opcion) {
                case 1: //listar
                    String listaComplementos = c.listComplements();
                    out.println(listaComplementos);
                    break;
                case 2: //eliminar un complemento
                    String nomComp = request.getParameter("nomComplement");
                    if (c.deleteComplement(nomComp).equals("exito!")) {
                        resultado.append("{\"result\": \"Complemento eliminado correctamente\"}");
                    } else {
                        resultado.append("{\"result\": \"Ocurrió un error inseperado\"}");
                    }
                    out.println(resultado);
                    break;
                case 3: //insertar un complemento 
                    String nomCom2 = request.getParameter("nombreCom");
                    String precioCom2 = request.getParameter("precioCom");
                    if (!nomCom2.isEmpty() && !precioCom2.isEmpty()) {
                        //verificar que no existe ya ese ingrediente
                        complemento = new JSONObject(c.getComplement(nomCom2));
                        if (complemento.getString("nombre").equals("null")) {
                            if (c.insertComplemet(nomCom2, precioCom2).equals("exito!")) {
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
                    String nomCom3 = request.getParameter("nombreCom");
                    String precioCom3 = request.getParameter("precioCom");

                    if (!oldName.isEmpty()
                            && !nomCom3.isEmpty() && !precioCom3.isEmpty()) {
                        if (c.updateComplements(oldName, nomCom3, precioCom3).equals("exito!")) {
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
