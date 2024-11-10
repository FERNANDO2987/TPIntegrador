package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarUsuarios() {
        super();
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista completa de usuarios desde el DAO
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        List<Usuario> usuarios = usuarioDao.obtenerUsuarios();

        // Verificar si la lista de usuarios está vacía
        System.out.println("Usuarios obtenidos: " + usuarios.size());

        // Obtener el criterio de búsqueda de la solicitud (si existe)
        String criterio = request.getParameter("criterio");
        System.out.println("Criterio de búsqueda: " + criterio);

        // Si hay un criterio, filtrar los usuarios
        if (criterio != null && !criterio.trim().isEmpty()) {
            usuarios = usuarios.stream()
                .filter(usuario -> (usuario.getNombre() != null && usuario.getNombre().toLowerCase().contains(criterio.toLowerCase())) ||
                                   (usuario.getUsuario() != null && usuario.getUsuario().toLowerCase().contains(criterio.toLowerCase())))
                .collect(Collectors.toList());
            System.out.println("Usuarios después de filtrar: " + usuarios.size());
        }

        // Establecer los usuarios y el criterio como atributos para la vista
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("criterio", criterio);  // Mantener el valor del campo de búsqueda

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
