package datosImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.ClienteDao;
import entidad.Cliente;
import entidad.Pais;
import entidad.Usuario;

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

	    String query = "{CALL AgregarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

	    try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	        // Establecer los parámetros
	        stmt.setObject(1, cliente.getId()); // p_id
	        stmt.setInt(2, cliente.getDni()); // p_dni
	        stmt.setInt(3, cliente.getCuil()); // p_cuil
	        stmt.setString(4, cliente.getNombre()); // p_nombre
	        stmt.setString(5, cliente.getApellido()); // p_apellido
	        stmt.setString(6, cliente.getSexo()); // p_sexo
	        stmt.setObject(7, (cliente.getPaisNacimiento() != null ? cliente.getPaisNacimiento().getId() : null)); // p_id_pais_nacimiento
	        stmt.setDate(8, cliente.getFechaNacimiento() != null ? java.sql.Date.valueOf(cliente.getFechaNacimiento()) : null); // p_fecha_nacimiento
	        stmt.setObject(9, (cliente.getUsuario() != null ? cliente.getUsuario().getId() : null)); // p_id_usuario

	        // Ejecutar el procedimiento
	        stmt.executeUpdate();
	        
	    } catch (SQLException e) {
	        estado = false;
	        e.printStackTrace();
	    } finally {
	        cn.close();
	    }

	    return estado;
	}

	
	@Override
	public List<Cliente> obtenerClientes() {
	    List<Cliente> clientes = new ArrayList<>();
	    String query = "SELECT c.id, c.dni, c.cuil, c.nombre, c.apellido, c.sexo, " +
	                   "c.id_pais_nacimiento, c.fecha_nacimiento, " +
	                   "u.id AS usuario_id, u.usuario AS usuario_nombre, " +
	                   "u.password AS usuario_password, u.nombre AS usuario_nombre_real, u.admin AS usuario_admin, " +
	                   "p.nombre AS pais_nombre " +
	                   "FROM Clientes c " +
	                   "LEFT JOIN Usuarios u ON c.id_usuario = u.id " +
	                   "LEFT JOIN Paises p ON c.id_pais_nacimiento = p.id " +
	                   "WHERE c.deleted = FALSE";

	    try {
	        // Open connection
	        cn = new Conexion();
	        cn.Open();

	        ResultSet rs = cn.query(query);

	        while (rs != null && rs.next()) {
	            long id = rs.getLong("id");
	            int dni = rs.getInt("dni");
	            int cuil = rs.getInt("cuil");
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String sexo = rs.getString("sexo");
	            LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();

	            // Obtener el país de nacimiento
	            int idPais = rs.getInt("id_pais_nacimiento");
	            String nombrePais = rs.getString("pais_nombre");
	            Pais paisNacimiento = null;
	            if (idPais > 0 && nombrePais != null) {
	                paisNacimiento = new Pais(idPais, nombrePais); 
	            }

	            // Obtener el usuario
	            Usuario usuario = null;
	            long usuarioId = rs.getLong("usuario_id");
	            if (usuarioId > 0) {
	                String usuarioNombre = rs.getString("usuario_nombre");
	                String usuarioPassword = rs.getString("usuario_password");
	                String usuarioNombreReal = rs.getString("usuario_nombre_real"); // Cambié a nombre real
	                boolean usuarioAdmin = rs.getBoolean("usuario_admin");
	                
	                usuario = new Usuario(usuarioId, usuarioNombre, usuarioPassword, usuarioNombreReal, usuarioAdmin); 
	            }

	            Cliente cliente = new Cliente(id, dni, cuil, nombre, apellido, sexo, 
	                                           paisNacimiento, fechaNacimiento, usuario);
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
	    boolean exito = true;
	    cn = new Conexion();
	    cn.Open();

	    String query = "{CALL ModificarCliente(?,?,?,?,?,?)}";

	    try
	    {
	    	CallableStatement cst = cn.connection.prepareCall(query);
	    	cst.setLong(1, cliente.getId());
	    	cst.setInt(2, cliente.getDni());
	    	cst.setInt(3, cliente.getCuil());
	    	cst.setString(4, cliente.getNombre());
	    	cst.setString(5, cliente.getApellido());
	    	cst.setString(6, cliente.getSexo());

	    	cst.execute();

	    } 
	    catch (Exception e) 
	    {
	    	exito = false;
	        e.printStackTrace();
	    } 
	    finally
	    {
	        cn.close();
	    }
	
	    return exito;
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
	public Cliente obtenerClientexId(Long id) {
		Cliente aux = new Cliente();
		cn = new Conexion();
		cn.Open();
		
		String query = "SELECT c.id, c.dni, c.cuil, c.nombre, c.apellido, c.sexo, " +
                "c.id_pais_nacimiento, c.fecha_nacimiento, " +
                "u.id AS usuario_id, u.usuario AS usuario_nombre, " +
                "u.password AS usuario_password, u.nombre AS usuario_nombre_real, u.admin AS usuario_admin, " +
                "p.nombre AS pais_nombre " +
                "FROM Clientes c " +
                "LEFT JOIN Usuarios u ON c.id_usuario = u.id " +
                "LEFT JOIN Paises p ON c.id_pais_nacimiento = p.id " +
                "WHERE c.id = ?";
		
		try
		{
			PreparedStatement prst = cn.connection.prepareStatement(query);	
			prst.setLong(1, id);
			ResultSet rs = prst.executeQuery();
			rs.next();
			aux.setId(rs.getLong("id"));
			aux.setDni(rs.getInt("dni"));
			aux.setCuil(rs.getInt("cuil"));
			aux.setNombre(rs.getString("nombre"));
			aux.setApellido(rs.getString("apellido"));
            aux.setSexo(rs.getString("sexo"));
            aux.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            aux.getPaisNacimiento().setId(rs.getInt("id_pais_nacimiento"));
            aux.getPaisNacimiento().setNombre(rs.getString("pais_nombre"));
            aux.setUsuario(null);
			
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

	
}
