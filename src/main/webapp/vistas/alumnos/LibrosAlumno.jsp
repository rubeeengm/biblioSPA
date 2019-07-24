<%-- 
    Document   : librosAlumno
    Created on : 18/07/2019, 01:29:28 PM
    Author     : Melissa Gpe. P�rez Cabrera <perezc.melissa@gmail.com>
--%>

<h1>Libros del alumno Jorge </h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Título</th>
            <th scope="col">Autor</th>
            <th scope="col">ISBN</th>
            <th scope="col">Número de páginas</th>
            <th scope="col"></th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Matematicas 1</td>
            <td>Jorge Hernandez</td>
            <td>12-154-12365-12</td>
            <td>255</td>
            <td>
                <a class="btn btn-danger" href="#">Borrar libro</a>
            </td>
        </tr>

        <tr>
            <th scope="row">2</th>
            <td>F�sica 1</td>
            <td>Marco Lopez</td>
            <td>12-154-12365-15</td>
            <td>110</td>
            <td>
                <a class="btn btn-danger" href="#">Borrar libro</a>
            </td>
        </tr>
    </tbody>                       
</table>

<div class="row">
    <button id="agregarLibros" class="btn btn-sucess">Agregar Libros</button>
    <button id="verListaLibrosRegistrados" class="btn btn-primary">Ver lista de libros</button>
    <button id="cerrarSesion" class="btn btn-warning">Cerrra sesión</button>
</div>