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

	        Usuario nuevoUsuario = new Usuario(0, usuario, password, nombre, admin);
	        

	        boolean usuarioAgregado = usuarioNeg.insertarUsuario(nuevoUsuario);
	        // Si el usuario se agregó correctamente, muestra un mensaje en la misma página
	        if (usuarioAgregado) {
	            request.setAttribute("mensaje", "Usuario agregado correctamente.");
	    
	        } else {
	            // Si hubo un error, muestra un mensaje de error
	            request.setAttribute("mensaje", "Hubo un error al agregar el usuario.");
	        }
	        request.getRequestDispatcher("AgregarUsuario.jsp").forward(request, response);
	        
	}

}
