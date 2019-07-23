#Creacion procedimiento insert LIBROS
#Procedimiento utilizado en el registro de libros, la cual hace un simple insert
#con los
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_LIBROS_C`(
    IN `IN_TITULO` VARCHAR(180),
    IN `IN_AUTOR` VARCHAR(90), 
    IN `IN_NUMPAGINAS` INT(4),
    IN `IN_ISBN` CHAR(17)
)
INSERT INTO LIBROS (TITULO, AUTOR, NUMPAGINAS, ISBN)
values(IN_TITULO, IN_AUTOR, IN_NUMPAGINAS, IN_ISBN)$$ datos que se recicen como argumentos, que son los atributos necesarios
#para la creación del registro titulo, autor, número de páginas, isbn.
DELIMITER $$