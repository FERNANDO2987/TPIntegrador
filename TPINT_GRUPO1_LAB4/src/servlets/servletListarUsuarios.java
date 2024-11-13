package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;

/**
 * Servlet implementation class servletListarUsuarios
 */
@WebServlet("/servletListarUsuarios")
public class servletListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private UsuarioDaoImpl usuarioDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarUsuarios() {
        super();
        this.usuarioDao = new UsuarioDaoImpl(); // Inicializar aquí  
        List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
    }
    
    @Override
    public void init() throws ServletException {
        // Este método se ejecuta una sola vez cuando el servlet es cargado
        // Cargar los usuarios al inicio
        List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
        getServletContext().setAttribute("usuarios", usuarios); // Guardar usuarios globalmente en el contexto del servlet
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   List<Usuario> usuarios = usuarioDao.obtenerUsuarios(); // Obtener usuarios aquí  

           // Obtener el criterio de búsqueda de la solicitud (si existe)  
           String criterio = request.getParameter("criterio");  

           // Si hay un criterio, filtrar los usuarios  
           if (criterio != null && !criterio.trim().isEmpty()) {  
               usuarios = usuarios.stream()  
                   .filter(usuario -> (usuario.getNombre() != null && usuario.getNombre().toLowerCase().contains(criterio.toLowerCase())) ||  
                                      (usuario.getUsuario() != null && usuario.getUsuario().toLowerCase().contains(criterio.toLowerCase())))  
                   .collect(Collectors.toList());  
           }  

           // Establecer los usuarios y el criterio como atributos para la vista  
           request.setAttribute("usuarios", usuarios);  
           request.setAttribute("criterio", criterio);  

           // Redirigir a la vista JSP para mostrar los usuarios  
           request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);  
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
