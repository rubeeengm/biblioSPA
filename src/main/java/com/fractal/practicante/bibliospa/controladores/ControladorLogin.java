package com.fractal.practicante.bibliospa.controladores;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import com.fractal.practicante.bibliospa.modelo.conexion.Conexion;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibros;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloUsuarios;
import com.fractal.practicante.bibliospa.modelo.validaciones.ValidacionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Ruben Gustavo Garcia Malaga
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("ACCION");
        RequestDispatcher requestDispatcher = null;
        HttpSession session = request.getSession();
        Conexion conexion = new Conexion();
        conexion.conectar();
        String mensajeLogin = "";

        switch (accion) {
            case "vistaRegistrar":
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/formularios/RegistroAlumno.jsp"
                );
                break;

            case "vistaLogin":
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/login/Login.jsp"
                );
                session.setAttribute("Admin", '0');
                break;

            case "vistaAdmin":
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/admin/Admin.jsp"
                );
                ArrayList<Libro> libros = new ArrayList();
                ModeloLibros ml = new ModeloLibros();
                try {
                    libros = ml.obtenerTodos(conexion.getConexion());
                } catch (SQLException ex) {
                    System.out.println("Error al recuperar todos los libros");
                }
                request.setAttribute("libros", libros);
                break;

            case "login":
                String usuario = request.getParameter("usuario");
                String contrasenia = request.getParameter("contrasenia");

                Usuario objetoUsuario = new Usuario(usuario, contrasenia);

                ValidacionUsuario vu = new ValidacionUsuario();
                ModeloUsuarios mu = new ModeloUsuarios();

                if (vu.validarNulos(objetoUsuario)) {
                    if (vu.validarVacios(objetoUsuario)) {
                        try {
                            objetoUsuario = mu.verificarLogin(
                                conexion.getConexion(),
                                objetoUsuario
                            );
                            conexion.desconectar();

                            if (objetoUsuario.getId() == 0) {
                                mensajeLogin = "LI";
                            } else if (objetoUsuario.getAdmin() == '1') {
                                mensajeLogin = "LA";
                                session.setAttribute("Admin", '1');
                            } else {
                                mensajeLogin = "LC";
                                HttpSession misession
                                    = request.getSession(true);
                                misession.setAttribute(
                                    "idUsuario", objetoUsuario.getId()
                                );
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ControladorLogin.class.getName()).
                                log(Level.SEVERE, null, ex
                                );
                        }
                    } else {
                        mensajeLogin = "Campos vacios";
                    }
                } else {
                    mensajeLogin = "Campos nulos";
                }
                break;

            default:
                System.out.println("Error de ruta");
                break;
        }

        try (PrintWriter out = response.getWriter()) {
            if (requestDispatcher != null) {
                requestDispatcher.forward(request, response);
            }
            out.print(mensajeLogin);
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
