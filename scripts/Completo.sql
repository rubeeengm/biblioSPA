CREATE DATABASE PRESTAMO_LIBROS;
USE PRESTAMO_LIBROS;
CREATE USER 'pruebas'@'localhost' IDENTIFIED BY '1234qwer';
GRANT SELECT, EXECUTE ON PRESTAMO_LIBROS.* TO 'pruebas'@'localhost';

#Creacion tabla Usuarios
#Usuario de 20 caracteres máximo
#Contrasenia pasada por MD5 por lo que se usan los 32 caracteres
#Admin será una bandera controladora para poder distinguir el usuario que se
#registrará de Admin con los demás, siendo 0 un usuario normal y 1 para Admin.
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`USUARIOS` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'IDENTIFICADOR UNICO DEL USUARIO',
    `USUARIO` VARCHAR(20) NOT NULL COMMENT 'NOMBRE DE USUARIO PARA EL LOGIN',
    `CONTRASENIA` CHAR(32) NOT NULL COMMENT 'CONTRASENIA DEL USUARIO PASADA 
											POR MD5 PARA UN ALMACENAJE MAS SEGURO',
    `ADMIN` ENUM('0','1') NOT NULL DEFAULT '0' COMMENT 'BANDERA QUE PERMITE 
												LA DIFERENCIACION DE PERMISOS, 
                                                1 PARA LOS ADMINISTRADORES, 0 
                                                PARA LOS USUARIOS COMUNES',
    PRIMARY KEY PK_USUARIOS_ID(`ID`),
    UNIQUE UN_USUARIOS_USUARIO(`USUARIO`)
) COMMENT 'TABLA PARA LA INFORMACION DE LOGIN DE LOS USUARIOS';

#Creacion tabla Alumnos
#Nombre de 45 caracteres máximo
#PApellido es para el primer apellido, 45 caracteres máximo
#SApellido es para el segundo apellido, 45 caracteres máximo
#Telefono 13 caracteres máximo, para telefonos 0442299120504 por ejemplo
#DNI es el documento nacional de identidad, formado normalmente por 8
#caracteres numericos y uno, al final, alfabetico
#IDUSUARIO es la llave foránea que relaciona ambas tablas
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`ALUMNOS` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'IDENTIFICADOR UNICO DEL ALUMNO',
    `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'NOMBRE DEL ALUMNO',
    `PAPELLIDO` VARCHAR(45) NOT NULL COMMENT 'PRIMER APELLIDO DEL ALUMNO',
    `SAPELLIDO` VARCHAR(45) NOT NULL COMMENT 'SEGUNDO APELLIDO DEL ALUMNO',
    `TELEFONO` VARCHAR(13) NOT NULL COMMENT 'TELEFONO DEL ALUMNO, DESDE NUMEROS 
											COMO 123456789 HASTA 2291234567 O 0442291234567, 
											SOLO NUMEROS',
    `DNI` CHAR(9) NOT NULL COMMENT 'DOCUMENTO NACIONAL DE IDENTIFICACION, FORMADO 
									POR 8 NUMEROS Y UNA LETRA AL FINAL, POR EJEMPLO 12345678A',
    `IDUSUARIO` INT(11) COMMENT 'LLAVE FORANEA QUE HACE REFERENCIA AL ID DE UN REGISTRO DE 
									LA TABLA USUARIOS', 
    PRIMARY KEY PK_ALUMNOS_ID(`ID`),
    UNIQUE UN_ALUMNOS_DNI(`DNI`),
    UNIQUE UN_ALUMNOS_IDUSUARIO(`IDUSUARIO`),
    FOREIGN KEY FK_ALUMNOS_IDUSUARIO(`IDUSUARIO`) REFERENCES `USUARIOS`(`ID`) ON DELETE CASCADE
) COMMENT 'TABLA PARA LA INFORMACION GENERAL DEL ALUMNO Y QUE LLEVA COMO MUESTRA DE SU 
									RELACION CON USUARIO UNA LLAVE FORANEA PARA ELLO';

#Creacion tabla Libros
#Titulo de 180 caracteres máximo
#Autor de 90 caracteres máximo
#NumPaginas de 0 a 9999 páginas
#Estado se manejará con 0 y 1, como bandera para señalar si está disponible
#para ser tomado prestado por el alumno, 0 para ocupado y 1 para libre
#ISBN es una referencia unica de cada libro, formada por 13 caracteres numericos
#y guiones, pero se manejará sin su division de guiones, sólo números
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`LIBROS` ( 
    `ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'IDENTIFICADOR UNICO DE LOS LIBROS',
    `TITULO` VARCHAR(180) NOT NULL COMMENT 'TITULO DEL LIBRO',
    `AUTOR` VARCHAR(90) NOT NULL COMMENT 'AUTOR, NOMBRE Y APELLIDO, DEL LIBRO',
    `NUMPAGINAS` INT(4) NOT NULL COMMENT 'NUMERO DE PAGINAS DEL LIBRO, DE 1 A 9999',
    `ESTADO` ENUM('0','1') NOT NULL DEFAULT '1' COMMENT 'BANDERA PARA LA DIFERENCIACION 
												DE LOS LIBROS OCUPADOS Y LOS LIBRES, 0 
												PARA LOS OCUPADOS, 1 PARA LOS LIBRES',
    `ISBN` CHAR(13) NOT NULL COMMENT 'ISBN DEL LIBRO, FORMADO UNICAMENTE POR NUMEROS, 
												SIN INCLUIR GUIONES, FORMADO POR 13 O 
                                                10 DIGITOS',
    PRIMARY KEY PK_LIBROS_ID(`ID`), 
    UNIQUE UN_LIBROS_ISBN(`ISBN`)
) COMMENT 'TABLA PARA LA INFORMACION DE LOS LIBROS A SER PRESTADOS';

#Creacion tabla LIBROSDEUSUARIO
#IdAlumno llave foránea que hace referencia al ID de la tabla Alumnos
#IdLibro llave foránea que hace referencia al ID de la tabla Libros
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`LIBROSDEALUMNO` ( 
    `ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'IDENTIFICADOR UNICO DE LOS REGISTROS 
													DE LA TABLA',
    `IDALUMNO` INT(11) NOT NULL COMMENT 'LLAVE FORANEA PARA LA REFERENCIA A UN REGISTRO 
													DE LA TABLA ALUMNOS',
    `IDLIBRO` INT(11) NOT NULL COMMENT 'LLAVE FORANEA PARA LA REFERENCIA A UN REGISTRO 
													DE LA TABLA LIBROS',
    PRIMARY KEY PK_LIBROSDEALUMNO_ID(`ID`),
    UNIQUE UN_LIBROSDEALUMNO_IDLIBRO(`IDLIBRO`),
    FOREIGN KEY FK_LIBROSDEALUMNO_IDALUMNO(`IDALUMNO`) REFERENCES `ALUMNOS`(`ID`),
    FOREIGN KEY FK_LIBROSDEALUMNO_IDLIBRO(`IDLIBRO`) REFERENCES `LIBROS`(`ID`) ON DELETE CASCADE
) COMMENT 'TABLA PARA LA INFORMACION DE LOS PRESTAMOS DE LIBROS, EL ALUMNO QUE 
												TIENE EL LIBRO Y LOS LIBROS PRESTADOS';

#Llenado de tabla USUARIOS
INSERT INTO USUARIOS (USUARIO, CONTRASENIA) VALUES("marquito", MD5("1234"));
INSERT INTO USUARIOS (USUARIO, CONTRASENIA) VALUES("jorgito", MD5("1234"));
INSERT INTO USUARIOS (USUARIO, CONTRASENIA) VALUES("rubencito", MD5("1234"));
INSERT INTO USUARIOS (USUARIO, CONTRASENIA) VALUES("ulicito", MD5("1234"));
INSERT INTO USUARIOS (USUARIO, CONTRASENIA) VALUES("israelito", MD5("1234"));
INSERT INTO USUARIOS (USUARIO, CONTRASENIA, ADMIN) VALUES("admin", MD5("1234"), '1');

#Llenado de tabla ALUMNOS
INSERT INTO ALUMNOS (NOMBRE, PAPELLIDO, SAPELLIDO, TELEFONO, DNI, IDUSUARIO) 
			VALUES("Marco", "Lopez", "Barrera", "9242043", "12121212A", 1);
INSERT INTO ALUMNOS (NOMBRE, PAPELLIDO, SAPELLIDO, TELEFONO, DNI, IDUSUARIO) 
			VALUES("Jorge", "Hernandez", "Navarrete", "9242044", "12121212B", 2);
INSERT INTO ALUMNOS (NOMBRE, PAPELLIDO, SAPELLIDO, TELEFONO, DNI, IDUSUARIO) 
			VALUES("Ruben", "Garcia", "Malaga", "9242045", "12121212C", 3);
INSERT INTO ALUMNOS (NOMBRE, PAPELLIDO, SAPELLIDO, TELEFONO, DNI, IDUSUARIO) 
			VALUES("Ulises", "Ponce", "Avila", "9242046", "12121212D", 4);
INSERT INTO ALUMNOS (NOMBRE, PAPELLIDO, SAPELLIDO, TELEFONO, DNI, IDUSUARIO) 
			VALUES("Israel", "Marcial", "Parra", "9242047", "12121212E", 5);

#Llenado de tabla LIBROS
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ESTADO, ISBN) 
			VALUES("Amores Perros", "Un mexicano", 100, '0', "1231231231231");
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ESTADO, ISBN) 
			VALUES("Nacho Libre", "Otro mexicano", 200, '0', "1231231231232");
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ESTADO, ISBN) 
			VALUES("Amarte Duele", "Un mexicano", 300, '0', "1231231231233");
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ESTADO, ISBN) 
			VALUES("Me Gusta Pero Me asusta", "Otro mexicano", 1000, '0', "1231231231234");
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ESTADO, ISBN) 
			VALUES("Toña La Negra", "Un mexicano", 50, '1', "1231231231235");

#Llenado de tabla LIBROSDEALUMNO
INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO) VALUES(1, 1);
INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO) VALUES(2, 2);
INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO) VALUES(3, 3);
INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO) VALUES(3, 4);

#Creacion procedimiento insert LIBROS
#Procedimiento utilizado en el registro de libros, la cual hace un simple insert
#con los datos que se recicen como argumentos, que son los atributos necesarios
#para la creación del registro titulo, autor, número de páginas, isbn.
DROP PROCEDURE IF EXISTS `USP_LIBROS_C`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_C`(
    IN `PTITULO` VARCHAR(180),
    IN `PAUTOR` VARCHAR(90), 
    IN `PNUMPAGINAS` INT(4),
    IN `PISBN` CHAR(17)
)
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ISBN)
values(PTITULO, PAUTOR, PNUMPAGINAS, PISBN)$$

#Creacion procedimiento delete ALUMNOS
#Procedimiento que realiza la eliminación de un registro de la tabla Alumnos, en
#base al id que se recibe como argumento.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_D`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_D`(
    IN `PID` INT(11)
)
DELETE FROM ALUMNOS WHERE ID = PID$$

#Creacion procedimiento delete LIBROS
#Procedimiento que realiza la eliminación de un registro de la tabla Libros, en
#base al id que se recibe como argumento.
DROP PROCEDURE IF EXISTS `USP_LIBROS_D`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_D`(
    IN `PID` INT(11)
)
DELETE FROM LIBROS WHERE ID = PID$$

#Creacion procedimiento delete USUARIOS
#Procedimiento que realiza la eliminación de un registro de la tabla Libros, en
#base al id que se recibe como argumento.
DROP PROCEDURE IF EXISTS `USP_USUARIOS_D`;
DELIMITER $$
CREATE PROCEDURE `USP_USUARIOS_D`(
    IN `PID` INT(11)
)
DELETE FROM USUARIOS WHERE ID = PID$$

#Creacion procedimiento select ALUMNOS
#Procedimiento para la obtención de datos de la tabla Alumnos del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_R`(
    IN `PID` INT(11)
)
SELECT A.ID, A.NOMBRE, A.PAPELLIDO, A.SAPELLIDO, A.TELEFONO, A.DNI, A.IDUSUARIO 
	FROM ALUMNOS A WHERE A.ID = PID$$

#Creacion procedimiento select ALUMNOS
#Procedimiento para la obtención de datos de la tabla Alumnos de todos los registros 
#devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_ALUMNOS_R_TODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOS_R_TODOS`()
SELECT A.ID, A.NOMBRE, A.PAPELLIDO, A.SAPELLIDO, A.TELEFONO, A.DNI, A.IDUSUARIO 
	FROM ALUMNOS A$$

#Creacion procedimiento select LIBROS
#Procedimiento para la obtención de datos de la tabla Libros del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_R`(
    IN `PID` INT(11)
)
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ESTADO, L.ISBN 
	FROM LIBROS L WHERE L.ID = PID$$

#Creacion procedimiento select LIBROS
#Procedimiento para la obtención de datos de la tabla Libros de todos los registros 
#devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROS_RTODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_RTODOS`()
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ESTADO, L.ISBN 
	FROM LIBROS L$$

#Creacion procedimiento select LIBROSDEALUMNO
#Procedimiento para la obtención de datos de la tabla LibrosDeAlumno del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_LIBROSDEALUMNO_R`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROSDEALUMNO_R`(
 IN `PID` INT(11)
)
SELECT L.ID, L.IDALUMNO, L.IDLIBRO 
	FROM LIBROSDEALUMNO L WHERE L.ID = PID$$

#Creacion procedimiento select USUARIOS
#Procedimiento para la obtención de datos de la tabla Usuarios del registro con id
#igual al que se recibió como argumento, devolviendo todos sus datos.
DROP PROCEDURE IF EXISTS `USP_USUARIOS_R`;
DELIMITER $$
CREATE PROCEDURE `USP_USUARIOS_R`(
    IN `PID` INT(11)
)
SELECT U.ID, U.USUARIO, U.CONTRASENIA, U.ADMIN 
	FROM USUARIOS U WHERE U.ID = PID$$

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
SELECT U.ID, U.USUARIO, U.ADMIN 
	FROM USUARIOS U WHERE U.USUARIO = PUSUARIO AND U.CONTRASENIA = MD5(PCONTRASENIA)$$

DROP PROCEDURE IF EXISTS `USP_LIBROS_USUARIO_R_TODOS`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROS_USUARIO_R_TODOS`(
    IN `PIDUSUARIO` INT(11)
)
SELECT L.ID, L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ISBN 
	FROM LIBROS L
INNER JOIN (SELECT D.IDLIBRO 
	FROM LIBROSDEALUMNO D WHERE D.IDALUMNO = (SELECT A.ID FROM ALUMNOS A WHERE A.IDUSUARIO = PIDUSUARIO)) R
ON R.IDLIBRO = L.ID$$

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
UPDATE ALUMNOS A 
	SET A.NOMBRE = PNOMBRE, 
		A.PAPELLIDO = PPAPELLIDO, 
        A.SAPELLIDO = PSAPELLIDO, 
        A.TELEFONO = PTELEFONO, 
        A.DNI = PDNI, 
        A.IDUSUARIO = PIDUSUARIO
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
UPDATE LIBROS L 
	SET L.TITULO = PTITULO, 
		L.AUTOR = PAUTOR, 
		L.NUMPAGINAS = PNUMPAGINAS, 
        L.ISBN = PISBN
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
UPDATE USUARIOS U 
	SET U.USUARIO = PUSUARIO, 
		U.CONTRASENIA = PCONTRASENIA
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
UPDATE LIBROSDEALUMNO L 
	SET L.IDALUMNO = PIDALUMNO, 
		L.IDLIBRO = PIDLIBRO
WHERE L.ID = PID$$

#Creacion procedimiento registro de Alumno y Usuario
#Se hizo un procedimiento que dentro lleva una transacción debido a que el registro
#de alumnos y usuarios se realizan en conjunto, primero se insertan los datos en la
#tabla Usuarios y luego en la tabla Alumnos, usando los datos que se recibieron como argumentos.
DROP PROCEDURE IF EXISTS `USP_ALUMNOSUSUARIOS_C`;
DELIMITER $$
CREATE PROCEDURE `USP_ALUMNOSUSUARIOS_C`(
    IN `PNOMBRE` VARCHAR(45),
    IN `PPAPELLIDO` VARCHAR(45),
    IN `PSAPELLIDO` VARCHAR(45),
    IN `PTELEFONO` VARCHAR(13), 
    IN `PDNI` CHAR(9), 
    IN `PUSUARIO` VARCHAR(20),
    IN `PCONTRASENIA` CHAR(32)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            INSERT INTO USUARIOS (USUARIO, CONTRASENIA) 
            values(PUSUARIO, MD5(PCONTRASENIA));
        COMMIT;
        INSERT INTO ALUMNOS (
            NOMBRE, 
            PAPELLIDO, 
            SAPELLIDO, 
            TELEFONO, 
            DNI, 
            IDUSUARIO
        ) 
        values(
            PNOMBRE, 
            PPAPELLIDO, 
            PSAPELLIDO, 
            PTELEFONO, 
            PDNI, 
            (
                SELECT ID
                FROM USUARIOS 
                WHERE USUARIO = PUSUARIO
            )
        );
    COMMIT;
END $$

#Creacion procedimiento insert LIBROSDEALUMNO
#Procedimiento que inserta un registro en la tabla libros de alumno y cambia el
#estado del libro cuyo id es igual al id que se recibió como argumento en la tabla
#de libros a 0, de manera que se registre ocupado y se crée el vínculo entre el alumno
#y el libro.
DROP PROCEDURE IF EXISTS `USP_LIBROSDEALUMNO_C`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROSDEALUMNO_C`(
    IN `PIDUSUARIO` INT(11),
    IN `PIDLIBRO` INT(11)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO)
            values((SELECT A.ID FROM ALUMNOS A WHERE A.IDUSUARIO = PIDUSUARIO), PIDLIBRO);
        COMMIT;
        UPDATE LIBROS L SET L.ESTADO = '0' WHERE L.ID = PIDLIBRO;
    COMMIT;
END $$

#Creacion procedimiento delete LIBROSDEALUMNO
#Procedimiento que elimina un registro en la tabla libros de alumno y cambia el
#estado del libro cuyo id es igual al id que se recibió como argumento en la tabla
#de libros a 1, de manera que se registre libre y se elimine el vínculo entre el alumno
#y el libro.
DROP PROCEDURE IF EXISTS `USP_LIBROSDEALUMNO_D`;
DELIMITER $$
CREATE PROCEDURE `USP_LIBROSDEALUMNO_D`(
    IN `PIDLIBRO` INT(11)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            DELETE FROM LIBROSDEALUMNO WHERE IDLIBRO = PIDLIBRO;
        COMMIT;
        UPDATE LIBROS L SET L.ESTADO = '1' WHERE L.ID = PIDLIBRO;
    COMMIT;
END$$