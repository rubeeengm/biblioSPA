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
                    case "Lbien":
                        alert("Entraste");
                        break;

                    case "Lmal":
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
    }
}