package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        List<Cliente> clientes = clienteDao.obtenerClientes();

        // Obtener el criterio de b�squeda del par�metro de solicitud
        String criterio = request.getParameter("criterio");
        
        // Filtrar los clientes por nombre o apellido si el criterio no es nulo ni vac�o
        if (criterio != null && !criterio.trim().isEmpty()) {
            clientes = clientes.stream()
                    .filter(cliente -> cliente.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                                       cliente.getApellido().toLowerCase().contains(criterio.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // Configurar la lista filtrada como atributo de la solicitud y reenviar a la vista
        request.setAttribute("clientes", clientes);
        request.setAttribute("criterio", criterio);  // para mantener el valor en el campo de b�squeda
        request.getRequestDispatcher("ListarClientes.jsp").forward(request, response);
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
	            // Si la modificación fue exitosa, redirigir a la página de listado de clientes
	            response.sendRedirect("listarClientes.jsp"); 
	        } else {
	            // Si ocurrió un error, mostrar el mensaje de error y redirigir al formulario de modificación
	            request.setAttribute("error", "Error al modificar el cliente.");
	            request.getRequestDispatcher("modificarCliente.jsp").forward(request, response); 
	        }
    }
	

}
