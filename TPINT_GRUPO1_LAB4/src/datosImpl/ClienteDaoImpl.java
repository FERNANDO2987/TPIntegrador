package datosImpl;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import datos.ClienteDao;
import entidad.Cliente;



public class ClienteDaoImpl implements ClienteDao{
	
	private Conexion cn;

	public ClienteDaoImpl()
	{
		 cn = new Conexion();
	}
	
	

	public boolean agregarCliente(Cliente cliente) {
	    boolean estado = true;
	    cn.Open();

	    String query = "{CALL AgregarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

	    try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	        // Obtener el id del cliente (puede ser nulo en caso de inserción)
	        Long id = cliente.getId(); // El id puede ser nulo cuando es nuevo
	        
	        Date fechaSQL = Date.valueOf(cliente.getFechaNacimiento());
	        // Establecer los parámetros
	        stmt.setObject(1, id, Types.BIGINT); // Usamos Types.BIGINT para manejar valores nulos
	        stmt.setLong(2, cliente.getDni());
	        stmt.setLong(3, cliente.getCuil());
	        stmt.setString(4, cliente.getNombre());
	        stmt.setString(5, cliente.getApellido());
	        stmt.setString(6, cliente.getSexo());
	        stmt.setString(7, cliente.getUsuario());
	        stmt.setString(8, cliente.getPassword());
	        stmt.setObject(9, cliente.getPaisNacimiento() != null ? cliente.getPaisNacimiento().getId() : null, Types.INTEGER);
	        stmt.setDate(10, fechaSQL);
	        stmt.setString(11, cliente.getCorreo());
	        stmt.setString(12, cliente.getTelefono());
	        stmt.setString(13, cliente.getCelular());
	        stmt.setBoolean(14, cliente.getAdmin());

	        // Ejecutar la sentencia
	        stmt.executeUpdate();

	        // Si se está insertando un nuevo cliente, capturamos el ID generado
	        if (id == null) {
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                long nuevoId = rs.getLong(1); // Obtener el ID generado
	                cliente.setId(nuevoId); // Asignar el nuevo ID al objeto cliente
	            }
	        }

	    } catch (SQLException e) {
	        estado = false;
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }

	    return estado;
	}
	

	

	
	@Override
	public boolean darDeBajaCliente(int idCliente) {
	    boolean estado = true;
	    cn = new Conexion();
	    cn.Open();

	    // Consulta para actualizar el estado del cliente a inactivo
	    String query = "UPDATE clientes SET Deleted = TRUE, DeleteDate = NOW() WHERE id = " + idCliente;

	    System.out.println(query);

	    try {
	        estado = cn.execute(query);
	    } catch (Exception e) {
	        e.printStackTrace();
	        estado = false;
	    } finally {
	        cn.close();
	    }

	    return estado;
	}


	




	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cliente obtenerClientexId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
