#Creacion tabla Usuarios
#Usuario de 20 caracteres máximo
#Contrasenia pasada por MD5 por lo que se usan los 32 caracteres
#Admin será una bandera controladora para poder distinguir el usuario que se
#registrará de Admin con los demás, siendo 0 un usuario normal y 1 para Admin.
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`USUARIOS` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT ,
    `USUARIO` VARCHAR(20) NOT NULL ,
    `CONTRASENIA` CHAR(32) NOT NULL ,
    `ADMIN` ENUM('0','1') NOT NULL DEFAULT '0' ,
    PRIMARY KEY PK_USUARIOS_ID(`ID`),
    UNIQUE UN_USUARIOS_USUARIO(`USUARIO`)
);

#Creacion tabla Alumnos
#Nombre de 45 caracteres máximo
#PApellido es para el primer apellido, 45 caracteres máximo
#SApellido es para el segundo apellido, 45 caracteres máximo
#Telefono 13 caracteres máximo, para telefonos 0442299120504 por ejemplo
#DNI es el documento nacional de identidad, formado normalmente por 8
#caracteres numericos y uno, al final, alfabetico
#IDUSUARIO es la llave foránea que relaciona ambas tablas
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`ALUMNOS` (
    `ID` INT(11) NOT NULL AUTO_INCREMENT ,
    `NOMBRE` VARCHAR(45) NOT NULL ,
    `PAPELLIDO` VARCHAR(45) NOT NULL ,
    `SAPELLIDO` VARCHAR(45) NOT NULL ,
    `TELEFONO` VARCHAR(13) NOT NULL ,
    `DNI` CHAR(9) NOT NULL ,
    `IDUSUARIO` INT(11), 
    PRIMARY KEY PK_ALUMNOS_ID(`ID`),
    UNIQUE UN_ALUMNOS_DNI(`DNI`),
    UNIQUE UN_ALUMNOS_IDUSUARIO(`IDUSUARIO`),
    FOREIGN KEY FK_ALUMNOS_IDUSUARIO(`IDUSUARIO`) REFERENCES `USUARIOS`(`ID`) ON DELETE CASCADE
);

#Creacion tabla Libros
#Titulo de 180 caracteres máximo
#Autor de 90 caracteres máximo
#NumPaginas de 0 a 9999 páginas
#Estado se manejará con 0 y 1, como bandera para señalar si está disponible
#para ser tomado prestado por el alumno, 0 para ocupado y 1 para libre
#ISBN es una referencia unica de cada libro, formada por 13 caracteres numericos
#y guiones, pero se manejará sin su division de guiones, sólo números
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`LIBROS` ( 
    `ID` INT(11) NOT NULL AUTO_INCREMENT ,
    `TITULO` VARCHAR(180) NOT NULL ,
    `AUTOR` VARCHAR(90) NOT NULL ,
    `NUMPAGINAS` INT(4) NOT NULL ,
    `ESTADO` ENUM('0','1') NOT NULL DEFAULT '1' ,
    `ISBN` CHAR(13) NOT NULL ,
    PRIMARY KEY PK_LIBROS_ID(`ID`), 
    UNIQUE UN_LIBROS_ISBN(`ISBN`)
);

#Creacion tabla LIBROSDEUSUARIO
#IdAlumno llave foránea que hace referencia al ID de la tabla Alumnos
#IdLibro llave foránea que hace referencia al ID de la tabla Libros
CREATE TABLE IF NOT EXISTS `PRESTAMO_LIBROS`.`LIBROSDEALUMNO` ( 
    `ID` INT(11) NOT NULL AUTO_INCREMENT ,
    `IDALUMNO` INT(11) NOT NULL ,
    `IDLIBRO` INT(11) NOT NULL ,
    PRIMARY KEY PK_LIBROSDEALUMNO_ID(`ID`),
    UNIQUE UN_LIBROSDEALUMNO_IDLIBRO(`IDLIBRO`),
    FOREIGN KEY FK_LIBROSDEALUMNO_IDALUMNO(`IDALUMNO`) REFERENCES `ALUMNOS`(`ID`),
    FOREIGN KEY FK_LIBROSDEALUMNO_IDLIBRO(`IDLIBRO`) REFERENCES `LIBROS`(`ID`) ON DELETE CASCADE
);