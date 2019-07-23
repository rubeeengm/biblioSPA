#Creacion procedimiento update ALUMNOS
#Procedimiento que permite la modificación de un registro de la tabla Alumnos con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ALUMNOS_U`(
    IN `IN_ID` INT(11),
    IN `IN_NOMBRE` VARCHAR(45),
    IN `IN_PAPELLIDO` VARCHAR(45), 
    IN `IN_SAPELLIDO` VARCHAR(45), 
    IN `IN_TELEFONO` VARCHAR(13), 
    IN `IN_DNI` CHAR(9),
    IN `IN_IDUSUARIO` INT(11)
)
UPDATE ALUMNOS A SET A.NOMBRE = IN_NOMBRE, A.PAPELLIDO = IN_PAPELLIDO, A.SAPELLIDO = IN_SAPELLIDO, A.TELEFONO = IN_TELEFONO, A.DNI = IN_DNI, A.IDUSUARIO = IN_IDUSUARIO
WHERE A.ID = IN_ID$$

#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla Libros con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROS_U`(
    IN `IN_ID` INT(11),
    IN `IN_TITULO` VARCHAR(180),
    IN `IN_AUTOR` VARCHAR(90), 
    IN `IN_NUMPAGINAS` INT(4),
    IN `IN_ISBN` CHAR(17)
)
UPDATE LIBROS L SET L.TITULO = IN_TITULO, L.AUTOR = IN_AUTOR, L.NUMPAGINAS = IN_NUMPAGINAS, L.ISBN = IN_ISBN
WHERE L.ID = IN_ID$$

#Creacion procedimiento update USUARIOS
#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla Usuarios con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_USUARIOS_U`(
    IN `IN_ID` INT(11),
    IN `IN_USUARIO` VARCHAR(20),
    IN `IN_CONTRASENIA` CHAR(32)
)
UPDATE USUARIOS U SET U.USUARIO = IN_USUARIO, U.CONTRASENIA = IN_CONTRASENIA
WHERE U.ID = IN_ID$$

#Creacion procedimiento update LIBROSDEALUMNO
#Creacion procedimiento update LIBROS
#Procedimiento que permite la modificación de un registro de la tabla LibrosDeAlumno con
#todos los datos recibidos en argumentos, además que sólo al registro cuyo id
#es el mismo que el que se recibió como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROSDEALUMNO_U`(
    IN `IN_ID` INT(11),
    IN `IN_IDALUMNO` INT(11),
    IN `IN_IDLIBRO` INT(11)
)
UPDATE LIBROSDEALUMNO L SET L.IDALUMNO = IN_IDALUMNO, L.IDLIBRO = IN_IDLIBRO
WHERE L.ID = IN_ID$$