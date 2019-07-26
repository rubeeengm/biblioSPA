<%-- 
    Document   : librosDisponibles
    Created on : 18/07/2019, 01:17:54 PM
    Author     : Jorge Hernánadez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.fractal.practicante.bibliospa.modelo.beans.Libro" %>

<h1>Libros disponibles</h1>
<%
    ArrayList<Libro> libros = (ArrayList<Libro>) request.getAttribute("listaLibrosDisponibles");
    request.setAttribute("libros", libros);
%>
<table class="table">
    <thead>
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
                <td><button id="${libro.getId()}" class="agregar btn btn-success">Agregar</button></td>
            </tr>
        </c:forEach>
    </tbody>                       
</table>

<div class="row">
    <button id="cancelar" class="btn btn-warning">Regresar</button>
</div>