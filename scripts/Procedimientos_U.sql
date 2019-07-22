#Creacion procedimiento update ALUMNOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ALUMNOS_U`(IN `IN_ID` INT,
                                                            IN `IN_NOMBRE` VARCHAR(45),
                                                            IN `IN_PAPELLIDO` VARCHAR(45), 
                                                            IN `IN_SAPELLIDO` VARCHAR(45), 
                                                            IN `IN_TELEFONO` VARCHAR(13), 
                                                            IN `IN_DNI` CHAR(9),
                                                            IN `IN_IDUSUARIO` INT)
UPDATE ALUMNOS A SET A.NOMBRE = IN_NOMBRE, A.PAPELLIDO = IN_PAPELLIDO, A.SAPELLIDO = IN_SAPELLIDO, A.TELEFONO = IN_TELEFONO, A.DNI = IN_DNI, A.IDUSUARIO = IN_IDUSUARIO
WHERE A.ID = IN_ID$$
DELIMITER ;

#Creacion procedimiento update LIBROS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROS_U`(IN `IN_ID` INT,
                                                           IN `IN_TITULO` VARCHAR(180),
                                                           IN `IN_AUTOR` VARCHAR(90), 
                                                           IN `IN_NUMPAGINAS` INT,
                                                           IN `IN_ISBN` CHAR(17))
UPDATE LIBROS L SET L.TITULO = IN_TITULO, L.AUTOR = IN_AUTOR, L.NUMPAGINAS = IN_NUMPAGINAS, L.ISBN = IN_ISBN
WHERE L.ID = IN_ID$$
DELIMITER ;

#Creacion procedimiento update USUARIOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_USUARIOS_U`(IN `IN_ID` INT,
                                                             IN `IN_USUARIO` VARCHAR(20),
                                                             IN `IN_CONTRASENIA` CHAR(32))
UPDATE USUARIOS U SET U.USUARIO = IN_USUARIO, U.CONTRASENIA = IN_CONTRASENIA
WHERE U.ID = IN_ID$$
DELIMITER ;

#Creacion procedimiento update LIBROSDEALUMNO
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROSDEALUMNO_U`(IN `IN_ID` INT,
                                                                   IN `IN_IDALUMNO` VARCHAR(20),
                                                                   IN `IN_IDLIBRO` CHAR(32))
UPDATE LIBROSDEALUMNO L SET L.IDALUMNO = IN_IDALUMNO, L.IDLIBRO = IN_IDLIBRO
WHERE L.ID = IN_ID$$
DELIMITER ;