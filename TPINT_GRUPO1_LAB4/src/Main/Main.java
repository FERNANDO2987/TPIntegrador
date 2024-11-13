package Main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.ClienteDao;
import datos.CuentaDao;
import datos.TipoCuentaDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.CuentaDaoImpl;
import datosImpl.PaisDaoImpl;
import datosImpl.TipoCuentaDaoImpl;
import datosImpl.UsuarioDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Pais;
import entidad.TipoCuenta;
import entidad.Usuario;


public class Main {

	public static void main(String[] args) {
		
		/*CuentaDao cuentaDao = new CuentaDaoImpl();
		Cuenta cuenta = new Cuenta();
		cuenta = cuentaDao.obtenerCuentaXNroCuenta(Long.parseLong("5"));
		System.out.println(cuenta.toString());*/
		
		
//		List<Cuenta> lista = new ArrayList<Cuenta>();
//		CuentaDao cuentaDao = new CuentaDaoImpl();
//		lista = cuentaDao.obtenerCuentas();
//		System.out.println(lista.size());
//		for (Cuenta cuenta : lista)
//		{
//			System.out.println(cuenta.toString());
//		}
		
		//ClienteDao clienteDao = new ClienteDaoImpl();
		//Cliente cliente = new Cliente();
		//cliente = clienteDao.obtenerClientexId((long) 1);
		//System.out.println(cliente.toString());
		
		

//	      ClienteDaoImpl clienteDAO = new ClienteDaoImpl(); // Cambia esto a tu implementación concreta
//
//	        // Crear un nuevo cliente
//	        Cliente nuevoCliente = new Cliente();
//	        nuevoCliente.setId(0); // Si el id es autoincremental, establecer en 0 o un valor por defecto
//	        nuevoCliente.setDni(12345678);
//	        nuevoCliente.setCuil(20304051);
//	        nuevoCliente.setNombre("Claudio");
//	        nuevoCliente.setApellido("Pérez");
//	        nuevoCliente.setSexo("Masculino");
//	        
//	        // Crear un objeto Pais (por ejemplo, Argentina con id 1)
//	        Pais paisNacimiento = new Pais(5, "Argentina");
//	        nuevoCliente.setPaisNacimiento(paisNacimiento); // Asignar el país de nacimiento
//	        
//	        // Establecer la fecha de nacimiento utilizando LocalDate
//	        nuevoCliente.setFechaNacimiento(LocalDate.of(1990, 5, 15)); // Cambia el formato si es necesario
//	        
//	        // Crear un objeto Usuario (por ejemplo, con id 123 y admin como false)
//	        Usuario usuario = new Usuario(1, "usuarioEjemplo", "password", "Nombre Usuario", false);
//	        nuevoCliente.setUsuario(usuario); // Asignar el usuario que está agregando el cliente
//
//	        // Llamar al método para agregar el cliente
//	        boolean resultado = clienteDAO.agregarCliente(nuevoCliente);
//
//	        // Mostrar el resultado
//	        if (resultado) {
//	            System.out.println("Cliente agregado exitosamente.");
//	        } else {
//	            System.out.println("Error al agregar el cliente.");
//	        }
		
//	
//		   PaisDaoImpl paisDAO = new PaisDaoImpl();
//	        
//	        // Obtener la lista de países
//	        List<Pais> paises = paisDAO.obtenerPaises();
//	        
//	        // Mostrar la lista de países
//	        if (paises != null && !paises.isEmpty()) {
//	            for (Pais pais : paises) {
//	                System.out.println("ID: " + pais.getId() + ", Nombre: " + pais.getNombre());
//	            }
//	        } else {
//	            System.out.println("No se encontraron países.");
//	        }
		
		
	     // Crear una instancia del DAO de Usuario
        //UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        
        // Obtener la lista de usuarios
        //List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
        
        // Verificar si la lista de usuarios no está vacía
       // if (usuarios != null && !usuarios.isEmpty()) {
            // Iterar y mostrar la información de cada usuario
         //   for (Usuario usuario : usuarios) {
         //       System.out.println("ID: " + usuario.getId());
         //       System.out.println("Usuario: " + usuario.getUsuario());
         //       System.out.println("Nombre: " + usuario.getNombre());
         //       System.out.println("Rol: " + (usuario.isAdmin() ? "Administrador" : "Usuario"));
         //       System.out.println("------");
         //   }
       // } else {
       //     System.out.println("No se encontraron usuarios.");
       // }
		
	//}
	}
}
