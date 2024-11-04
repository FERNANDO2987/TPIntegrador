package datosImpl;

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

	    String query = "INSERT INTO Clientes (dni, cuil, nombre, apellido, sexo, id_pais_nacimiento, fecha_nacimiento, id_usuario) VALUES ("
	            + cliente.getDni() + ", "
	            + cliente.getCuil() + ", '"
	            + cliente.getNombre() + "', '"
	            + cliente.getApellido() + "', '"
	            + cliente.getSexo() + "', "
	            + (cliente.getPaisNacimiento() != null ? cliente.getPaisNacimiento().getId() : "NULL") + ", '"
	            + cliente.getFechaNacimiento() + "', "
	            + (cliente.getUsuario() != null ? cliente.getUsuario().getId() : "NULL") + ")";

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

	
//	
//	@Override
//	public boolean modificarCliente(Cliente cliente) {
//	    boolean estado = true;
//	    cn = new Conexion();
//	    cn.Open();
//
//	    String query = "UPDATE clientes SET dni = ?, "
//	                 + "cuil = ?, "
//	                 + "nombre = ?, "
//	                 + "apellido = ?, "
//	                 + "sexo = ?, "
//	                 + "id_pais_nacimiento = ?, "
//	                 + "fecha_nacimiento = ?, "
//	                 + "direccion = ?, "
//	                 + "localidad = ?, "
//	                 + "provincia = ?, "
//	                 + "correoElectronico = ?, "
//	                 + "telefono = ?, "
//	                 + "id_usuario = ? "
//	                 + "WHERE idCliente = ?";
//
//	    try {
//	        PreparedStatement pstmt = cn.prepareStatement(query);
//	        pstmt.setInt(1, cliente.getDni());
//	        pstmt.setInt(2, cliente.getCuil());
//	        pstmt.setString(3, cliente.getNombre());
//	        pstmt.setString(4, cliente.getApellido());
//	        pstmt.setString(5, cliente.getSexo());
//	        
//	        // Asignar el país de nacimiento, asegurándose de que se esté utilizando el ID correcto
//	        Pais paisNacimiento = cliente.getPaisNacimiento();
//	        pstmt.setInt(6, (paisNacimiento != null) ? paisNacimiento.getId() : 0); // Establecer ID del país o 0 si es nulo
//
//	        pstmt.setDate(7, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
//	        pstmt.setString(8, cliente.getDireccion());
//	        pstmt.setString(9, cliente.getLocalidad());
//	        pstmt.setString(10, cliente.getProvincia());
//	        pstmt.setString(11, cliente.getCorreoElectronico());
//	        pstmt.setString(12, cliente.getTelefono());
//	        
//	        // Asignar el usuario, asegurándose de que se esté utilizando el ID correcto
//	        Usuario usuario = cliente.getUsuario();
//	        pstmt.setLong(13, (usuario != null) ? usuario.getId() : 0); // Establecer ID de usuario o 0 si es nulo
//	        
//	        pstmt.setLong(14, cliente.getId());
//
//	        int rowsAffected = pstmt.executeUpdate();
//	        estado = (rowsAffected > 0);
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        estado = false;
//	    } finally {
//	        cn.close();
//	    }
//
//	    return estado;
//	}

	
	@Override
	public boolean darDeBajaCliente(int idCliente) {
	    boolean estado = true;
	    cn = new Conexion();
	    cn.Open();

	    // Consulta para actualizar el estado del cliente a inactivo
	    String query = "UPDATE clientes SET Deleted = TRUE, DeleteDate = NOW() WHERE idCliente = " + idCliente;

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
