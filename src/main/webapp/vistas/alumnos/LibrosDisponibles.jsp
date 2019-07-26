<%-- 
    Document   : librosDisponibles
    Created on : 18/07/2019, 01:17:54 PM
    Author     : Jorge Hernánadez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.fractal.practicante.bibliospa.modelo.beans.Libro" %>

<%
    ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("listaLibrosDisponibles");
    request.setAttribute("libros", libros);
%>

<div class="row">
    <h1>Libros disponibles</h1>

    <c:choose>
        <c:when test="${libros.size() > 0}">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Título</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Número de páginas</th>
                        <th scope="col"></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="libro" items="${libros}">
                        <tr>
                            <td>${libro.getTitulo()}</td>
                            <td>${libro.getAutor()}</td>
                            <td>${libro.getNumPaginas()}</td>
                            <td>
                                <button id="${libro.getId()}" 
                                        class="agregar btn btn-success">
                                    Agregar
                                </button>
                            </td>
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

<div class="row">
    <button id="cancelar" class="btn btn-warning">Regresar</button>
</div>