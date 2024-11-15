package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ClienteDao;
import datos.CuentaDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.CuentaDaoImpl;
import entidad.Cliente;

/**
 * Servlet implementation class servletModificarCliente
 */
@WebServlet("/servletModificarCliente")
public class servletModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("btnModificarCliente") != null)
		{
			Cliente cliente = new Cliente();
			cliente.setId(Long.parseLong(request.getParameter("id")));
			cliente.setDni(Integer.parseInt(request.getParameter("txtDni")));
			cliente.setCuil(Integer.parseInt(request.getParameter("txtCuil")));
			
			cliente.setNombre(request.getParameter("txtNombre"));
			cliente.setApellido(request.getParameter("txtApellido"));
			cliente.setSexo(request.getParameter("txtSexo"));
			
			
			ClienteDao clienteDao = new ClienteDaoImpl();
			boolean exito;
			if(clienteDao.modificarCliente(cliente))
			{
				exito = true;
				System.out.println("Operacion exitosa");
			}
			else
			{
				exito = false;
				System.out.println("Sin cambios en DB");
			}
			request.setAttribute("exito", exito );
			
		}
		request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);
	}

}
