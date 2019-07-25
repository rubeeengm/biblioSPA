var LibrosAlumno = {
    cargarModulo: function () {
        $('#verListaLibrosRegistrados').unbind('click').bind('click', function (event) {
            event.preventDefault();
            LibrosAlumno.peticionVistaLibroRegistrados();
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
    }
}