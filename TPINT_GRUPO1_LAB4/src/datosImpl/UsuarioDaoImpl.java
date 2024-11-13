package datosImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Conexion cn;

	   public UsuarioDaoImpl() {
	       
	    }
	   
	   
	   @Override
	   public Usuario loguear(Usuario usuario) {
	       Usuario usuarioBD = null;
	       cn = new Conexion();
	       ResultSet rs = null;
	       cn.Open();

	       String query = "{CALL ValidarUsuario(?, ?)}";

	       try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	           stmt.setString(1, usuario.getUsuario());
	           stmt.setString(2, usuario.getPassword()); 

	           rs = stmt.executeQuery();

	           if (rs != null && rs.next()) {

	        	   usuarioBD = new Usuario();
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


	   
	   @Override
	   public Usuario obtenerUsuarioPorId(long id) {
	       Usuario usuario = null;
	       ResultSet rs = null;

	       try {
	           cn.Open();
	     
	           String query = "{CALL ObtenerUsuarioPorId(?)}"; 
	           try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	               stmt.setLong(1, id); 

	           
	               rs = stmt.executeQuery();

	               if (rs != null && rs.next()) {
	                 
	                   long usuarioId = rs.getLong("id");
	                   String usuarioNombre = rs.getString("usuario");
	                   String password = rs.getString("password");
	                   String nombre = rs.getString("nombre");
	                   boolean admin = rs.getBoolean("admin");

	                   // Creamos el objeto Usuario con los datos obtenidos
	                   usuario = new Usuario(usuarioId, usuarioNombre, password, nombre, admin);
	               } else {
	                   System.out.println("No se encontró un usuario con el id: " + id);
	               }
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           try {
	               if (rs != null) {
	                   rs.close(); // Cerramos el ResultSet
	               }
	               cn.close(); // Cerramos la conexión
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	       }

	       return usuario; 
	   }

	   
	   
	   
	   @Override
	    public List<Usuario> obtenerUsuarios() {
		    cn = new Conexion();
	        List<Usuario> usuarios = new ArrayList<>();
	        ResultSet rs = null;

	        try {
	            cn.Open(); 
	            String query = "CALL ObtenerUsuarios();"; 
	            rs = cn.query(query); 

	            if (rs != null) {
	                while (rs.next()) {
	                    long id = rs.getLong("id");
	                    String usuario = rs.getString("usuario");
	                    String password = rs.getString("password");
	                    String nombre = rs.getString("nombre");
	                    boolean admin = rs.getBoolean("admin");
	                    usuarios.add(new Usuario(id, usuario, password, nombre, admin));
	                }
	            } else {
	                System.out.println("El ResultSet está vacío.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close(); // Close ResultSet
	                }
	                cn.close(); // Close the connection
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return usuarios; 
	    }
	   
	   
	   @Override
	   public boolean agregarUsuario(Usuario usuario) {
	       boolean estado = true;
	       cn = new Conexion();
	       cn.Open();

	       String query = "{CALL AgregarUsuario(?, ?, ?, ?, ?)}";

	       try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	          
	           stmt.setLong(1, usuario.getId());            
	           stmt.setString(2, usuario.getUsuario());     
	           stmt.setString(3, usuario.getPassword());    
	           stmt.setString(4, usuario.getNombre());      
	           stmt.setBoolean(5, usuario.isAdmin());       

	           // Execute the stored procedure
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
	   public boolean modificarUsuario(Usuario usuario) {
	       boolean estado = true;
	       cn = new Conexion();
	       cn.Open();

	       String query = "{CALL AgregarUsuario(?, ?, ?, ?, ?)}"; // Asume que el procedimiento almacenado ya existe

	       try (CallableStatement stmt = cn.connection.prepareCall(query)) {
	           
	           stmt.setLong(1, usuario.getId());            
	           stmt.setString(2, usuario.getUsuario());     
	           stmt.setString(3, usuario.getPassword());    
	           stmt.setString(4, usuario.getNombre());      
	           stmt.setBoolean(5, usuario.isAdmin());       

	           stmt.executeUpdate(); // Ejecuta el procedimiento para actualizar

	       } catch (SQLException e) {
	           estado = false;
	           e.printStackTrace();
	       } finally {
	           cn.close();
	       }

	       return estado;
	   }
	   
	   


}
