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
 * Servlet implementation class servletListarCuentas
 */
@WebServlet("/servletListarCuentas")
public class servletListarCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CuentaDao cuentaDao = new CuentaDaoImpl();
		List<Cuenta> listado = new ArrayList<Cuenta>();
		listado = cuentaDao.obtenerCuentas();
		
		request.setAttribute("listado", listado);
		request.getRequestDispatcher("ListarCuentas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnModificar") != null)
		{
			Long nroCuenta = Long.parseLong(request.getParameter("nroCuenta"));
			TipoCuentaDao tipoCuentaDao = new TipoCuentaDaoImpl();
			List<TipoCuenta> listaTipoCuenta = new ArrayList<TipoCuenta>();
			listaTipoCuenta = tipoCuentaDao.obtenerCuentas();
			request.setAttribute("listaTiposCuentas", listaTipoCuenta);
			
			CuentaDao cuentaDao = new CuentaDaoImpl();
			Cuenta cuenta = cuentaDao.obtenerCuentaXNroCuenta(nroCuenta);
			request.setAttribute("cuenta", cuenta);
			
			request.getRequestDispatcher("ModificarCuenta.jsp").forward(request, response);
		}
		if(request.getParameter("btnEliminar") != null)
		{
			Long nroCuenta = Long.parseLong(request.getParameter("nroCuenta"));
			Cuenta aux = new Cuenta();
			aux.setNroCuenta(nroCuenta);
			CuentaDao cuentaDao = new CuentaDaoImpl();
			cuentaDao.darDeBajaCuenta(nroCuenta);
			doGet(request, response);
		}
	}

}
