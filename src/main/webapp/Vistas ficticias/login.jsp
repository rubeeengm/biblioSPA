<%-- 
    Document   : login
    Created on : 18/07/2019, 09:43:15 AM
    Author     : Jorge Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="./assets/js/prueba.js"></script>
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            .container {
                padding: 16px;
            }
            
            .pswd{
                height: 40px;
            }

            span.psw {
                float: right;
                padding-top: 10px;
                padding-right: 20px;
            }

            h1{
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
            <h1>Login</h1>

            <form action="loguin" method="post">
                <div class="container">
                    <label for="usuario"><b>Usuario</b></label>
                    <input type="text" placeholder="Ingresa tu usuario" 
                           name="usuario" id="usuario" required
                           pattern="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$">

                    <label for="contraseña"><b>Contraseña</b></label>
                    <input type="password" placeholder="Ingresa tu contraseña" 
                           name="contrasenia" id="contrasenia" required>

                    <button class="btn-primary" type="submit">Login</button>
                </div>

                <div class="pswd" style="background-color:#f1f1f1">
                    <span class="psw">No estás registrado? Regístrate <a href="nuevoUsuario">aquí</a></span>
                </div>
            </form>
        </div>

        <!-- Optional JavaScript -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
</html>