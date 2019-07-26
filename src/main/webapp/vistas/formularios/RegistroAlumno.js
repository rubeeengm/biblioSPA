var RegistroAlumno = {
    cargarModulo: function () {
        $('#btnRegistrar').unbind('click').bind('click', function(){
            event.preventDefault();
            RegistroAlumno.peticionRegistrar();
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
        $.ajax({
            url: 'http://localhost:8080/biblioSPA/ControladorAlumno',
            method: 'POST',
            data:{
                ACCION: "registrar",
                nombre: $('#nombre').val(),
                apellidoPaterno: $('#apellidoPaterno').val(),
                apellidoMaterno: $('#apellidoMaterno').val(),
                telefono: $('#telefono').val(),
                dni: $('#dni').val(),
                nombreUsuario: $('#nombreUsuario').val(),
                contrasenia: $('#contrasenia').val()
            }
        })
        .done(function () {
            switch (arguments[0]) {
                
                case "exito":
                    RegistroAlumno.peticionVistaLogin();
                    alert('Te registraste correctamente');
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
                    
                default:
                    alert("Error general");
                }
        })
        .fail(function () {
            
        });
          
    }
}