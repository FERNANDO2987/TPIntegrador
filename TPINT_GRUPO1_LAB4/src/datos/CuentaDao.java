package datos;

import java.util.List;

import entidad.Cuenta;
import entidad.Movimiento;

public interface CuentaDao {
	public boolean agregarCuenta(Cuenta cuenta);
	public List<Cuenta> obtenerCuentas();
	public boolean modificarCuenta(Cuenta cuenta);
	public boolean darDeBajaCuenta(Long nroCuenta);
	public Cuenta obtenerCuentaXNroCuenta(Long nroCuenta);
	public List<Cuenta> obtenerCuentasXIdCliente_2(int idCLiente);
	public List<Cuenta> obtenerCuentasXIdC1iente(int id);
	public Cuenta obtenerCuentaXCBU(String cbu);
	public List<Movimiento> listarMovimientosXCuenta(long idCuenta);
}
