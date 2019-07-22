CREATE DATABASE `PRESTAMO_LIBROS`;

#Creacion tabla Alumnos
CREATE TABLE `PRESTAMO_LIBROS`.`ALUMNOS` ( `ID` INT NOT NULL AUTO_INCREMENT ,
                                           `NOMBRE` VARCHAR(45) NOT NULL ,
                                           `PAPELLIDO` VARCHAR(45) NOT NULL ,
                                           `SAPELLIDO` VARCHAR(45) NOT NULL ,
                                           `TELEFONO` VARCHAR(13) NOT NULL ,
                                           `DNI` CHAR(9) NOT NULL ,
                                           `IDUSUARIO` INT, 
                                           PRIMARY KEY (`ID`),
                                           UNIQUE (`DNI`),
                                           UNIQUE (`IDUSUARIO`));

#Creacion tabla Usuarios
CREATE TABLE `PRESTAMO_LIBROS`.`USUARIOS` ( `ID` INT NOT NULL AUTO_INCREMENT ,
                                            `USUARIO` VARCHAR(20) NOT NULL ,
                                            `CONTRASENIA` CHAR(32) NOT NULL ,
                                            `ADMIN` ENUM('0','1') NOT NULL DEFAULT '0' ,
                                            PRIMARY KEY (`ID`),
                                            UNIQUE (`USUARIO`));

#Creacion tabla Libros
CREATE TABLE `PRESTAMO_LIBROS`.`LIBROS` ( `ID` INT NOT NULL AUTO_INCREMENT ,
                                          `TITULO` VARCHAR(180) NOT NULL ,
                                          `AUTOR` VARCHAR(90) NOT NULL ,
                                          `NUMPAGINAS` INT NOT NULL ,
                                          `ESTADO` ENUM('0','1') NOT NULL DEFAULT '1' ,
                                          `ISBN` CHAR(17) NOT NULL ,
                                          PRIMARY KEY (`ID`), 
                                          UNIQUE (`ISBN`));

#Creacion tabla LIBROSDEUSUARIO
CREATE TABLE `PRESTAMO_LIBROS`.`LIBROSDEALUMNO` ( `ID` INT NOT NULL AUTO_INCREMENT ,
                                                  `IDALUMNO` INT NOT NULL ,
                                                  `IDLIBRO` INT NOT NULL ,
                                                  PRIMARY KEY (`ID`),
                                                  UNIQUE (`IDLIBRO`));