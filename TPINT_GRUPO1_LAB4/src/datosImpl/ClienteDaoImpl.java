package datosImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import datos.ClienteDao;
import entidad.Cliente;



public class ClienteDaoImpl implements ClienteDao{
	
	private Conexion cn;

	public ClienteDaoImpl()
	{
		 cn = new Conexion();
	}
	
	@Override
	   public Cliente loguear(Cliente usuario) {
	       Cliente usuarioBD = null;
	       cn = new Conexion();
	       ResultSet rs = null;
	       cn.Open();
	       String query = "{CALL ValidarUsuario(?, ?)}";
	       try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	           stmt.setString(1, usuario.getUsuario());
	           stmt.setString(2, usuario.getPassword()); 
	           rs = stmt.executeQuery();
	           if (rs != null && rs.next()) {
	        	   usuarioBD = new Cliente();
	        	   usuarioBD.setId(rs.getLong("id"));
	        	   usuarioBD.setUsuario(rs.getString("usuario"));
	        	   usuarioBD.setPassword(rs.getString("password"));
	        	   usuarioBD.setNombre(rs.getString("nombre"));
	        	   usuarioBD.setAdmin(rs.getBoolean("admin"));
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           try {
	               if (rs != null) {
	                   rs.close();
	               }
	               cn.close();
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	       }
	       return usuarioBD;
	   }


	public boolean agregarCliente(Cliente cliente) {
	    boolean estado = true;
	    cn.Open();

	    String query = "{CALL AgregarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

	    try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	        // Establecer los parámetros
	        stmt.setInt(1, cliente.getId());
	        stmt.setString(2, cliente.getDni());
	        stmt.setString(3, cliente.getCuil());
	        stmt.setString(4, cliente.getNombre());
	        stmt.setString(5, cliente.getApellido());
	        stmt.setString(6, cliente.getSexo());
	        stmt.setString(7, cliente.getUsuario());
	        stmt.setString(8, cliente.getPassword());
	        stmt.setString(9, cliente.getPaisNacimiento());
	        stmt.setDate(10, cliente.getFechaNacimiento() != null 
	            ? new java.sql.Date(cliente.getFechaNacimiento().getTime()) 
	            : null);
	        stmt.setString(11, cliente.getCorreo());
	        stmt.setString(12, cliente.getTelefono());
	        stmt.setString(13, cliente.getCelular());
	        stmt.setBoolean(14, cliente.getAdmin());

	        // Ejecutar el procedimiento almacenado
	        stmt.execute();

	        // Si el procedimiento devuelve un resultado (ej. nuevo ID)
	        ResultSet rs = stmt.getResultSet();
	        if (rs != null && rs.next()) {
	            int nuevoId = rs.getInt("nuevo_id");
	            System.out.println("Cliente insertado con ID: " + nuevoId);
	        }

	    } catch (SQLException e) {
	        estado = false;
	        System.err.println("Error al ejecutar el procedimiento AgregarCliente: " + e.getMessage());
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
		Cliente aux = new Cliente();
		cn = new Conexion();
		cn.Open();
		
		String query = "SELECT clientes.id, clientes.nombre,clientes.apellido, clientes.sexo," +
		" clientes.usuario, clientes.password, clientes.id_pais_nacimiento," +
		" clientes.fecha_nacimiento, clientes.correo, Clientes.dni, clientes.cuil," +
		" clientes.Telefono, clientes.Celular, clientes.admin, clientes.deleted as borrado,  paises.nombre as nombre_pais" +
		" from clientes left join paises on id_pais_nacimiento = paises.id" + 
		" where clientes.id = ?";
		
		try
		{
			PreparedStatement prst = cn.connection.prepareStatement(query);	
			prst.setLong(1, id);
			ResultSet rs = prst.executeQuery();
			rs.next();
			aux.setId(rs.getLong("id"));
			aux.setNombre(rs.getString("nombre"));
			aux.setApellido(rs.getString("apellido"));
			aux.setSexo(rs.getString("sexo"));
			aux.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
			aux.setCorreo(rs.getString("correo"));
			aux.setDni(rs.getLong("dni"));
			aux.setCuil(rs.getLong("cuil"));
			aux.setTelefono(rs.getString("Telefono"));
			aux.setCelular(rs.getString("Celular"));
			aux.setAdmin(rs.getBoolean("admin"));	
            aux.getPaisNacimiento().setId(rs.getInt("id_pais_nacimiento"));
            aux.getPaisNacimiento().setNombre(rs.getString("nombre_pais"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return aux;
	}
	


	@Override
	public boolean modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
