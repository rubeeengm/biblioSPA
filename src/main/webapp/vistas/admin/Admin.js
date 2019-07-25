var Admin = {
    cargarModulo: function () {
       $('#buttonSalir').unbind('click').bind('click', function (event) {
            event.preventDefault();
            Admin.peticionObtenerLibros();
            Admin.peticionEliminarLibro();
            Admin.peticionVistaIndex();
        });
        $('#buttonRegistrarLibro').unbind('click').bind('click', function (event) {
            event.preventDefault();
            Admin.peticionVistaRegistroLibro();
        });
    },
    peticionVistaIndex: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "vistaLogin"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/login/Login.js").done(function () {
                Login.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    },
    peticionVistaRegistroLibro: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "vistaRegistroLibro"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/formularios/RegistroLibro.js").done(function () {
                RegistroLibro.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    },
    peticionObtenerLibros: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "obtenerLibros"
            }
        }).done(function () {
        }).fail(function () {
            alert("Error");
        });
    },
    peticionEliminarLibro: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "eliminarLibro",
                idlibro: 4
            }
        }).done(function () {
        }).fail(function () {
            alert("Error");
        });
    }
};