#Creacion procedimiento select ALUMNOS
#Procedimiento para la obtención de datos de la tabla Alumnos del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_R`(
    IN `PID` INT(11)
)
SELECT A.ID, A.NOMBRE, A.PAPELLIDO, A.SAPELLIDO, A.TELEFONO, A.DNI, A.IDUSUARIO FROM ALUMNOS A WHERE A.ID = PID$$

#Creacion procedimiento select ALUMNOS
#Procedimiento para la obtención de datos de la tabla Alumnos de todos los registros 
#devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_R_TODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_R_TODOS`()
SELECT A.ID, A.NOMBRE, A.PAPELLIDO, A.SAPELLIDO, A.TELEFONO, A.DNI, A.IDUSUARIO FROM ALUMNOS A$$

#Creacion procedimiento select LIBROS
#Procedimiento para la obtención de datos de la tabla Libros del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_R`(
    IN `PID` INT(11)
)
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ESTADO, L.ISBN FROM LIBROS L WHERE L.ID = PID$$

#Creacion procedimiento select LIBROS
#Procedimiento para la obtención de datos de la tabla Libros de todos los registros 
#devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROS_RTODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_RTODOS`()
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ESTADO, L.ISBN FROM LIBROS L$$

#Creacion procedimiento select LIBROSDEALUMNO
#Procedimiento para la obtención de datos de la tabla LibrosDeAlumno del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROSDEALUMNO_R`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROSDEALUMNO_R`(
 IN `PID` INT(11)
)
SELECT L.ID, L.IDALUMNO, L.IDLIBRO FROM LIBROSDEALUMNO L WHERE L.ID = PID$$

#Creacion procedimiento select USUARIOS
#Procedimiento para la obtención de datos de la tabla Usuarios del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_USUARIOS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_USUARIOS_R`(
    IN `PID` INT(11)
)
SELECT U.ID, U.USUARIO, U.CONTRASENIA, U.ADMIN FROM USUARIOS U WHERE U.ID = PID$$

#Creacion procedimiento verificacion de login USUARIOS
#Procedimiento que devuelve todos los datos de un registro de la tabla Usuarios
#cuando el usuario y la contrasenia ingresados como argumentos son iguales
#a los del registro
DROP PROCEDURE IF EXISTS `USP_USUARIOSLOGIN_R`;
DELIMITER $$
CREATE PROCEDURE `USP_USUARIOSLOGIN_R`(
    IN `PUSUARIO` VARCHAR(20),
    IN `PCONTRASENIA` VARCHAR(32)
)
SELECT U.ID, U.USUARIO, U.ADMIN FROM USUARIOS U WHERE U.USUARIO = PUSUARIO AND U.CONTRASENIA = MD5(PCONTRASENIA)$$

DROP PROCEDURE IF EXISTS `USP_LIBROS_USUARIO_R_TODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_USUARIO_R_TODOS`(
    IN `PIDUSUARIO` INT(11)
)
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ISBN FROM LIBROS L
INNER JOIN (SELECT D.IDLIBRO FROM LIBROSDEALUMNO D WHERE D.IDALUMNO = (SELECT A.ID FROM ALUMNOS A WHERE A.IDUSUARIO = PIDUSUARIO)) R
ON R.IDLIBRO = L.ID$$