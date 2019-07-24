<%-- 
    Document   : formularioAlumno
    Created on : 17/07/2019, 04:39:01 PM
    Author     : Jorge Antonio Hernandez Navarrete
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

        <title>Registro de Alumno</title>
    </head>

    <body>      
        <div class="container">
            <h1>Registro de Alumno</h1>

            <form action="./controlador/controlador.php?operacion=insertarAlumno" method="POST">
                <div class="container">
                    <div class="form-group">
                        <label for="nombre">Nombre del Alumno</label>
                        <input type="text" class="form-control" id="nombre" 
                               name="nombre" placeholder="Escribe tu nombre" 
                               maxlength="40" required pattern="^([A-ZÁÉÍÓÚ]{1}[a-zñáéíóú]+[\s]*)+$"> 
                    </div>

                    <div class="form-group">
                        <label for="pApellido">Primer apellido</label>
                        <input type="text" class="form-control" id="pApellido" 
                               name="pApellido" placeholder="Escribe tu primer apellido" 
                               required pattern="^([A-ZÁÉÍÓÚ][a-zñáéíóú]+)+$">
                    </div>

                    <div class="form-group">
                        <label for="sApellido">Segundo apellido</label>
                        <input type="text" class="form-control" id="sApellido" 
                               name="sApellido" placeholder="Escribe tu segundo apellido" 
                               required pattern="^([A-ZÁÉÍÓÚ][a-zñáéíóú]+)+$">
                    </div>

                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="text" class="form-control" id="telefono" 
                               name="telefono" placeholder="Ingresa tu telefono de 10 digitos"  
                               minlength="10" maxlength="10" required pattern="[0-9]{10}">
                    </div>

                    <div class="form-group">
                        <label for="dni">DNI del alumno</label>
                        <input type="text" class="form-control" id="dni" 
                               name="dni" placeholder="Ingresa tu DNI" 
                               required pattern="^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$"
                               minlength="9" maxlength="9">
                    </div>

                    <div class="form-group">
                        <label for="usuario">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="usuario" 
                               name="usuario" placeholder="e.j. TheBoss" 
                               required pattern="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$">
                    </div>

                    <div class="form-group">
                        <label for="contraseña">Contraseña</label>
                        <input type="password" class="form-control" id="contrasenia" 
                               name="contrasenia" placeholder="Entre 8 y 16 dígitos de longitud" 
                               required minlength="8" maxlength="16"
                               pattern="^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$">
                        <small id="contraseniaAyuda" class="form-text text-muted">
                            La contraseña debe tener al menos un dígito, una minúscula, una mayúscula y al menos un símbolo</small>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Registrarse</button>
                    <a style="margin-left: 15px" class="btn btn-danger" href="index.jsp">Cancelar</a>
                </div>
            </form>
        </div>

        <!-- Optional JavaScript -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
