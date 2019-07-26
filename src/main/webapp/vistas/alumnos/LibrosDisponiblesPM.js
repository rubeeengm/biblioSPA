var LibrosDisponibles = (function(){

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

    function agregarLibro(idLibro) {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "agregarLibroAlumno",
                idLibro: idLibro
            }
        }).done(function () {
           peticionVistaAgregarLibrosAlumno();
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionVistaAgregarLibrosAlumno(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaAgregarLibrosAlumno"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosDisponiblesPM.js").done(
                function () {
                    cargarModulo();
                }
            );
        }).fail(function () {
            alert("Error");
        });
    }

    return {
        cargarModulo: function () {
            $('#cancelar').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaLibrosAlumno();
            });
            
            $('.agregar').unbind('click').bind('click', function (event) {
                event.preventDefault();
                agregarLibro($(this).attr("id"));
            });
        }
    }
}());