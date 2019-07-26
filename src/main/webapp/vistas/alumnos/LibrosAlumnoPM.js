var LibrosAlumno = (function(){

    function peticionVistaLibroRegistrados(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "vistaLibrosRegistrados"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/alumnos/LibrosRegistradosPM.js").done(
                function () {
                    LibrosRegistrados.cargarModulo();
                }
            );
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
                    LibrosDisponibles.cargarModulo();
                }
            );
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionVistaIndex(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorLogin',
            method: 'POST',
            data: {
                ACCION: "vistaLogin"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/login/LoginPM.js").done(function () {
                Login.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    function borrarLibro(idLibro) {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data: {
                ACCION: "borrarLibroAlumno",
                idLibro: idLibro
            }
        }).done(function () {
            peticionVistaLibrosAlumno();
        }).fail(function () {
            alert("Error");
        });
    }

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
            $('#verListaLibrosRegistrados').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaLibroRegistrados();
            });
            
            $('#agregarLibros').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaAgregarLibrosAlumno()
            });
            
            $('#cerrarSesion').unbind('click').bind('click', function (event) {
                event.preventDefault();
                peticionVistaIndex();
            });
            
            $('.borrar').unbind('click').bind('click', function (event) {
                event.preventDefault();
                borrarLibro($(this).attr("id"));
            });
        }
    }
}());