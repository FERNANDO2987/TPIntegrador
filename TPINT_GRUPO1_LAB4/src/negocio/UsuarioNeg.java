package negocio;

import java.util.ArrayList;

import entidad.Usuario;

public interface UsuarioNeg {
	
	 public ArrayList<Usuario> listarUsuarios();
	 public boolean insertarUsuario(Usuario usuario );
	 public boolean editarUsuario(Usuario usuario);
	 public Usuario obtenerUnUsuario(long id);
	 

}
