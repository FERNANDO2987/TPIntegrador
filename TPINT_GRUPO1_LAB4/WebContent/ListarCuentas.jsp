<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entidad.Cuenta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listar Cuentas</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Icono -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

</head>
<body>
<div class="container mt-5">
        <h2 class="text-center mb-4">Listado de Cuentas</h2>
       <div class="d-flex justify-content-between align-items-center mb-4"> 
        <!-- Formulario de b�squeda  // NO TIENE ACTION NI METHOD -->
       <form class="form-inline mb-4" id="formBusqueda">
            <input type="text" name="criterio" class="form-control mr-2" placeholder="Buscar cuenta..." id="criterio">
            <button type="submit" class="btn btn-primary mr-2">Buscar</button>
            <a href="#" class="btn btn-secondary">Limpiar</a>
            
        </form>
        <a href="servletAgregarCuenta" class="btn btn-primary mr-2 mb-4">Agregar Nueva Cuenta</a>
         </div>
        <!-- Tabla de cuentas -->
        <%
            		List<Cuenta> listaCuenta;
		            if(request.getAttribute("listado") != null)
		        	{
		        		listaCuenta = (List<Cuenta>) request.getAttribute("listado");
		        	}
		            else
		            {
		            	listaCuenta = null;
		            }
					
					
		%>
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Nro Cuenta</th>
                    <th>CBU</th>
                    <th>Cliente</th>
                    <th>Tipo de Cuenta</th>
                    <th>Saldo</th>
                    <th>Activo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            
            <tbody>
            	<%
            		if (listaCuenta != null)
            		{
            			for(Cuenta cuenta : listaCuenta)
            			{
            				
            	%>
            			
							<tr>
								<form action="servletListarCuentas" method="post">
					                <td><%= cuenta.getNroCuenta() %><input type="hidden" value="<%= cuenta.getNroCuenta() %>" name="nroCuenta"></td>
				     				<td><%= cuenta.getCbu() %></td>
				                    <td><%= cuenta.getCliente().getNombre() %> <%= cuenta.getCliente().getApellido() %></td>
				                    <td><%= cuenta.getTipoCuenta().getDescripcion() %></td>
				                    <td>$<%= cuenta.getSaldo() %></td>
				                    <% if(cuenta.getEstado())
				                    	{%>
				                    		<td>Inactivo</td>
				                    <%  }
				                    	else
				                    	{%>
				                    		<td>Activo</td>
				                    <%	}%>				                    
				                    
				                    <td>
										<input type="submit" class="btn btn-primary btn-sm" name="btnModificar" value="Modificar">
				                        <input type="submit" class="btn btn-danger btn-sm" name="btnEliminar" value="Eliminar">
				                  	</td>
			                  	</form>
			                </tr>
		               
				<%
            			}
            		}
            		else
            		{
				%>
					<tr>
						
			                <td>-</td>
		     				<td>-</td>
		                    <td>-</td>
		                    <td>-</td>
		                    <td>$-</td>
		                    <td>-</td>
		                    <td>
								<input type="submit" class="btn btn-primary btn-sm" name="btnModificar" value="Modificar">
				                <input type="submit" class="btn btn-danger btn-sm" name="btnEliminar" value="Eliminar">
		                  	</td>
		                </tr>
					
				<%	} %>
   
            </tbody>
        </table>
	    
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>