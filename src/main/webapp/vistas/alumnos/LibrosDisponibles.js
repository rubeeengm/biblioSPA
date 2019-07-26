var LibrosDisponibles = {
    cargarModulo: function () {
        $('#cancelar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosDisponibles.peticionVistaLibrosAlumno();
        });
        
        $('.agregar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosDisponibles.agregarLibro($(this).attr("id"));
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
    agregarLibro: function (idLibro) {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "agregarLibroAlumno",
                idLibro: idLibro
            }
        }).done(function () {
           LibrosDisponibles.peticionVistaAgregarLibrosAlumno();
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
    }
}