<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fractal.practicante.bibliospa.modelo.beans.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% List<Libro> libros = (ArrayList<Libro>) request.getAttribute("libros");%>
<div class="row">
    <h1>Libros registrados</h1>
    <c:choose>
        <c:when test="${libros.size() > 0}">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Título</th>
                        <th scope="col">Autor</th>
                        <th scope="col">ISBN</th>
                        <th scope="col">Número de páginas</th>
                        <th scope="col">Status</th>
                        <th scope="col">Eliminar<th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        for (Libro libro : libros) {
                            out.print("<tr>");
                            out.print("<th scope = \"row\">" + libro.getId() + "</th>");
                            out.print("<td>" + libro.getTitulo() + "</td>");
                            out.print("<td>" + libro.getAutor() + "</td>");
                            out.print("<td>" + libro.getIsbn() + "</td>");
                            out.print("<td>" + libro.getNumPaginas() + "</td>");
                            if (libro.getEstado() == '1') {
                                out.print("<td>Disponible</td>");
                                out.print("<td><button id=\"buttonEliminarLibro\" type=\"submit\" style=\"margin-left: 15px\" class=\"btn btn-danger\" value= \"" + libro.getId() + "\" >Eliminar</button></td>");
                            } else {
                                out.print("<td>Ocupado</td>");
                                out.print("<td></td>");
                            }
                        }
                    %>
                </tbody>                       
            </table>
        </c:when>

        <c:when test="${libros.size() < 1}">
            <img src="./assets/img/imagen.png">
        </c:when>
    </c:choose>
</div>

<div class="row" style="align-content: flex-end">
    <button id="buttonRegistrarLibro" type="submit" style="margin-left: 15px" class="btn btn-primary">Registrar Libro</button>
    <button id="buttonSalir" type="submit" style="margin-left: 20px" class="btn btn-warning">Salir</button>
</div>