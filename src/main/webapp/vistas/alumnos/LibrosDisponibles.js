var LibrosDisponibles = {
    cargarModulo: function () {
        $('#agregarSelecciones').unbind('click').bind('click', function (event) {
            event.preventDefault();
            alert("Libros agregados");
        });
        
        $('#cancelar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosDisponibles.peticionVistaLibrosAlumno();
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
    }
}