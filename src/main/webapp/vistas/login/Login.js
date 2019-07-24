var Login = {
    cargarModulo: function () {        
        $('#buttonLogin').unbind('click').bind('click', function (event) {
            event.preventDefault();
            
            $.ajax({
                url:'http://localhost:8080/biblioSPA/ControladorLogin',
                method: 'POST',
                data: {
                    ACCION: "login",
                    usuario: $('#usuario').val(),
                    contrasenia: $('#contrasenia').val()
                }
            }).done(function(){
                //$('div.container').html(arguments[0]);
//                $.getScript('./vistas/formularios/RegistroAlumno.js').done(function() {
//                    console.log("archivos cargados");
//                });
            }).fail(function() {
                alert("Error");
            });
        });
        
        $('#buttonRegistrar').unbind('click').bind('click', function (event) {
            event.preventDefault();
            
            $.ajax({
                url:'http://localhost:8080/biblioSPA/ControladorLogin',
                method: 'POST',
                data: {
                    ACCION: "vistaRegistrar"
                }
            }).done(function(){
                $('div.container').html(arguments[0]);
//                $.getScript('./vistas/formularios/RegistroAlumno.js').done(function() {
//                    console.log("archivos cargados");
//                });
            }).fail(function() {
                alert("Error");
            });
        });
    }
}