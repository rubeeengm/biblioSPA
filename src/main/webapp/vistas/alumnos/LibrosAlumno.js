var LibrosAlumno = {
    cargarModulo: function () {
        $('#verListaLibrosRegistrados').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosAlumno.peticionVistaLibroRegistrados();
        });
        
        $('#agregarLibros').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosAlumno.peticionVistaAgregarLibrosAlumno()
        });
        
        $('#cerrarSesion').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosAlumno.peticionVistaIndex();
        });
    },
    peticionVistaLibroRegistrados: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaLibrosRegistrados"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosRegistrados.js").done(
                function () {
                    LibrosRegistrados.cargarModulo();
                }
            );
        }).fail(function () {
            alert("Error");
        });
    },
    peticionVistaAgregarLibrosAlumno: function() {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaAgregarLibrosAlumno"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosDisponibles.js").done(
                function () {
                    LibrosDisponibles.cargarModulo();
                }
            );
        }).fail(function () {
            alert("Error");
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
    }
}