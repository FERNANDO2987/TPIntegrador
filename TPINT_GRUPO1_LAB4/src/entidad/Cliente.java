package entidad;

import java.time.LocalDate;

public class Cliente {
    private int id;
    private String dni;
    private String cuil;
    private String nombre;
    private String apellido;
    private String sexo;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String localidad;
    private String provincia;
    private String correoElectronico;
    private String telefono;
    private String usuario;
    private String contraseña;

    // Constructor
    public Cliente(int id, String dni, String cuil, String nombre, String apellido, String sexo, String nacionalidad,
    		LocalDate fechaNacimiento, String direccion, String localidad, String provincia,
                   String correoElectronico, String telefono, String usuario, String contraseña) {
        this.id = id;
        this.dni = dni;
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCuil() { return cuil; }
    public void setCuil(String cuil) { this.cuil = cuil; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    // M�todo para mostrar informaci�n del cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + id +
                ", DNI='" + dni + '\'' +
                ", CUIL='" + cuil + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Sexo='" + sexo + '\'' +
                ", Nacionalidad='" + nacionalidad + '\'' +
                ", Fecha de Nacimiento='" + fechaNacimiento + '\'' +
                ", Direcci�n='" + direccion + '\'' +
                ", Localidad='" + localidad + '\'' +
                ", Provincia='" + provincia + '\'' +
                ", Correo Electr�nico='" + correoElectronico + '\'' +
                ", Tel�fono='" + telefono + '\'' +
                ", Usuario='" + usuario + '\'' +
                '}';
    }
}

