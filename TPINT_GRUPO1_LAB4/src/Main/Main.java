package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datos.ClienteDao;
import datos.CuentaDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.CuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;

public class Main {

	public static void main(String[] args) {
		

		ClienteDao clienteDao = new ClienteDaoImpl();
		Cliente cliente = clienteDao.obtenerClientexId(new Long(1));
		System.out.println(cliente.toString());
	    /*CuentaDao cuentaDao = new CuentaDaoImpl();
	    List<Cuenta> lista = new ArrayList<Cuenta>();
	    lista = cuentaDao.obtenerCuentas();
	    for (Cuenta cuenta : lista)
	    {
	    	System.out.println(cuenta.toString());
	    }*/

	    Cliente cliente = new Cliente();
        cliente.setDni("11111111111111111");
        cliente.setCuil("21111111111111");
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setSexo("Masculino");
        cliente.setUsuario("juanperez45353");
        cliente.setPassword("password33333123");
        cliente.setFechaNacimiento(new Date()); // Fecha de nacimiento actual como ejemplo
        cliente.setCorreo("juan.perez@example.com");
        cliente.setTelefono("123789");
        cliente.setCelular("98321");
        cliente.setAdmin(true);

        // Crear el objeto ClienteDaoImpl para agregar al cliente
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        
        // Llamar al método para agregar el cliente
        boolean resultado = clienteDao.agregarCliente(cliente);
        
        if (resultado) {
            System.out.println("Cliente agregado exitosamente!");
        } else {
            System.out.println("Error al agregar el cliente.");
        }
    


	}
}
