package datosImpl;

import java.util.ArrayList;
import java.util.List;

import datos.TipoCuentaDao;
import entidad.TipoCuenta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TipoCuentaDaoImpl implements TipoCuentaDao {
	
	private Conexion cn;
	private final String querySeleccion = "Select * from tiposcuenta";
	@Override
	public List<TipoCuenta> obtenerCuentas() {
		List<TipoCuenta> lista = new ArrayList<TipoCuenta>();
		cn = new Conexion();
		cn.Open();
		
		try
		{
			PreparedStatement prst = cn.connection.prepareStatement(querySeleccion);
			prst.execute();
			ResultSet rs = prst.getResultSet();
			while(rs.next())
			{
				TipoCuenta aux = new TipoCuenta();
				aux.setId(rs.getInt("id"));
				aux.setDescripcion(rs.getString("descripcion"));
				
				lista.add(aux);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return lista;
	}

}
