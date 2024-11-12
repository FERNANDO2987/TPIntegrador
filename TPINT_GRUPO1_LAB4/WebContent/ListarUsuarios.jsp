<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="entidad.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listado de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Icono -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Listado de Usuarios</h2>
        
        <!-- Formulario de búsqueda -->



   
        <form action="servletListarUsuarios" method="get" class="form-inline mb-4" id="formBusqueda">
            <input type="text" name="criterio" class="form-control mr-2" placeholder="Buscar cliente..." value="${criterio}">
            <button type="submit" class="btn btn-primary mr-2">Buscar</button>
            <a href="servletListarUsuarios" class="btn btn-secondary">Limpiar</a> <!-- Bot�n de limpiar -->
         
        </form>
        
        <!-- Tabla de usuarios -->
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Nombre</th>
                    <th>Rol</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Recuperar la lista de usuarios
                    List<?> usuarios = (List<?>) request.getAttribute("usuarios");
                    if (usuarios != null) {
                        for (Object obj : usuarios) {
                            Usuario usuario = (Usuario) obj;
                %>
                            <tr>
                                <td><%= usuario.getId() %></td>
                                <td><%= usuario.getUsuario() %></td>
                                <td><%= usuario.getNombre() %></td>
                                <td><%= usuario.isAdmin() ? "Administrador" : "Usuario" %></td>
                                <td>
                                  <a href="servletModificarUsuario?id=<%= usuario.getId() %>" class="btn btn-warning btn-sm" title="Editar"> <i class="fas fa-edit"></i></a>

                                    <a href="servletEliminarUsuario?id=<%= usuario.getId() %>" class="btn btn-danger btn-sm" title="Eliminar" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                </td>
                            </tr>
                <%
                        }
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
