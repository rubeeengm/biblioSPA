<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fractal.practicante.bibliospa.modelo.beans.Libro"%>
<h1>Libros registrados</h1>

        <table class="table table-striped table-dark table-hover">
            <thead>
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
                <% List<Libro> libros = (ArrayList<Libro>) request.getAttribute("libros");
                    for(Libro libro : libros){
                        out.print("<tr>");
                        out.print("<th scope = \"row\">"+libro.getId()+"</th>");
                        out.print("<td>"+libro.getTitulo()+"</td>");
                        out.print("<td>"+libro.getAutor()+"</td>");
                        out.print("<td>"+libro.getIsbn()+"</td>");
                        out.print("<td>"+libro.getNumPaginas()+"</td>");
                        if(libro.getEstado() == '1'){
                            out.print("<td>Disponible</td>");
                            out.print("<td><button id=\"buttonEliminarLibro\" type=\"submit\" style=\"margin-left: 15px\" class=\"btn btn-danger\" value= \""+libro.getId()+"\" >Eliminar</button></td>");
                        }else{
                            out.print("<td>Ocupado</td>");
                            out.print("<td></td>");
                        }
                    }
                %>
            </tbody>                       
        </table>
        <div class="row" style="align-content: flex-end">
            <button id="buttonRegistrarLibro" type="submit" style="margin-left: 15px" class="btn btn-primary">Registrar Libro</button>
            <button id="buttonSalir" type="submit" style="margin-left: 20px" class="btn btn-warning">Salir</button>
        </div>