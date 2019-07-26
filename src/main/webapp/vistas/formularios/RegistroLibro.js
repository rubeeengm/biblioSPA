var RegistroLibro = {
    cargarModulo: function () {
        $('#buttonRegistrarLibro').unbind('click').bind('click', function (event) {
            event.preventDefault();
            RegistroLibro.peticionRegistroLibro();
        });
        $('#buttonCancelar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            RegistroLibro.peticionVistaAdmin();
        });
    },
    peticionRegistroLibro: function () {
        $.ajax({
                url: 'http://localhost:8080/biblioSPA/ControladorLibro',
                method: 'POST',
                data: {
                    ACCION: "registro",
                    titulo: $('#titulo').val(),
                    autor: $('#autor').val(),
                    isbn: $('#isbn').val(),
                    numPaginas: $('#numPaginas').val()
                }
            }).done(function () {
                switch (arguments[0]) {
                
                case "exito":
                    RegistroLibro.peticionVistaAdmin();
                    alert('Registraste un libro correctamente');
                break;

                case "datos_erroneos":
                    alert("Los datos en los campos no coinciden");
                break;

                case "datos_nulos":
                    alert("Peticion con datos nulos");
                break;

                case "datos_vacios":
                    alert("Procura llenar los campos");
                break;
                
                case "db_error":
                    alert("Error en la base de datos");
                break;
                    
                default:
                    alert("Error general");
                }
                
            }).fail(function () {
                //alert("Error");
            });
    },
    peticionVistaAdmin: function () {
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAdmin',
            method: 'POST',
            data: {
                ACCION: "vistaAdmin"
            }
        }).done(function () {
            $('div.container').html(arguments[0]);
            $.getScript("vistas/admin/Admin.js").done(function () {
                Admin.cargarModulo();
            });
        }).fail(function () {
            alert("Error");
        });
    }
}