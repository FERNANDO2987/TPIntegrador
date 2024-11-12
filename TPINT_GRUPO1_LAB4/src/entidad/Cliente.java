package entidad;

import java.time.LocalDate;

public class Cliente {
	 private long id;
	    private int dni;
	    private int cuil;
	    private String nombre;
	    private String apellido;
	    private String sexo;
	    private Pais paisNacimiento;
	    private LocalDate fechaNacimiento;
	    private Usuario usuario;

    // Constructor
	  
	    public Cliente() {
	    	paisNacimiento = new Pais();
	    	usuario = new Usuario();
	    }

	    // Constructor con parámetros
	    public Cliente(long id, int dni, int cuil, String nombre, String apellido, String sexo, 
	                   Pais paisNacimiento, LocalDate fechaNacimiento, Usuario usuario) {
	        this.id = id;
	        this.dni = dni;
	        this.cuil = cuil;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.sexo = sexo;
	        this.paisNacimiento = paisNacimiento;
	        this.fechaNacimiento = fechaNacimiento;
	        this.usuario = usuario;
	    }

	    
	    // Getters y Setters
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public int getDni() {
	        return dni;
	    }

	    public void setDni(int dni) {
	        this.dni = dni;
	    }

	    public int getCuil() {
	        return cuil;
	    }

	    public void setCuil(int cuil) {
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

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

		@Override
		public String toString() {
			return "[DNI: "+dni + " CUIL: "+cuil+" Nombre: "+nombre+" Apellido: "+apellido+"]" ;
		}

	    
	    
}

