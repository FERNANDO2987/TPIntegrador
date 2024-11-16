package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Pais;
import negocio.ClienteNeg;
import negocio.PaisNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.PaisNegImpl;



/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/servletCliente")
public class servletAgregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClienteNeg  clienteNeg = new ClienteNegImpl();
	private PaisNeg paisNeg = new PaisNegImpl();

    public servletAgregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	
        // Crear el objeto Cliente  
        Cliente cliente = new Cliente();  
        cliente.setDni(Long.parseLong(request.getParameter("dni")));  
        cliente.setCuil(Long.parseLong(request.getParameter("cuil")));  
        cliente.setNombre(request.getParameter("nombre"));  
        cliente.setApellido(request.getParameter("apellido"));  
        cliente.setSexo(request.getParameter("sexo"));  
        cliente.setUsuario(request.getParameter("usuario"));  
        cliente.setPassword(request.getParameter("contraseña")); // Recuerda encriptar la contraseña  
        cliente.setFechaNacimiento(LocalDate.parse(request.getParameter("fechaNacimiento")));  
        cliente.setCorreo(request.getParameter("correoElectronico"));  
        cliente.setTelefono(request.getParameter("telefono"));  
        cliente.setCelular(request.getParameter("celular"));  
        cliente.setAdmin(request.getParameter("admin") != null && request.getParameter("admin").equals("true"));  
    
        // Obtener el ID del país, si existe  
        String paisId = request.getParameter("paisNacimiento");  
        if (paisId != null && !paisId.isEmpty()) {  
            Pais pais = new Pais();  
            pais.setId(Integer.parseInt(paisId));  
            cliente.setPaisNacimiento(pais); // Establecer el país al cliente  
        }  

        // Crear la instancia de ClienteNegImpl  
        ClienteNeg clienteNeg = new ClienteNegImpl();  

        // Llamar al método insertarCliente  
        boolean resultado = clienteNeg.insertarCliente(cliente);  

        // Manejo de la respuesta  
        HttpSession session = request.getSession();  
        if (resultado) {  
            session.setAttribute("mensaje", "Cliente agregado exitosamente.");  
        } else {  
            session.setAttribute("mensaje", "Error al agregar el cliente.");  
        }  

        // Redireccionar a una página (puedes cambiar "AgregarCliente.jsp" por la que estés usando)  
        response.sendRedirect("AgregarCliente.jsp");  
    }

}
