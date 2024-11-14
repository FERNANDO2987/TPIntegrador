DELIMITER $$
CREATE PROCEDURE ModificarCuenta (IN nroCuentaIngresado BIGINT, IN idTipoCuentaIngresado int, IN borrado bit)
BEGIN
	UPDATE Cuentas SET id_tipo_cuenta = idTipoCuentaIngresado, deleted = borrado WHERE nro_cuenta = nroCuentaIngresado;
END;