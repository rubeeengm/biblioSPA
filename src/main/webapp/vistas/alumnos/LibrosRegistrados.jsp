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

<h1>Libros Registrados</h1>
<%
    ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("listaLibrosRegistrados");
    request.setAttribute("libros", libros);
%>

<table class="table">
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
                <td>${libro.getEstado()}</td>                        
            </tr>
        </c:forEach>
    </tbody>                       
</table>

<div id="buttonRegresar" class="row">
    <button class="btn btn-warning">
        Regresar
    </button>
</div>