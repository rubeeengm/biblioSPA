<%--
    Document   : login
    Created on : Jul 21, 2019, 4:22:44 PM
    Author     : server
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Login</h1>

<form>
    <div class="form-group">
        <label for="inputUsuario">Usuario</label>
        <input id="usuario" type="text" class="form-control" placeholder="Ingresa tu usuario">
    </div>

    <div class="form-group">
        <label for="inputContrasenia">Password</label>
        <input id="contrasenia" type="password" class="form-control" placeholder="Ingresa tu contraseña">
    </div>

    <div class="form-group">
        <button id="buttonLogin" type="submit" class="btn btn-primary">Entrar</button>
    </div>

    <div class="form-group">
        <button id="buttonRegistrar" class="btn btn-warning">Registrate</button>
    </div>
</form>