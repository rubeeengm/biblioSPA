/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fractal.practicante.bibliospa.controladores;

import com.fractal.practicante.bibliospa.modelo.beans.Alumno;
import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import com.fractal.practicante.bibliospa.modelo.conexion.Conexion;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibros;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloTransacciones;
import com.fractal.practicante.bibliospa.modelo.validaciones.ValidacionAlumno;
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
 * @author Melissa Gpe. Pérez Cabrera <perezc.melissa@gmail.com>
 */
@WebServlet(name = "ControladorAlumno", urlPatterns = {"/ControladorAlumno"})
public class ControladorAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        RequestDispatcher requestDispatcher = null;
        Conexion conexion = new Conexion();
        conexion.conectar();
        String mensajeControladorAlumno = "";
        ModeloLibros ml;
        ArrayList<Libro> librosAlumno = null;

        switch (accion) {
            case "registrar":
                String nombre = request.getParameter("nombre");
                String apellidoPaterno = request.getParameter(
                    "apellidoPaterno"
                );
                String apellidoMaterno = request.getParameter(
                    "apellidoMaterno"
                );
                String telefono = request.getParameter("telefono");
                String dni = request.getParameter("dni");
                String nombreUsuario = request.getParameter("nombreUsuario");
                String contrasenia = request.getParameter("contrasenia");

                Alumno alumnoObjeto = new Alumno(
                    nombre, apellidoPaterno, apellidoMaterno, telefono, dni
                );
                
                Usuario usuarioObjeto = new Usuario(
                    nombreUsuario, contrasenia
                );

                ValidacionAlumno valAl = new ValidacionAlumno();
                ValidacionUsuario valUs = new ValidacionUsuario();

                ModeloTransacciones mt = new ModeloTransacciones();

                if (valAl.validarNulos(alumnoObjeto)
                    && valUs.validarNulos(usuarioObjeto)) {
                    if (valAl.validacionTotal(alumnoObjeto)
                        && valUs.validacionTotal(usuarioObjeto)) {

                        mt.insertarAlumno(conexion.getConexion(), alumnoObjeto, usuarioObjeto);
                        conexion.desconectar();
                        mensajeControladorAlumno = "success";

                    } else {
                        mensajeControladorAlumno = "error_data";
                    }
                } else {
                    mensajeControladorAlumno = "empty_data";
                }

                break;

            case "vistaLibrosRegistrados":
                ml = new ModeloLibros();
                
                try {
                    librosAlumno = ml.obtenerTodos(conexion.getConexion());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                conexion.desconectar();
                
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/alumnos/LibrosRegistrados.jsp"
                );
                request.setAttribute("listaLibrosRegistrados", librosAlumno);
                break;

            case "vistaLibrosAlumno":
                ml = new ModeloLibros();
                HttpSession misession = (HttpSession) request.getSession();
                int idUsuarioSession = (int) misession.getAttribute("idUsuario");
                
                System.out.println(idUsuarioSession);
                
                try {
                    librosAlumno = 
                        ml.obtenerLibrosAlumno(
                            conexion.getConexion(), idUsuarioSession
                        );
                } catch (SQLException ex) {
                    Logger.getLogger(
                        ControladorAlumno.class.getName()).log(
                            Level.SEVERE, null, ex
                    );
                }
                
                conexion.desconectar();
                
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/alumnos/LibrosAlumno.jsp"
                );
                
                request.setAttribute("listaLibrosAlumno", librosAlumno);
                break;

            case "vistaAgregarLibrosAlumno":
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/alumnos/LibrosDisponibles.jsp"
                );
                break;

            default:
                System.out.println("Error de ruta");
                break;
        }

        try (PrintWriter out = response.getWriter()) {
            if (requestDispatcher != null) {
                requestDispatcher.forward(request, response);
            }

            out.print(mensajeControladorAlumno);
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
