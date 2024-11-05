package Main;


import java.time.LocalDate;
import java.util.List;

import datosImpl.ClienteDaoImpl;
import datosImpl.PaisDaoImpl;
import entidad.Cliente;
import entidad.Pais;
import entidad.Usuario;


public class Main {

	public static void main(String[] args) {

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
		
	
		   PaisDaoImpl paisDAO = new PaisDaoImpl();
	        
	        // Obtener la lista de países
	        List<Pais> paises = paisDAO.obtenerPaises();
	        
	        // Mostrar la lista de países
	        if (paises != null && !paises.isEmpty()) {
	            for (Pais pais : paises) {
	                System.out.println("ID: " + pais.getId() + ", Nombre: " + pais.getNombre());
	            }
	        } else {
	            System.out.println("No se encontraron países.");
	        }
	}
}
