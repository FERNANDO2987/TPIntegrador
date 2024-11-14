package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.UsuarioDao;
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
	
	    // Obtener el ID del usuario desde la URL
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("ListarUsuarios.jsp?error=ID no válido");
            return;
        }

        try {
            long id = Long.parseLong(idParam);

            // Buscar el usuario correspondiente en la base de datos
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            Usuario usuarioSeleccionado = usuarioDao.obtenerUsuarioPorId(id);

            if (usuarioSeleccionado != null) {
                // Pasar el usuario como atributo a la solicitud
                request.setAttribute("usuario", usuarioSeleccionado);
                // Redirigir al JSP para modificar el usuario
                request.getRequestDispatcher("ModificarUsuario.jsp").forward(request, response);
            } else {
                // Si el usuario no se encuentra, redirigir a la lista con un mensaje de error
                response.sendRedirect("ListarUsuarios.jsp?error=Usuario no encontrado");
            }
        } catch (NumberFormatException e) {
            // En caso de que el parámetro no sea un número válido
            response.sendRedirect("ListarUsuarios.jsp?error=ID no válido");
        } catch (Exception e) {
            // Captura de cualquier otro tipo de excepción
            e.printStackTrace();
            response.sendRedirect("ListarUsuarios.jsp?error=Error en el servidor");
        }
	}

	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	UsuarioDao usuarioDao = new UsuarioDaoImpl();  

        // Obtener los datos del formulario  
        long id = Long.parseLong(request.getParameter("id"));  
        String usuario = request.getParameter("usuario");  
        String password = request.getParameter("password");  
        String nombre = request.getParameter("nombre");  
        boolean admin = request.getParameter("admin") != null;  

        // Crear el objeto Usuario con los datos del formulario  
        Usuario usuarioModificado = new Usuario(id, usuario, password, nombre, admin);  

        boolean resultado = usuarioDao.modificarUsuario(usuarioModificado);  

        // Redirigir según el resultado  
        if (resultado) {  
            response.sendRedirect("ListadoUsuarios.jsp?mensaje=Usuario modificado con éxito");  
        } else {  
        	 response.sendRedirect("ListadoUsuarios.jsp?mensaje=Error");  
        }  
    	
    	
    }

}
