package Main;

import entidad.Cliente;

public class Main {

	public static void main(String[] args) {
		
	    Cliente cliente = new Cliente();
        cliente.setDni(12345678L);
        cliente.setCuil(20312345678L);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setSexo("Masculino");
        cliente.setUsuario("juanperez");
        cliente.setPassword("password123");
        cliente.setFechaNacimiento(new Date()); // Fecha de nacimiento actual como ejemplo
        cliente.setCorreo("juan.perez@example.com");
        cliente.setTelefono("123456789");
        cliente.setCelular("987654321");
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
