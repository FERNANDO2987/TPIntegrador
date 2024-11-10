package datos;

import java.util.List;

import entidad.Usuario;

public interface UsuarioDao {
	
	 public List<Usuario> obtenerUsuarios();
	 public boolean agregarUsuario(Usuario usuario) ;
	 public boolean modificarUsuario(Usuario usuario);
	

}
