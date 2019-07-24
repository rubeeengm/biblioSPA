<%-- 
    Document   : librosRegistrados
    Created on : 18/07/2019, 03:26:54 PM
    Author     : Ruben Gustavo Garcia Malaga
    Nota       : SI EL ADMIN ES EL QUE CONSULTA ESTA PAGINA, ENTONCES EL BOTON
                 REGRESAR LO TIENE QUE MANDAR A LA VISTA PRINCIPAL DEL ALUMNO
--%>
<h1>Libros Registrados</h1>

<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">T�tulo</th>
            <th scope="col">Autor</th>
            <th scope="col">ISBN</th>
            <th scope="col">N�mero de p�ginas</th>
            <th scope="col">Status</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Matematicas 1</td>
            <td>Jorge Hernandez</td>
            <td>12-154-12365-12</td>
            <td>255</td>
            <td>Disponible</td>
        </tr>

        <tr>
            <th scope="row">2</th>
            <td>F�sica 1</td>
            <td>Marco Lopez</td>
            <td>12-154-12365-15</td>
            <td>110</td>
            <td>Usado</td>
        </tr>
    </tbody>                       
</table>

<div id="buttonRegresar" class="row">
    <button class="btn btn-warning">
        Regresar
    </button>
</div>