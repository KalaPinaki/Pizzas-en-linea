package servlets;

import PizzaEnLinea.modelo.usuario.ServicioUsuario_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author leoba
 */
@MultipartConfig

public class ServicioUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        StringBuilder resultado = new StringBuilder();
        
        ServicioUsuario_Service su = new ServicioUsuario_Service();
        PizzaEnLinea.modelo.usuario.ServicioUsuario u = su.getServicioUsuarioPort();
        
        JSONObject usuario = null;

        try (PrintWriter out = response.getWriter()) {
            switch (opcion) {
                case 1: // Validar Login
                    String user = (String) request.getParameter("user");
                    String pass = (String) request.getParameter("password");

                    if (!user.isEmpty() && !pass.isEmpty()) {

                        usuario = new JSONObject(u.getUser(user));

                        if (!usuario.isEmpty() && usuario.getString("contraseña").equals(pass)) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("usuario", usuario);
                            session.setMaxInactiveInterval(60 * 10);

                            resultado.append("{\"result\": \"funciona\"");
                            resultado.append(",\"rol\": \"" + usuario.getBoolean("rol") +"\"}");
                            out.print(resultado);
                        } else {
                            resultado.append("{\"result\": \"no se encontro el usuario\"}");
                            System.out.print(resultado);
                            out.print(resultado);
                        }
                    } else {
                        resultado.append("{\"result\": \"rellene los campos solicitados\"}");
                        System.out.print(resultado);
                        out.print(resultado);
                    }
                    break;
                case 2: // Cambio de contraseña
                    String user2 = (String) request.getParameter("user");
                    String pass2 = (String) request.getParameter("password");
                    if (!user2.isEmpty() && !pass2.isEmpty()) {
                        usuario = new JSONObject(u.getUser(user2));
                        
                        if(!usuario.isEmpty()){
                            u.updatePassword(user2, pass2);
                            resultado.append("{\"result\": \"Cambio de contraseña exitoso!\"}");
                            out.print(resultado);
                        }else{
                            resultado.append("{\"result\": \"Usuario no registrado!\"}");
                            out.print(resultado);
                        }
                    }else {
                        resultado.append("{\"result\": \"rellene los campos solicitados!\"}");
                        System.out.print(resultado);
                        out.print(resultado);
                    }
                    break;
                case 3: // registrar usuario
                    String nombre = (String) request.getParameter("nombre");
                    String apellidos = (String) request.getParameter("apellidos");
                    String cedula = (String) request.getParameter("cedula");
                    String direccion = (String) request.getParameter("direccion");
                    String pass3 = (String) request.getParameter("password");
                    String telefono = (String) request.getParameter("telefono");
                    
                    if(!nombre.isEmpty() && !apellidos.isEmpty() && !cedula.isEmpty() &&
                            !direccion.isEmpty() && !pass3.isEmpty() && !telefono.isEmpty()){
                        
                        usuario = new JSONObject(u.getUser(cedula));
                        if(usuario.getString("cedula").isEmpty()){
                            u.insertUser(nombre, apellidos, cedula, direccion, pass3, telefono, "false");
                            resultado.append("{\"result\": \"Usuario se registro con exitoso!\"}");
                            out.print(resultado);
                        }else{
                            resultado.append("{\"result\": \"Usuario ya esta registrado!\"}");
                            out.print(resultado);
                        }
                    }else{
                        resultado.append("{\"result\": \"rellene los campos solicitados!\"}");
                        System.out.print(resultado);
                        out.print(resultado);
                    }
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
