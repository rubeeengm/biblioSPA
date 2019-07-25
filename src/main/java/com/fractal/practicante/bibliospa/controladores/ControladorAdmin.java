/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fractal.practicante.bibliospa.controladores;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.conexion.Conexion;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibros;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibrosDeAlumno;
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
 * @author user
 */
@WebServlet(name = "ControladorAdmin", urlPatterns = {"/ControladorAdmin"})
public class ControladorAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("ACCION");
        RequestDispatcher  requestDispatcher = null;
        HttpSession session=request.getSession();
        Conexion conexion = new Conexion();
        conexion.conectar();
        ArrayList<Libro> libros = new ArrayList();
        ModeloLibros modLibros = new ModeloLibros();
        String mensajeAdmin = "";
        
        if(session.getAttribute("Admin").equals('1')){
            switch(accion){
                case "vistaRegistroLibro":
                    requestDispatcher = getServletContext().getRequestDispatcher(
                        "/vistas/formularios/RegistroLibro.jsp"
                    );
                break;

                case "vistaAdmin":
                    requestDispatcher = getServletContext().getRequestDispatcher(
                        "/vistas/admin/Admin.jsp"
                    );
                    try {
                        libros = modLibros.obtenerTodos(conexion.getConexion());
                    } catch (SQLException ex) {
                        System.out.println("Error al recuperar todos los libros");
                    }
                    request.setAttribute("libros", libros);
                break;
                case "obtenerLibros":
                    try {
                        libros = modLibros.obtenerTodos(conexion.getConexion());
                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println("--------------------------");
                            System.out.println(libros.get(i).getId());
                            System.out.println(libros.get(i).getTitulo());
                            System.out.println(libros.get(i).getAutor());
                            System.out.println(libros.get(i).getNumPaginas());
                            System.out.println(libros.get(i).getEstado());
                            System.out.println(libros.get(i).getIsbn());
                            System.out.println("--------------------------");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error en la obtencion de libros");
                    }
                    break;

                case "eliminarLibro":
                    try {
                        modLibros.eliminar(conexion.getConexion(), Integer.parseInt(request.getParameter("idlibro")));
                        System.out.println("Se eliminó el libro");
                    } catch (SQLException ex) {
                        System.out.println("Error en la eliminacion del libro");
                    }
                    break;

                default:
                    break;
            }

            try (PrintWriter out = response.getWriter()) {
                if(requestDispatcher != null){
                    requestDispatcher.forward(request, response);
                }
                out.print(mensajeAdmin);
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
