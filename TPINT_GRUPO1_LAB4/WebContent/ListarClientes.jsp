<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entidad.Cliente" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listado de Clientes</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Icono -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Listado de Clientes</h2>
        
        <!-- Formulario de b�squeda -->
        <form action="servletListarCliente" method="get" class="form-inline mb-4">
            <input type="text" name="criterio" class="form-control mr-2" placeholder="Buscar cliente..." value="${criterio}">
            <button type="submit" class="btn btn-primary mr-2">Buscar</button>
            <a href="servletListarCliente" class="btn btn-secondary">Limpiar</a> <!-- Bot�n de limpiar -->
        </form>
        
        <!-- Tabla de clientes -->
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>CUIL</th>
                    <th>Sexo</th>
                    <th>Nacionalidad</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Direcci�n</th>
                    <th>Localidad</th>
                    <th>Provincia</th>
                    <th>Correo Electr�nico</th>
                    <th>Tel�fono</th>
                    <th>Usuario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Retrieve the list of clients from the request and check its type
                    Object clientesObj = request.getAttribute("clientes");
                    if (clientesObj instanceof List<?>) {
                        List<?> clientesList = (List<?>) clientesObj;
                        for (Object obj : clientesList) {
                            if (obj instanceof Cliente) {
                                Cliente cliente = (Cliente) obj;
                %>
                                <tr>
                                    <td><%= cliente.getId() %></td>
                                    <td><%= cliente.getDni() %></td>
                                    <td><%= cliente.getNombre() %></td>
                                    <td><%= cliente.getApellido() %></td>
                                    <td><%= cliente.getCuil() %></td>
                                    <td><%= cliente.getSexo() %></td>
                                    <td><%= cliente.getNacionalidad() %></td>
                                    <td><%= cliente.getFechaNacimiento() %></td>
                                    <td><%= cliente.getDireccion() %></td>
                                    <td><%= cliente.getLocalidad() %></td>
                                    <td><%= cliente.getProvincia() %></td>
                                    <td><%= cliente.getCorreoElectronico() %></td>
                                    <td><%= cliente.getTelefono() %></td>
                                    <td><%= cliente.getUsuario() %></td>
                                    <td>
                                        <a href="ModificarCliente.jsp?id=<%= cliente.getId() %>" class="btn btn-warning btn-sm" title="Editar">
                                            <i class="fas fa-edit"></i>
                                        </a>
                                        <a href="eliminarCliente?id=<%= cliente.getId() %>" class="btn btn-danger btn-sm" title="Eliminar">
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                    </td>
                                </tr>
                <%
                            }
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="15" class="text-center">No se encontraron clientes.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
