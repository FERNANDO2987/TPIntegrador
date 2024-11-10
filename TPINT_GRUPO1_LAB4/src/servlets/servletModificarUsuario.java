package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;

/**
 * Servlet implementation class servletModificarUsuario
 */
@WebServlet("/servletModificarUsuario")
public class servletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarUsuario() {
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

	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        long id = Long.parseLong(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        
        // Crear un objeto Usuario con los datos obtenidos
        Usuario usuarioModificado = new Usuario(id, usuario, password, nombre, admin);
        
        // Instancia de UsuarioDaoImpl y llamada a modificarUsuario
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        boolean resultado = usuarioDao.modificarUsuario(usuarioModificado);
        
        // Redirigir a una página de confirmación o lista de usuarios
        if (resultado) {
            response.sendRedirect("ListarUsuarios.jsp?mensaje=modificacionExitosa");
        } else {
            response.sendRedirect("ModificarUsuario.jsp?mensaje=modificacionFallida");
        }
    }

}
