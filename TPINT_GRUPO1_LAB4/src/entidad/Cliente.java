package entidad;


import java.time.LocalDate;

public class Cliente {
    private Long id;
    private Long dni;
    private Long cuil;
    private String nombre;
    private String apellido;
    private String sexo;
    private Usuario usuario;
    private Pais paisNacimiento;  // Relación con la clase Pais
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String celular;
    private Boolean admin;

    
  
    // Constructor
    public Cliente(Long id, Long dni, Long cuil, String nombre, String apellido, String sexo, String usuario, 
                   String password, Pais paisNacimiento, LocalDate fechaNacimiento,String correo,String telefono,String celular, Boolean admin) {
        this.id = id;
        this.dni = dni;
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.usuario.setNombreUsuario(usuario);
        this.usuario.setPassword(password);
        this.paisNacimiento = paisNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.admin = admin;
    }

    public Cliente()
    {
    	
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getCuil() {
        return cuil;
    }

    public void setCuil(Long cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    

    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
    public String toString() {
        return "Cliente{" +
               "id=" + id +
               ", dni=" + dni +
               ", cuil=" + cuil +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", sexo='" + sexo + '\'' +
               ", paisNacimiento=" + paisNacimiento +
               ", fechaNacimiento=" + fechaNacimiento +
               ", correo='" + correo + '\'' +
               ", telefono='" + telefono + '\'' +
               ", celular='" + celular + '\'' +
               ", admin=" + admin +
               '}';
    }
	    
	    
}

