DELIMITER $$
CREATE PROCEDURE EliminarCuenta ( IN nroCuentaIngresado BIGINT)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Ocurrio un error' AS mensaje;
    END;
	START TRANSACTION;
		UPDATE cuentas set deleted = 1, deleteDate = curdate() where nro_cuenta = nroCuentaIngresado;
    COMMIT;
END;
$$
