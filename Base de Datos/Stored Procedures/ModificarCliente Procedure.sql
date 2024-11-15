

DELIMITER $$
CREATE PROCEDURE ModificarCliente (IN idIngresado BIGINT, IN dniIngresado INT, IN cuilIngresado INT, IN nombreIngresado VARCHAR(255), IN apellidoIngresado VARCHAR(255), IN sexoIngresado VARCHAR(50))
BEGIN
	UPDATE clientes SET dni = dniIngresado, cuil = cuilIngresado, nombre = nombreIngresado, apellido = apellidoIngresado, sexo = sexoIngresado WHERE ID = idIngresado;
END;
