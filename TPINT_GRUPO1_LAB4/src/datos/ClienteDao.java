package datos;

import java.util.List;

import entidad.Cliente;

public interface ClienteDao {
	
	public boolean agregarCliente(Cliente cliente);
	public Cliente obtenerClientexId(Long id);
	public List<Cliente> obtenerClientes();
	public boolean modificarCliente(Cliente cliente);
	public boolean darDeBajaCliente(int idCliente);

}
