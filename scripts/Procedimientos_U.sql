#Creacion procedimiento update ALUMNOS
#Procedimiento que permite la modificación de un registro de la tabla Alumnos con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_U`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_U`(
    IN `PID` INT(11),
    IN `PNOMBRE` VARCHAR(45),
    IN `PPAPELLIDO` VARCHAR(45), 
    IN `PSAPELLIDO` VARCHAR(45), 
    IN `PTELEFONO` VARCHAR(13), 
    IN `PDNI` CHAR(9),
    IN `PIDUSUARIO` INT(11)
)
UPDATE ALUMNOS A SET A.NOMBRE = PNOMBRE, A.PAPELLIDO = PPAPELLIDO, A.SAPELLIDO = PSAPELLIDO, A.TELEFONO = PTELEFONO, A.DNI = PDNI, A.IDUSUARIO = PIDUSUARIO
WHERE A.ID = PID$$

#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla Libros con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DROP PROCEDURE IF EXISTS `USP_LIBROS_U`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_U`(
    IN `PID` INT(11),
    IN `PTITULO` VARCHAR(180),
    IN `PAUTOR` VARCHAR(90), 
    IN `PNUMPAGINAS` INT(4),
    IN `PISBN` CHAR(17)
)
UPDATE LIBROS L SET L.TITULO = PTITULO, L.AUTOR = PAUTOR, L.NUMPAGINAS = PNUMPAGINAS, L.ISBN = PISBN
WHERE L.ID = PID$$

#Creacion procedimiento update USUARIOS
#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla Usuarios con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DROP PROCEDURE IF EXISTS `USP_USUARIOS_U`;
DELIMITER $$
CREATE PROCEDURE `USP_USUARIOS_U`(
    IN `PID` INT(11),
    IN `PUSUARIO` VARCHAR(20),
    IN `PCONTRASENIA` CHAR(32)
)
UPDATE USUARIOS U SET U.USUARIO = PUSUARIO, U.CONTRASENIA = PCONTRASENIA
WHERE U.ID = PID$$

#Creacion procedimiento update LIBROSDEALUMNO
#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla LibrosDeAlumno con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DROP PROCEDURE IF EXISTS `USP_LIBROSDEALUMNO_U`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROSDEALUMNO_U`(
    IN `PID` INT(11),
    IN `PIDALUMNO` INT(11),
    IN `PIDLIBRO` INT(11)
)
UPDATE LIBROSDEALUMNO L SET L.IDALUMNO = PIDALUMNO, L.IDLIBRO = PIDLIBRO
WHERE L.ID = PID$$