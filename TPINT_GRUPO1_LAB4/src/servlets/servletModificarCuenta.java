package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.CuentaDao;
import datos.TipoCuentaDao;
import datosImpl.CuentaDaoImpl;
import datosImpl.TipoCuentaDaoImpl;
import entidad.Cuenta;
import entidad.TipoCuenta;

/**
 * Servlet implementation class servletModificarCuenta
 */
@WebServlet("/servletModificarCuenta")
public class servletModificarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println((String) request.getParameter("txtCuenta"));
		System.out.println((String) request.getParameter("TipoCuenta"));
		System.out.println((String) request.getParameter("chkActivo"));
		if(request.getParameter("btnModificar") != null)
		{
			Cuenta cuenta = new Cuenta();
			cuenta.setNroCuenta(Long.parseLong((String) request.getParameter("txtCuenta")));
			cuenta.getTipoCuenta().setId(Integer.parseInt(request.getParameter("TipoCuenta")));
			Boolean chkActivo = request.getParameter("chkActivo") == "Activo"? false : true;
			cuenta.setEstado(chkActivo);
			
			//CuentaDao cuentaDao = new CuentaDaoImpl();
			boolean exito;
			//if(cuentaDao.modificarCuenta(cuenta))
			//{
			//	exito = true;
			//}
			//else
			//{
				exito = false;
			//}
			request.setAttribute("exito", exito );
			
		}	
		request.setAttribute("Recarga", 1);
		request.getRequestDispatcher("servletListarCuentas").forward(request, response);
		
	}

}
