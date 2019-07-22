<%--
    Document   : login
    Created on : Jul 21, 2019, 4:22:44 PM
    Author     : server
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Login</h1>

<form>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input id="usuario" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input id="contrasenia" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>

    <div class="form-group">
        <button id="buttonLogin" type="submit" class="btn btn-primary">Entrar</button>
    </div>

    <div class="form-group">
        <button id="buttonRegistrar" type="submit" class="btn btn-primary">Registrate</button>
    </div>
</form>