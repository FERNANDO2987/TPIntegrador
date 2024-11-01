package datosImpl;

import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	
	private Conexion cn;

	public ClienteDaoImpl()
	{
		
	}
	
	
	
	@Override
	public boolean agregarCliente(Cliente cliente) {
		
	
	    
	    boolean estado = true;

	    cn = new Conexion();
	    cn.Open();

	    String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, nacionalidad, fechaNacimiento, direccion, localidad, provincia, correoElectronico, telefono, usuario, contraseña) VALUES ('"
	            + cliente.getDni() + "', '"
	            + cliente.getCuil() + "', '"
	            + cliente.getNombre() + "', '"
	            + cliente.getApellido() + "', '"
	            + cliente.getSexo() + "', '"
	            + cliente.getNacionalidad() + "', '"
	            + cliente.getFechaNacimiento() + "', '"
	            + cliente.getDireccion() + "', '"
	            + cliente.getLocalidad() + "', '"
	            + cliente.getProvincia() + "', '"
	            + cliente.getCorreoElectronico() + "', '"
	            + cliente.getTelefono() + "', '"
	            + cliente.getUsuario() + "', '"
	            + cliente.getContraseña() + "')";

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
}
