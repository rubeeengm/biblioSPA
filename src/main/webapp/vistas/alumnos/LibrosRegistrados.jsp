<%-- 
    Document   : librosRegistrados
    Created on : 18/07/2019, 03:26:54 PM
    Author     : Ruben Gustavo Garcia Malaga
    Nota       : SI EL ADMIN ES EL QUE CONSULTA ESTA PAGINA, ENTONCES EL BOTON
                 REGRESAR LO TIENE QUE MANDAR A LA VISTA PRINCIPAL DEL ALUMNO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.fractal.practicante.bibliospa.modelo.beans.Libro" %>

<%
    ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("listaLibrosRegistrados");
    request.setAttribute("libros", libros);
%>

<div class="row">
    <h1>Libros Registrados</h1>
    <c:choose>
        <c:when test="${libros.size() > 0}">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Titulo</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Numero de paginas</th>
                        <th scope="col">Estado</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="libro" items="${libros}">
                        <tr>
                            <td>${libro.getTitulo()}</td>
                            <td>${libro.getAutor()}</td>
                            <td>${libro.getNumPaginas()}</td>
                            <c:choose>
                                <c:when test = "${libro.getEstado() eq '1'.charAt(0)}">
                                    <td> Disponible </td>
                                </c:when>

                                <c:when test = "${libro.getEstado() eq '0'.charAt(0)}">
                                    <td> Ocupado </td>
                                </c:when>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>                       
            </table>
        </c:when>
        
        <c:when test="${libros.size() < 1}">
            <img src="./assets/img/imagen.png">
        </c:when>
    </c:choose>
</div>

<div id="buttonRegresar" class="row">
    <button class="btn btn-warning">
        Regresar
    </button>
</div>