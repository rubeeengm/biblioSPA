#Creacion procedimiento registro de Alumno y Usuario
#Se hizo un procedimiento que dentro lleva una transacción debido a que el registro
#de alumnos y usuarios se realizan en conjunto, primero se insertan los datos en la
#tabla Usuarios y luego en la tabla Alumnos, usando los datos que se recibieron como argumentos.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ALUMNOSUSUARIOS_C`(
    IN `IN_NOMBRE` VARCHAR(45),
    IN `IN_PAPELLIDO` VARCHAR(45),
    IN `IN_SAPELLIDO` VARCHAR(45),
    IN `IN_TELEFONO` VARCHAR(13), 
    IN `IN_DNI` CHAR(9), 
    IN `IN_USUARIO` VARCHAR(20),
    IN `IN_CONTRASENIA` CHAR(32)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            INSERT INTO USUARIOS (USUARIO, CONTRASENIA) 
            values(IN_USUARIO, MD5(IN_CONTRASENIA));
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
            IN_NOMBRE, 
            IN_PAPELLIDO, 
            IN_SAPELLIDO, 
            IN_TELEFONO, 
            IN_DNI, 
            (
                SELECT ID
                FROM USUARIOS 
                WHERE USUARIO = IN_USUARIO
            )
        );
    COMMIT;
END $$

#Creacion procedimiento insert LIBROSDEALUMNO
#Procedimiento que inserta un registro en la tabla libros de alumno y cambia el
#estado del libro cuyo id es igual al id que se recibió como argumento en la tabla
#de libros a 0, de manera que se registre ocupado y se crée el vínculo entre el alumno
#y el libro.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROSDEALUMNO_C`(
    IN `IN_IDALUMNO` INT(11),
    IN `IN_IDLIBRO` INT(11)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            INSERT INTO LIBROSDEALUMNO (IDALUMNO, IDLIBRO)
            values(IN_IDALUMNO, IN_IDLIBRO);
        COMMIT;
        UPDATE LIBROS L SET L.ESTADO = '0' WHERE L.ID = IN_IDLIBRO;
    COMMIT;
END $$

#Creacion procedimiento delete LIBROSDEALUMNO
#Procedimiento que elimina un registro en la tabla libros de alumno y cambia el
#estado del libro cuyo id es igual al id que se recibió como argumento en la tabla
#de libros a 1, de manera que se registre libre y se elimine el vínculo entre el alumno
#y el libro.
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROSDEALUMNO_D`(
    IN `IN_IDLIBRO` INT(11)
)
BEGIN
    START TRANSACTION;
        START TRANSACTION;
            DELETE FROM LIBROSDEALUMNO WHERE IDLIBRO = IN_IDLIBRO;
        COMMIT;
        UPDATE LIBROS L SET L.ESTADO = '1' WHERE L.ID = IN_IDLIBRO;
    COMMIT;
END$$