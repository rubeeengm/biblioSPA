<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Registro de Alumno</h1>
<form class="form-group">    
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
    <button class="btn btn-primary" id="btnRegistrar">Registrarse</button>
    <button class="btn btn-warning" id="btnCancelar">Cancelar</button>    
</form>