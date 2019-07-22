$('#buttonLogin').unbind().bind('click', function (event) {
    event.preventDefault();
    Login.entrar();
});

$('#buttonRegistrar').unbind().bind('click', function (event) {
    event.preventDefault();
    Login.registrarAlumno();
});

var Login = {
    entrar: function () {
        console.log("estoy logueado");
    },
    registrarAlumno: function () {
//        $usuario = $('#usuario').val();
//        $contrasenia = $('#contrasenia').val();
        
//        $.ajax({
//            url: "http://localhost:8080/biblioSPA/Controlador",
//            method: "POST",
//            data: JSON.stringify({
//                ACCION: 'login',
//                usuario: $usuario, 
//                contrasenia: $contrasenia
//            })
////            data: {
////                ACCION: 'login',
////                usuario: $usuario,
////                contrasenia: $contrasenia
////            }
//        }).done(function () {
//            $('div.container').html(arguments[0]);
//        });

        $.ajax({
            url:"http://localhost:8080/biblioSPA/vistas/formularios/RegistroAlumno.jsp"
        }).done(function(){
            $('div.container').html(arguments[0]);
        });
    }
}