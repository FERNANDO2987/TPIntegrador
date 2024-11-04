<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        
        <!-- Formulario de b�squeda  // NO TIENE ACTION NI METHOD -->
       <form class="form-inline mb-4" id="formBusqueda">
            <input type="text" name="criterio" class="form-control mr-2" placeholder="Buscar cuenta..." id="criterio">
            <button type="submit" class="btn btn-primary mr-2">Buscar</button>
            <a href="#" class="btn btn-secondary">Limpiar</a>
        </form>
        
        <!-- Tabla de usuarios -->
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>N° Cuenta</th>
                    <th>CBU</th>
                    <th>ID Cliente</th>
                    <th>Tipo de Cuenta</th>
                    <th>Saldo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            
            <tbody>
				<tr>
	                <td>121</td>
     				<td>1234567878942597649199</td>
                    <td>2</td>
                    <td>Cuenta Corriente</td>
                    <td>$10.000,00</td>
                    <td>
						<a href="#" class="btn btn-primary btn-sm" title="Modificar">
                            <i class="fas fa-edit"></i>
                        </a>
                        <a href="#" class="btn btn-danger btn-sm" title="Eliminar" onclick="return confirm('¿Estas seguro de que deseas eliminar esta cuenta?');">
                        	<i class="fas fa-trash-alt"></i>
                        </a>
                  	</td>
                </tr>

   
            </tbody>
        </table>
	    <a class= "col btn btn-secondary" href="AgregarCuenta.jsp">Agregar Cuenta</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>