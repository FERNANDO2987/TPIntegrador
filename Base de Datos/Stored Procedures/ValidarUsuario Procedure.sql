DELIMITER $$

USE bdbanco

$$

CREATE PROCEDURE ValidarUsuario(IN usuarioIngresado VARCHAR(50), IN contraseniaIngresada VARCHAR(50))
BEGIN
    SELECT * FROM usuarios
    WHERE usuario = usuarioIngresado AND password = contraseniaIngresada;
END$$
