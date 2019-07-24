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