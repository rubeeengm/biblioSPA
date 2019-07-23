#Creacion procedimiento delete ALUMNOS
#Procedimiento que realiza la eliminación de un registro de la tabla Alumnos, en
#base al id que se recibe como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ALUMNOS_D`(
    IN `IN_ID` INT(11)
)
DELETE FROM ALUMNOS WHERE ID = IN_ID$$

#Creacion procedimiento delete LIBROS
#Procedimiento que realiza la eliminación de un registro de la tabla Libros, en
#base al id que se recibe como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROS_D`(
    IN `IN_ID` INT(11)
)
DELETE FROM LIBROS WHERE ID = IN_ID$$

#Creacion procedimiento delete USUARIOS
#Procedimiento que realiza la eliminación de un registro de la tabla Libros, en
#base al id que se recibe como argumento.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_USUARIOS_D`(
    IN `IN_ID` INT(11)
)
DELETE FROM USUARIOS WHERE ID = IN_ID$$