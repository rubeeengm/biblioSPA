<%-- 
    Document   : librosRegistrados
    Created on : 18/07/2019, 03:26:54 PM
    Author     : Jorge Hernandez
    Nota       : SI EL ADMIN ES EL QUE CONSULTA ESTA PAGINA, ENTONCES EL BOTON
                 REGRESAR LO TIENE QUE MANDAR A LA VISTA alumnosRegistrados.jsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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

    <title>Tabla de libros registrados</title>
  </head>
  <body>
    <div class="container">
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
                    <td>Física 1</td>
                    <td>Marco Lopez</td>
                    <td>12-154-12365-15</td>
                    <td>110</td>
                    <td>Usado</td>
                </tr>
            </tbody>                       
        </table>
        <div class="row">
            <a style="margin-left: 15px" class="btn btn-warning" href="librosAlumno.jsp">Regresar</a>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
