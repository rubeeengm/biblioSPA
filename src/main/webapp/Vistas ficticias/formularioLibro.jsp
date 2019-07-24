<%-- 
    Document   : formularioLibro
    Created on : 18/07/2019, 11:27:01 AM
    Author     : Jorge Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            .container {
                margin-top: 20px;
                margin-bottom: 20px;
            }

            h1 {
                padding-bottom: 10px;
                text-align: center;
            }
        </style>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Registro de Libros</title>
    </head>

    <body>
        <div class="container">
            <h1>Registro libro</h1>

            <form action = "./controlador/controlador.php?operacion=insertarLibro" method="POST">
                <div class="container">
                    <div class="form-group">
                        <label for="titulo">Titulo del libro</label>
                        <input type="text" class="form-control" id="titulo" 
                               name="titulo" placeholder="Ingresa el título" 
                               required pattern="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$">
                    </div>

                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <input type="text" class="form-control" id="autor" 
                               name="autor" placeholder="Ingresa el Autor" 
                               required pattern="^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]{1,24}[\s]*)+$">
                    </div>

                    <div class="form-group">
                        <label for="isbn">ISBN</label>
                        <input type="text" class="form-control" id="isbn" 
                               name="isbn" placeholder="Escribe el ISBN" 
                               required pattern="^((?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$">
                    </div>

                    <div class="form-group">
                        <label for="numPaginas">Numero de páginas</label>
                        <input type="text" class="form-control" id="numPaginas" 
                               name="numPaginas" placeholder="Escribe el número de páginas" 
                               maxlenght="5" required pattern="^[1-9]\d*$">
                    </div>

                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a style="margin-left: 15px" class="btn btn-danger" href="alumnosRegistrados.jsp">Cancelar</a>
                </div>
            </form>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
