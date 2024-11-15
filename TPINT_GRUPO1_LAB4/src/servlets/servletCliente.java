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
       

    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	
//    	
//        // Recuperación de los parámetros del formulario
//        String dniStr = request.getParameter("dni");
//        String cuilStr = request.getParameter("cuil");
//        String nombre = request.getParameter("nombre");
//        String apellido = request.getParameter("apellido");
//        String sexo = request.getParameter("sexo");
//        String paisNombre = request.getParameter("pais"); // País por nombre
//        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
//        String correoElectronico = request.getParameter("correoElectronico");
//        String telefono = request.getParameter("telefono");
//        String usuario = request.getParameter("usuario");
//        String contraseña = request.getParameter("contraseña");
//
//        // Validación de DNI y CUIL
//        int dni = 0;
//        int cuil = 0;
//        try {
//            dni = Integer.parseInt(dniStr);
//            cuil = Integer.parseInt(cuilStr);
//        } catch (NumberFormatException e) {
//            response.getWriter().write("Error: DNI o CUIL inválido.");
//            return;
//        }
//
//        // Validación y parseo de la fecha de nacimiento
//        LocalDate fechaNacimiento = null;
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
//        } catch (DateTimeParseException e) {
//            response.getWriter().write("Error: Formato de fecha inválido.");
//            return;
//        }
//
//        // Obtener todos los países
//        List<Pais> paises = paisDao.obtenerPaises();
//        Pais paisNacimiento = null;
//        for (Pais pais : paises) {
//            if (pais.getNombre().equalsIgnoreCase(paisNombre)) {
//                paisNacimiento = pais;
//                break;
//            }
//        }
//
//        if (paisNacimiento == null) {
//            response.getWriter().write("Error: País no encontrado.");
//            return;
//        }
//
//        long id=0;
//        // Crear objeto Cliente
//        Cliente cliente = new Cliente(id,dni, cuil, nombre, apellido, sexo, paisNacimiento, fechaNacimiento, correoElectronico, telefono, usuario, contraseña);
//
//        // Inserción del cliente en la base de datos
//        boolean estado = clienteDao.agregarCliente(cliente);
//
//        // Respuesta al cliente
//        if (estado) {
//            response.getWriter().write("Cliente agregado exitosamente.");
//        } else {
//            response.getWriter().write("Error al agregar cliente.");
//        }
    	
    }

}
