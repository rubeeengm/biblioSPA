/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fractal.practicante.bibliospa.controladores;

import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.conexion.Conexion;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibros;
import com.fractal.practicante.bibliospa.modelo.validaciones.ValidacionLibro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "ControladorLibro", urlPatterns = {"/ControladorLibro"})
public class ControladorLibro extends HttpServlet {

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
        Conexion conexion = new Conexion();
        conexion.conectar();
        String mensajeLibro = "";
        
        switch(accion){
            case "registro":
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String isbn = request.getParameter("isbn");
                int numPaginas = Integer.parseInt(request.getParameter("numPaginas"));
                Libro objetoLibro = new Libro(titulo, autor, numPaginas, isbn);
                
                ValidacionLibro valLibro = new ValidacionLibro();
                ModeloLibros modLibros = new ModeloLibros();
                
                if(valLibro.validacionTotal(objetoLibro)){
            try {
                modLibros.insertar(conexion.getConexion(), objetoLibro);
            } catch (SQLException ex) {
                System.out.println("Error al insertar libro");
            }
                    conexion.desconectar();
                }else{
                    mensajeLibro = "Campos vacíos";
                }
            break;
            
            default:
            break;
        }
        
        try (PrintWriter out = response.getWriter()) {
            if(requestDispatcher != null){
                requestDispatcher.forward(request, response);
            }
            out.print(mensajeLibro);
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
