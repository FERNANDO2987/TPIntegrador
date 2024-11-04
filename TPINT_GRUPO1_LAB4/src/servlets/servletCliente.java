package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.ClienteDaoImpl;
import entidad.Cliente;

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
//        String dni = request.getParameter("dni");
//        String cuil = request.getParameter("cuil");
//        String nombre = request.getParameter("nombre");
//        String apellido = request.getParameter("apellido");
//        String sexo = request.getParameter("sexo");
//        String nacionalidad = request.getParameter("nacionalidad");
//        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
//
//        LocalDate fechaNacimiento = null;
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Ajuste de formato de fecha
//            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
//        } catch (DateTimeParseException e) {
//            response.getWriter().write("Error: Formato de fecha inv�lido.");
//            return; // Detiene el procesamiento si hay un error en el formato de fecha
//        }
//
//        String direccion = request.getParameter("direccion");
//        String localidad = request.getParameter("localidad");
//        String provincia = request.getParameter("provincia");
//        String correoElectronico = request.getParameter("correoElectronico");
//        String telefono = request.getParameter("telefono");
//        String usuario = request.getParameter("usuario");
//        String contraseña = request.getParameter("contraseña");
//
//        Cliente cliente = new Cliente(0, dni, cuil, nombre, apellido, sexo, nacionalidad, fechaNacimiento, direccion, localidad, provincia, correoElectronico, telefono, usuario, contraseña);
//
//        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
//        boolean estado = clienteDao.agregarCliente(cliente);
//
//        if (estado) {
//            response.getWriter().write("Cliente agregado exitosamente.");
//        } else {
//            response.getWriter().write("Error al agregar cliente.");
//        }
    }

}
