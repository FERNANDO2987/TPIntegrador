DELIMITER $$
create procedure ListarCuentaXNroCuenta (IN nroCuenta bigint)
begin
	select cuentas.nro_cuenta, cuentas.cbu, cuentas.id_cliente, clientes.nombre, clientes.apellido, cuentas.id_tipo_cuenta, tiposcuenta.descripcion, cuentas.deleted from cuentas left join clientes on clientes.id = cuentas.id_cliente left join tiposcuenta on tiposcuenta.id = cuentas.id_tipo_cuenta where nro_cuenta = nroCuenta;
end
$$