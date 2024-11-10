DELIMITER $$

CREATE PROCEDURE AgregarCuenta(
    IN idClienteIngresado BIGINT,
    IN idTipoCuentaIngresada INT
)
BEGIN
    DECLARE cuentasActivas INT DEFAULT 0;
    DECLARE ultimoNroCuenta INT DEFAULT 0;
    DECLARE ultimoIdMovimiento INT DEFAULT 0;
    DECLARE saldo INT DEFAULT 0;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Ocurrio un error' AS mensaje;
    END;

    START TRANSACTION;
    
    -- Verificar si el id de cliente no supera 3 cuentas activadas
    SELECT COUNT(*) INTO cuentasActivas 
    FROM cuentas 
    WHERE id_cliente = idClienteIngresado AND deleted = 0;

    IF cuentasActivas < 3 THEN
        -- Crear Cuenta
        INSERT INTO cuentas (id_cliente, fecha_creacion, id_tipo_cuenta, cbu, saldo, createDate, deleteDate, deleted)
        VALUES (idClienteIngresado, CURDATE(), idTipoCuentaIngresada, 
                REPLACE(REPLACE(REPLACE(DATE_FORMAT(NOW(), '%Y%m%d%H%i%s'), '-', ''), ':', ''), ' ', ''), 
                0, CURDATE(), NULL, 0);

        -- Obtener el id de la cuenta recién creada
        SELECT LAST_INSERT_ID() INTO ultimoNroCuenta;
        
        -- Asignar saldo de 10000
        INSERT INTO movimientos(fecha, importe, tipo_movimiento, estado, createDate, deleted) 
        VALUES (CURDATE(), 10000, 1, 1, CURDATE(), 0);
        
        SELECT LAST_INSERT_ID() INTO ultimoIdMovimiento;
        
        INSERT INTO movimientosxcuenta(id_movimiento, nro_cuenta, createDate, deleted) 
        VALUES (ultimoIdMovimiento, ultimoNroCuenta, CURDATE(), 0);
        
        -- Obtener el saldo actual de la cuenta
        SELECT saldo INTO saldo FROM cuentas WHERE nro_cuenta = ultimoNroCuenta;
        
        -- Actualizar saldo
        UPDATE cuentas 
        SET saldo = saldo + 10000 
        WHERE nro_cuenta = ultimoNroCuenta;
	ELSE
		SELECT 'Se excedio el limite de cuentas' as mensaje;
    END IF;

    COMMIT;
END;
$$
