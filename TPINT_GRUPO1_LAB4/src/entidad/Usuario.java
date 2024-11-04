package entidad;

public class Usuario {
	
	   private long id;
	    private String usuario;
	    private String password;
	    private String nombre;
	    private boolean admin;
	    
	    
	    public Usuario() {}
	    
	    public Usuario(long id, String usuario, String password, String nombre, boolean admin) {
	        this.id = id;
	        this.usuario = usuario;
	        this.password = password;
	        this.nombre = nombre;
	        this.admin = admin;
	    }
	    
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public boolean isAdmin() {
	        return admin;
	    }

	    public void setAdmin(boolean admin) {
	        this.admin = admin;
	    }

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre
					+ ", admin=" + admin + "]";
		}
	    
	    

}
