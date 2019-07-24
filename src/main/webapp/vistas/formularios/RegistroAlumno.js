var RegistroAlumno = {
    cargarModulo: function () {
        $('#btnRegistrar').unbind('click').bind('click', function(){
            event.preventDefault();
        });
        
        $('#btnCancelar').unbind('click').bind('click', function(){
            event.preventDefault();
            RegistroAlumno.peticionVistaLogin();
        });
    },
    
    peticionVistaLogin: function () {
        $.ajax({
                url: 'http://localhost:8080/biblioSPA/ControladorLogin',
                method: 'POST',
                data:{
                    ACCION: "vistaLogin"
                }
            }).done(function () {
                $('div.container').html(arguments[0]);
                $.getScript('vistas/login/Login.js').done(function () {
                    Login.cargarModulo();
                });
            }).fail(function () {
                alert("Error");
            });
    },
    
    peticionRegistrar: function () {
        
    }
}