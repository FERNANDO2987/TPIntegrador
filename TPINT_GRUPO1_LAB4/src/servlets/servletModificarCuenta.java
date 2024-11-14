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
		
		if(request.getParameter("btnModificarCuenta") != null)
		{	
			
			Cuenta cuenta = new Cuenta();
			cuenta.setNroCuenta(Long.parseLong((String) request.getParameter("txtCuenta")));
			cuenta.getTipoCuenta().setId(Integer.parseInt(request.getParameter("TipoCuenta")));
			Boolean chkActivo = request.getParameter("chkActivo") == "Activo"? true : false;
			cuenta.setEstado(chkActivo);
			
			CuentaDao cuentaDao = new CuentaDaoImpl();
			boolean exito;
			if(cuentaDao.modificarCuenta(cuenta))
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
		request.getRequestDispatcher("ModificarCuenta.jsp").forward(request, response);
		
	}

}
