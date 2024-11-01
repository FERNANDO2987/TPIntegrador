package datosImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	   public List<Cliente> obtenerClientes() {
	        List<Cliente> clientes = new ArrayList<>();
	        String query = "SELECT idCliente, dni, cuil, nombre, apellido, sexo, nacionalidad, fechaNacimiento, " +
	                       "direccion, localidad, provincia, correoElectronico, telefono, usuario, contraseña " +
	                       "FROM clientes";

	        try {
	            // Open connection
	            cn = new Conexion();
	    	    cn.Open();
	            
	           
	            ResultSet rs = cn.query(query);

	            while (rs != null && rs.next()) {
	                Cliente cliente = new Cliente(
	                        rs.getInt("idCliente"),
	                        rs.getString("dni"),
	                        rs.getString("cuil"),
	                        rs.getString("nombre"),
	                        rs.getString("apellido"),
	                        rs.getString("sexo"),
	                        rs.getString("nacionalidad"),
	                        rs.getDate("fechaNacimiento").toLocalDate(),
	                        rs.getString("direccion"),
	                        rs.getString("localidad"),
	                        rs.getString("provincia"),
	                        rs.getString("correoElectronico"),
	                        rs.getString("telefono"),
	                        rs.getString("usuario"),
	                        rs.getString("contraseña")
	                );
	                clientes.add(cliente);
	            }

	            System.out.println("Clientes cargados: " + clientes.size());

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close connection
	            cn.close();
	        }

	        return clientes;
	    }
	
	
	@Override
	public boolean modificarCliente(Cliente cliente) {
	    boolean estado = true;

	    cn = new Conexion();
	    cn.Open();

	    String query = "UPDATE clientes SET dni = '" + cliente.getDni() + "', "
	            + "cuil = '" + cliente.getCuil() + "', "
	            + "nombre = '" + cliente.getNombre() + "', "
	            + "apellido = '" + cliente.getApellido() + "', "
	            + "sexo = '" + cliente.getSexo() + "', "
	            + "nacionalidad = '" + cliente.getNacionalidad() + "', "
	            + "fechaNacimiento = '" + cliente.getFechaNacimiento() + "', "
	            + "direccion = '" + cliente.getDireccion() + "', "
	            + "localidad = '" + cliente.getLocalidad() + "', "
	            + "provincia = '" + cliente.getProvincia() + "', "
	            + "correoElectronico = '" + cliente.getCorreoElectronico() + "', "
	            + "telefono = '" + cliente.getTelefono() + "', "
	            + "usuario = '" + cliente.getUsuario() + "', "
	            + "contrase�a = '" + cliente.getContraseña() + "' "
	            + "WHERE idCliente = " + cliente.getId();

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
