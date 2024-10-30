package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        System.out.println("Usuario ingresado: " + usuario);
        System.out.println("Contraseña ingresada: " + contraseña);

        // Verificar si ambos campos están vacíos
        if (usuario == null || usuario.isEmpty()) {
            // Permitir acceso sin credenciales
            HttpSession session = request.getSession();
            session.setAttribute("usuario", "Guest"); 
            System.out.println("Acceso exitoso sin credenciales");
            response.sendRedirect("Home.jsp");
        } else if (!contraseña.isEmpty()) {
           
            //validación es exitosa:
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            System.out.println("Inicio de sesión exitoso para: " + usuario);
            response.sendRedirect("Home.jsp");
        } else {
            // Redirigir al login 
            System.out.println("Error en inicio de sesión para: " + usuario);
            response.sendRedirect("Login.jsp?error=true");
        }
    }
}
