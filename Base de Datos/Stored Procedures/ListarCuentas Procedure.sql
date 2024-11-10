DELIMITER $$
CREATE PROCEDURE ListarCuentas()
BEGIN
	SELECT nro_cuenta, id_cliente, fecha_creacion, id_tipo_cuenta, tiposcuenta.descripcion as descripcion, cbu, saldo FROM cuentas LEFT JOIN tiposcuenta ON tiposcuenta.id = id_tipo_cuenta; 
END;

$$