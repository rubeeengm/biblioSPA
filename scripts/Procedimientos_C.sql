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