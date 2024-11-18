package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datos.CuentaDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.CuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;

public class Main {

	public static void main(String[] args) {
		
	    CuentaDao cuentaDao = new CuentaDaoImpl();
	    List<Cuenta> lista = new ArrayList<Cuenta>();
	    lista = cuentaDao.obtenerCuentas();
	    for (Cuenta cuenta : lista)
	    {
	    	System.out.println(cuenta.toString());
	    }

	}
}
