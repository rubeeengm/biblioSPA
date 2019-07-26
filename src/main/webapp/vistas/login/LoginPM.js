var Login = (function(){

    function peticionVistaLibrosAlumno(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaLibrosAlumno"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosAlumnoPM.js").done(function () {
                LibrosAlumno.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionVistaRegistro(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "vistaRegistrar"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/formularios/RegistroAlumnoPM.js").done(function () {
                RegistroAlumno.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionLogin(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "login",
                usuario: $('#usuario').val(),
                contrasenia: $('#contrasenia').val()
            }
        }).done(function () {
            switch (arguments[0]) {
                case "LC":
                    peticionVistaLibrosAlumno();
                    break;
                case "LI":
                    alert("Usuario o contraseña incorrectos");
                    break;                    
                case "LA":
                    peticionVistaAdmin();
                    break;
                case "Campos nulos":
                    alert("Tu registro tiene campos nulos");
                    break;
                case "Campos vacios":
                    alert("Tu registro tiene campos vacios");
                    break;
            }
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionVistaAdmin(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "vistaAdmin",
                libros: {}
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/admin/AdminPM.js").done(function () {
                Admin.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    return {
        cargarModulo: function(){
            $('#buttonLogin').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionLogin();
            });
    
            $('#buttonRegistrar').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaRegistro();
            });
        }
    }
}());