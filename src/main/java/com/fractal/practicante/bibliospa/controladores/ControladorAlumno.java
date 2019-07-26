package com.fractal.practicante.bibliospa.controladores;

import com.fractal.practicante.bibliospa.modelo.beans.Alumno;
import com.fractal.practicante.bibliospa.modelo.beans.Libro;
import com.fractal.practicante.bibliospa.modelo.beans.LibroDeAlumno;
import com.fractal.practicante.bibliospa.modelo.beans.Usuario;
import com.fractal.practicante.bibliospa.modelo.conexion.Conexion;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibros;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloLibrosDeAlumno;
import com.fractal.practicante.bibliospa.modelo.modelos.ModeloTransacciones;
import com.fractal.practicante.bibliospa.modelo.validaciones.ValidacionAlumno;
import com.fractal.practicante.bibliospa.modelo.validaciones.ValidacionLibroAlumno;
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
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("ACCION");
        RequestDispatcher requestDispatcher = null;
        Conexion conexion = new Conexion();
        conexion.conectar();
        String mensajeControladorAlumno = "";
        ModeloLibros modeloLibros;
        ArrayList<Libro> librosAlumno = null;
        ModeloLibrosDeAlumno modeloLibrosDeAlumno;
        ValidacionLibroAlumno validacionLibroAlumno;
        int idLibro;
        LibroDeAlumno libroDeAlumno;
        HttpSession sesion;
        
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
                    if(valAl.validarVacios(alumnoObjeto) &&
                            valUs.validarVacios(usuarioObjeto)){
                            if (valAl.validacionTotal(alumnoObjeto)
                            && valUs.validacionTotal(usuarioObjeto)) {

                            mt.insertarAlumno(
                                conexion.getConexion(), 
                                alumnoObjeto, 
                                usuarioObjeto
                            );
                            conexion.desconectar();
                            mensajeControladorAlumno = "exito";

                        } else {
                            mensajeControladorAlumno = "datos_erroneos";
                    }
                    } else {
                        mensajeControladorAlumno = "datos_vacios";
                    }
                } else {
                    mensajeControladorAlumno = "datos_nulos";
                }

                break;

            case "vistaLibrosRegistrados":
                modeloLibros = new ModeloLibros();

                try {
                    librosAlumno = modeloLibros.obtenerTodos(
                        conexion.getConexion()
                    );
                } catch (SQLException ex) {
                    Logger.getLogger(
                            ControladorAlumno.class.getName()
                    ).log(
                        Level.SEVERE, null, ex
                    );
                }

                conexion.desconectar();

                requestDispatcher = getServletContext().getRequestDispatcher(
                        "/vistas/alumnos/LibrosRegistrados.jsp"
                );
                request.setAttribute("listaLibrosRegistrados", librosAlumno);
                break;

            case "vistaLibrosAlumno":
                modeloLibros = new ModeloLibros();
                sesion = (HttpSession) request.getSession();
                int idUsuarioSession = (int) sesion.getAttribute("idUsuario");

                System.out.println(idUsuarioSession);

                try {
                    librosAlumno
                            = modeloLibros.obtenerLibrosAlumno(
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
                modeloLibros = new ModeloLibros();
                
                try {
                    librosAlumno = modeloLibros.obtenerDisponibles(
                            conexion.getConexion()
                    );
                } catch (SQLException ex) {
                    Logger.getLogger(
                            ControladorAlumno.class.getName()
                    ).log(
                        Level.SEVERE, null, ex
                    );
                }
                
                conexion.desconectar();
                
                requestDispatcher = getServletContext().getRequestDispatcher(
                    "/vistas/alumnos/LibrosDisponibles.jsp"
                );
                
                request.setAttribute("listaLibrosDisponibles", librosAlumno);
                break;
                
            case "agregarLibroAlumno":
                int idUsuario = 0;
                String idUsuarioSesion = "";
                //recupero la sesion
                sesion = (HttpSession) request.getSession();
                //obtengo el idLibro de la petición
                String idLibroRequest = request.getParameter("idLibro");
                
                try {
                    //obtengo el valor del idUsuario de la sesion
                    idUsuario = (int) sesion.getAttribute("idUsuario");
                } catch (NullPointerException e) {
                    System.out.println("Usuario no logueado");
                    idUsuarioSesion = null;
                }
                
                if(idUsuarioSesion == null || idLibroRequest == null) {
                    System.out.println("Id de usuario o Id de libro nulo");
                } else {
                    libroDeAlumno = new LibroDeAlumno(
                        idUsuario,
                        Integer.parseInt(idLibroRequest)
                    );
                    //valido que no sean negativos los id
                    validacionLibroAlumno = new ValidacionLibroAlumno();
                    
                    if(!validacionLibroAlumno.
                        validarLibroAlumno(libroDeAlumno)) {
                            System.out.println("Datos menores a cero");
                    } else {
                        modeloLibrosDeAlumno = new ModeloLibrosDeAlumno();
                        //inserta el libro al alumno
                        modeloLibrosDeAlumno.insertar(
                            conexion.getConexion(), 
                            libroDeAlumno
                        );
                    }
                }
                
                conexion.desconectar();
            break;
            
            case "borrarLibroAlumno":
                modeloLibrosDeAlumno = new ModeloLibrosDeAlumno();
                idLibro = Integer.parseInt(request.getParameter("idLibro"));
                
                try {
                    modeloLibrosDeAlumno.eliminar(
                        conexion.getConexion(), idLibro
                    );
                } catch (SQLException ex) {
                    Logger.getLogger(
                        ControladorAlumno.class.getName()
                    ).log(
                        Level.SEVERE, null, ex
                    );
                }
                
                conexion.desconectar();
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    // Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, 
        HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response)
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
