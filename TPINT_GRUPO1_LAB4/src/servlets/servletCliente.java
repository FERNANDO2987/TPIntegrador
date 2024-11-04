package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.ClienteDaoImpl;
import datosImpl.PaisDaoImpl;
import entidad.Cliente;
import entidad.Pais;


/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	
    	
    	   String dniStr = request.getParameter("dni");
    	    String cuilStr = request.getParameter("cuil");
    	    String nombre = request.getParameter("nombre");
    	    String apellido = request.getParameter("apellido");
    	    String sexo = request.getParameter("sexo");
    	    String nacionalidad = request.getParameter("nacionalidad");
    	    String fechaNacimientoStr = request.getParameter("fechaNacimiento");

    	    // Validate and parse DNI and CUIL
    	    int dni;
    	    int cuil;
    	    try {
    	        dni = Integer.parseInt(dniStr);
    	        cuil = Integer.parseInt(cuilStr);
    	    } catch (NumberFormatException e) {
    	        response.getWriter().write("Error: DNI o CUIL inválido.");
    	        return;
    	    }

    	    // Parse fechaNacimiento
    	    LocalDate fechaNacimiento = null;
    	    try {
    	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	        fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
    	    } catch (DateTimeParseException e) {
    	        response.getWriter().write("Error: Formato de fecha inválido.");
    	        return;
    	    }

    	    // Look up the country by name
    	    PaisDaoImpl paisDao = new PaisDaoImpl();
    	    List<Pais> paises = paisDao.obtenerPaises();
    	    Pais paisNacimiento = paises.stream()
    	                                .filter(p -> p.getNombre().equalsIgnoreCase(nacionalidad))
    	                                .findFirst()
    	                                .orElse(null);
    	    
    	    if (paisNacimiento == null) {
    	        response.getWriter().write("Error: País de nacimiento no encontrado.");
    	        return;
    	    }

    	    // Create Cliente object
    	    Cliente cliente = new Cliente(0, dni, cuil, nombre, apellido, sexo, paisNacimiento, fechaNacimiento, null);

    	    // Save the client in the database
    	    ClienteDaoImpl clienteDao = new ClienteDaoImpl();
    	    boolean estado = clienteDao.agregarCliente(cliente);

    	    if (estado) {
    	        response.getWriter().write("Cliente agregado exitosamente.");
    	    } else {
    	        response.getWriter().write("Error al agregar cliente.");
    	    }
    }

}
