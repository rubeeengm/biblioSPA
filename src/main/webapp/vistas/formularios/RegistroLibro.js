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
                RegistroLibro.peticionVistaAdmin();
            }).fail(function () {
                alert("Error");
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