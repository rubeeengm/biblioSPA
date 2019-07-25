var Login = {
    cargarModulo: function () {
        $('#buttonLogin').unbind('click').bind('click', function (event) {
            event.preventDefault();
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
                        Login.peticionVistaLibrosAlumno();
                        break;

                    case "LI":
                        alert("Usuario o contraseña incorrectos");
                        break;
                }
            }).fail(function () {
                alert("Error");
            });
        });

        $('#buttonRegistrar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            Login.peticionVistaRegistro();
        });
    },
    peticionVistaLibrosAlumno: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaLibrosAlumno"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosAlumno.js").done(function () {
                LibrosAlumno.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    },
    peticionVistaRegistro: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "vistaRegistrar"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/formularios/RegistroAlumno.js").done(function () {
                RegistroAlumno.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    },
    peticionVistaAdmin: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "vistaAdmin"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/formularios/RegistroAlumno.js").done(function () {
                RegistroAlumno.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }
}