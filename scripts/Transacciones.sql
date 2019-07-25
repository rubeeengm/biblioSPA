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