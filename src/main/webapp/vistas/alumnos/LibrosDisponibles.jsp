<%-- 
    Document   : librosDisponibles
    Created on : 18/07/2019, 01:17:54 PM
    Author     : Jorge Hernánadez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Libros disponibles</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Título</th>
            <th scope="col">Autor</th>
            <th scope="col">ISBN</th>
            <th scope="col">Número de páginas</th>
            <th scope="col">Agregar</th>
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
                <input type="checkbox"></input>
            </td>
        </tr>
        
        <tr>
            <th scope="row">2</th>
            <td>Fisica 1</td>
            <td>Marco Lopez</td>
            <td>90-234-15675-15</td>
            <td>110</td>
            <td>
                <input type="checkbox"></input>
            </td>
        </tr>
    </tbody>                       
</table>

<div class="row">
    <button id="agregarSelecciones" class="btn btn-primary">Agregar selecciones</button>
    <button id="cancelar" class="btn btn-warning">Regresar</button
</div>