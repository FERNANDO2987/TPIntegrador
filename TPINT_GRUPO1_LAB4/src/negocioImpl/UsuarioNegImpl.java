package negocioImpl;

import java.util.ArrayList;


import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
	
	
	private UsuarioDao  userDao = new UsuarioDaoImpl();
	
	public  UsuarioNegImpl(UsuarioDao userDao)
	{
		this.userDao = userDao;
	}
	
	
	public UsuarioNegImpl()
	{
		
	}
	
	@Override
	 public ArrayList<Usuario> listarUsuarios()
	 {
		 return (ArrayList<Usuario>) userDao.obtenerUsuarios();
	 }

	 

	 
	 
		@Override
		 public boolean insertarUsuario(Usuario usuario )
		 {
			 return userDao.agregarUsuario(usuario);
		 }


		@Override
		public boolean editarUsuario(Usuario usuario) {
			// TODO Auto-generated method stub
			return userDao.modificarUsuario(usuario);	
			}


		@Override
		public Usuario obtenerUnUsuario(long id) {
			// TODO Auto-generated method stub
			return userDao.obtenerUsuarioPorId(id);
		}
	 
	 
}
