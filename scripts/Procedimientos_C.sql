#Creacion procedimiento insert ALUMNOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ALUMNOS_C`(IN `IN_NOMBRE` VARCHAR(45),
                                                            IN `IN_PAPELLIDO` VARCHAR(45), 
                                                            IN `IN_SAPELLIDO` VARCHAR(45), 
                                                            IN `IN_TELEFONO` VARCHAR(13), 
                                                            IN `IN_DNI` CHAR(9),
                                                            IN `IN_IDUSUARIO` INT)
INSERT INTO ALUMNOS A (A.NOMBRE, A.PAPELLIDO, A.SAPELLIDO, A.TELEFONO, A.DNI, A.IDUSUARIO)
values(IN_NOMBRE, IN_PAPELLIDO, IN_SAPELLIDO, IN_TELEFONO, IN_DNI, IN_IDUSUARIO)$$
DELIMITER ;

#Creacion procedimiento insert LIBROS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROS_C`(IN `IN_TITULO` VARCHAR(180),
                                                           IN `IN_AUTOR` VARCHAR(90), 
                                                           IN `IN_NUMPAGINAS` INT,
                                                           IN `IN_ISBN` CHAR(17))
INSERT INTO LIBROS L (L.TITULO, L.AUTOR, L.NUMPAGINAS, L.ISBN)
values(IN_TITULO, IN_AUTOR, IN_NUMPAGINAS, IN_ISBN)$$
DELIMITER ;

#Creacion procedimiento insert USUARIOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_USUARIOS_C`(IN `IN_USUARIO` VARCHAR(20),
                                                             IN `IN_CONTRASENIA` CHAR(32))
INSERT INTO USUARIOS U (U.USUARIO, U.CONTRASENIA)
values(IN_USUARIO, MD5(IN_CONTRASENIA))$$
DELIMITER ;

#Creacion procedimiento insert LIBROSDEALUMNO
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROSDEALUMNO_C`(IN `IN_IDALUMNO` VARCHAR(20),
                                                                   IN `IN_IDLIBRO` CHAR(32))
INSERT INTO LIBROSDEALUMNO L (L.IDALUMNO, L.IDLIBRO)
values(IN_IDALUMNO, IN_IDLIBRO)$$
DELIMITER ;