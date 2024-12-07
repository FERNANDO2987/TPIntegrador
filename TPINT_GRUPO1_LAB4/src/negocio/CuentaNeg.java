package negocio;

import java.util.List;

import entidad.Cuenta;
import entidad.Movimiento;

public interface CuentaNeg {

	public boolean agregarCuenta(Cuenta cuenta);
	public List<Cuenta> obtenerCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public boolean darDeBajaCuenta(Long nrocuenta);
	public Cuenta obtenerCuentaXNroCuenta(Long nroCuenta);
	public List<Cuenta> obtenerCuentasXIdCliente_2(int idCLiente);
	public List<Cuenta> obtenerCuentasXIdCliente(int id);
	public Cuenta obtenerCuentaXCBU(String cbu);
	public List<Movimiento> listarMovimientosXCuenta(long idCuenta);
}
