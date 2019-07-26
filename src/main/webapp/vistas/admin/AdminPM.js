var Admin = (function(){

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

    function peticionVistaRegistroLibro(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "vistaRegistroLibro"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/formularios/RegistroLibroPM.js").done(function () {
                RegistroLibro.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionObtenerLibros(){
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
    }

    function peticionEliminarLibro(idlibro){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "eliminarLibro",
                idlibro
            }
        }).done(function () {
            peticionVistaAdmin();
            alert("Libro eliminado");
        }).fail(function () {
            alert("Error");
        });
    }

    function peticionVistaAdmin(){
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "vistaAdmin"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/admin/AdminPM.js").done(function () {
                Admin.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }

    return {
        cargarModulo: function () {
            $('#buttonSalir').unbind('click').bind('click', function (event) {
                 event.preventDefault();
                 peticionVistaIndex();
             });
             
             $('#buttonRegistrarLibro').unbind('click').bind('click', 
                 function (event) {
                     event.preventDefault();
                     peticionVistaRegistroLibro();
                 }
             );
     
             $('.btn-danger').unbind('click').bind('click', function (event) {
                 event.preventDefault();
                 peticionEliminarLibro($(this).val());
             });
         }
    }
}());