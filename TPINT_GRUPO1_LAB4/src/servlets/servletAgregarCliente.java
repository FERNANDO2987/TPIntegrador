package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;
import entidad.Cliente;

/**
 * Servlet implementation class servletAgregarCliente
 */
@WebServlet("/servletAgregarCliente")
public class servletAgregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
		String dniStr = request.getParameter("dni");
	        String cuilStr = request.getParameter("cuil");
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("apellido");
	        String sexo = request.getParameter("sexo");
	        String nacionalidad  = request.getParameter("pais");
	        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
	        String correoElectronico = request.getParameter("correoElectronico");
	        String telefono = request.getParameter("telefono");
	        String celular = request.getParameter("celular");
	        String usuario = request.getParameter("usuario");
	        String password = request.getParameter("password");

	      

	        Date fechaNacimiento = null;
	        try {
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            fechaNacimiento = formatter.parse(fechaNacimientoStr); // Convierte la cadena a un objeto Date
	        } catch (ParseException e) {
	            response.getWriter().write("Error: Formato de fecha inválido.");
	            return;
	        }


	    Cliente cliente = new Cliente(
	    	    0L,              // id
	    	    dni,             // dni
	    	    cuil,            // cuil
	    	    nombre,          // nombre
	    	    apellido,        // apellido
	    	    sexo,            // sexo
	    	    usuario,         // usuario
	    	    contraseña,      // password
	    	    paisNacimiento,  // paisNacimiento
	    	    fechaNacimiento, // fechaNacimiento
	    	    correoElectronico, // correo
	    	    telefono,        // telefono
	    	    celular,         // celular
	    	    false,            // admin (o true si el cliente es admin)
	    	    false			// falso si no esta borrado
	    	);

	      


	        Cliente cliente = new Cliente(
	            0,              // id
	            dniStr,         // dni
	            cuilStr,        // cuil
	            nombre,         // nombre
	            apellido,       // apellido
	            sexo,           // sexo
	            usuario,        // usuario
	            password,     // contraseña
	            nacionalidad, // paisNacimiento
	            fechaNacimiento, // fechaNacimiento
	            correoElectronico, // correo
	            telefono,       // telefono
	            celular,        // celular
	            false           // admin (o true si el cliente es admin)
	        );
	       
	        boolean estado = new ClienteDaoImpl().agregarCliente(cliente);
	 

	        if (estado) {
	            response.getWriter().write("Cliente agregado exitosamente.");
	        } else {
	            response.getWriter().write("Error al agregar cliente.");
	        }
	        
	        System.out.println("DNI: " + dniStr);
	        System.out.println("CUIL: " + cuilStr);
	        System.out.println("Nombre: " + nombre);
	        System.out.println("Apellido: " + apellido);
	        System.out.println("Sexo: " + sexo);
	        System.out.println("País: " + nacionalidad);
	        System.out.println("Fecha de Nacimiento: " + fechaNacimientoStr);
	        System.out.println("Correo: " + correoElectronico);
	        System.out.println("Teléfono: " + telefono);
	        System.out.println("Celular: " + celular);
	        System.out.println("Usuario: " + usuario);
	        System.out.println("Contraseña: " + password);

	        
	        // Redirige al mismo JSP con el mensaje
	        request.getRequestDispatcher("AgregarCliente.jsp").forward(request, response);
	}

}
