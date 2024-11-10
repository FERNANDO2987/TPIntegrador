DELIMITER $$
CREATE PROCEDURE ModificarCuenta (IN nroCuentaIngresado BIGINT, IN idTipoCuentaIngresado int)
BEGIN
	UPDATE Cuentas SET id_tipo_cuenta = idTipoCuentaIngresado WHERE nro_cuenta = nroCuentaIngresado;
END;