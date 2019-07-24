<%-- 
    Document   : alumnosRegistrados
    Created on : 18/07/2019, 03:40:58 PM
    Author     : Jorge Hernandez
    Notas      : VISTA EXCLUSIVA DEL ADMINISTRADOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <style>
            .container{
                margin-top: 15px;
                text-align: center;              
            }
            .tbody{
                vertical-align: middle;
            }
            h1{
                padding-bottom: 10px;
            }
        </style>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Tabla de alumnos registrados</title>
    </head>
    <body>
        <div class="container">
            <h1>Alumnos registrados</h1>
            <table class="table table-striped table-dark table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Primer apellido</th>
                        <th scope="col">Segundo apellido</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">DNI</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jorge</td>
                        <td>Hernandez</td>
                        <td>Barrios</td>
                        <td>2299192915</td>
                        <td>E14021243</td>
                        <td>
                            <a class="btn btn-primary" href="TablaLibrosAlumno.html">Ver libros</a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Ruben</td>
                        <td>Garcia</td>
                        <td>Malaga</td>
                        <td>2829914532</td>
                        <td>E14021256</td>
                        <td>
                            <a class="btn btn-primary" href="TablaLibrosAlumno.html">Ver libros</a>
                        </td>
                    </tr>
                </tbody>                       
            </table>
            <div class="row">
                <a style="margin-left: 15px" href="formularioLibro.jsp" class="btn btn-primary">Agregar libro</a>
                <a style="margin-left: 15px" href="librosRegistrados.jsp" class="btn btn-success">Ver lista de libros</a>
                <a style="margin-left: 15px" href="index.jsp" class="btn btn-warning">Cerrar Sesión</a>                
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
