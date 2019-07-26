var LibrosRegistrados = (function(){

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

    return {
        cargarModulo: function () {
            $('#buttonRegresar').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaLibrosAlumno();
            });
        }
    }
}());