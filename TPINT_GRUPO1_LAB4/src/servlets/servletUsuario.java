package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidad.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;



@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  private UsuarioNeg usuarioNeg = new UsuarioNegImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUsuario() {
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
	       String usuario = request.getParameter("usuario");
	        String password = request.getParameter("password");
	        String nombre = request.getParameter("nombre");
	        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setUsuario(usuario);
	        nuevoUsuario.setPassword(password);
	        nuevoUsuario.setNombre(nombre);
	        nuevoUsuario.setAdmin(admin);

	        boolean isInserted = usuarioNeg.insertarUsuario(nuevoUsuario);
	        if (isInserted) {
	            // Redirect to ListarUsuarios.jsp with a success message
	            response.sendRedirect("ListarUsuarios.jsp?mensaje=Usuario agregado correctamente");
	        } else {
	            response.getWriter().write("Error al agregar el usuario.");
	        }
	}

}
