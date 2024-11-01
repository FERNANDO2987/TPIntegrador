package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;
import entidad.Cliente;

/**
 * Servlet implementation class servletModificarCliente
 */
@WebServlet("/servletModificarCliente")
public class servletModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarCliente() {
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
	        ClienteDao clienteDao = new ClienteDaoImpl();
	        int idCliente;

	        // Obtener y validar el ID del cliente
	        try {
	            idCliente = Integer.parseInt(request.getParameter("id")); // Asegúrate de que este nombre coincida con el del formulario
	        } catch (NumberFormatException e) {
	            request.setAttribute("error", "ID de cliente no válido.");
	            request.getRequestDispatcher("modificarCliente.jsp").forward(request, response);
	            return;
	        }

	        // Obtener otros parámetros
	        String dni = request.getParameter("dni");
	        String cuil = request.getParameter("cuil");
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("apellido");
	        String sexo = request.getParameter("sexo");
	        String nacionalidad = request.getParameter("nacionalidad");
	        LocalDate fechaNacimiento;

	        // Obtener y validar la fecha de nacimiento
	        try {
	            fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento")); // Asegúrate de que el formato sea correcto
	        } catch (DateTimeParseException e) {
	            request.setAttribute("error", "Fecha de nacimiento no válida.");
	            request.getRequestDispatcher("modificarCliente.jsp").forward(request, response);
	            return;
	        }

	        // Obtener el resto de los parámetros
	        String direccion = request.getParameter("direccion");
	        String localidad = request.getParameter("localidad");
	        String provincia = request.getParameter("provincia");
	        String correoElectronico = request.getParameter("correoElectronico");
	        String telefono = request.getParameter("telefono");
	        String usuario = request.getParameter("usuario");

	        // Crear la instancia de Cliente
	        Cliente cliente = new Cliente(idCliente, dni, cuil, nombre, apellido, sexo, nacionalidad, 
	                                      fechaNacimiento, direccion, localidad, provincia, 
	                                      correoElectronico, telefono, usuario, null); // Asegúrate de incluir la contraseña si es necesario

	        // Modificar el cliente
	        boolean resultado = clienteDao.modificarCliente(cliente);

	        // Verificar el resultado
	        if (resultado) {
	            response.sendRedirect("listarClientes.jsp"); // Redirigir a la página de listado de clientes
	        } else {
	            request.setAttribute("error", "Error al modificar el cliente.");
	            request.getRequestDispatcher("ListarCliente.jsp").forward(request, response); // Volver a la página de modificación
	        }
	    }


}
