<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cliente" %>
<%@ page import="datos.ClienteDao" %>
<%@ page import="datosImpl.ClienteDaoImpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Cliente</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Modificar Cliente</h2>

        <%
            // Obtener el ID del cliente desde la solicitud
            int idCliente = Integer.parseInt(request.getParameter("id"));
            ClienteDao clienteDao = new ClienteDaoImpl();
            Cliente cliente = clienteDao.obtenerClientes().stream()
                    .filter(c -> c.getId() == idCliente)
                    .findFirst()
                    .orElse(null);

            if (cliente != null) {
        %>
            <form action="servletModificarCliente" method="post">
                <input type="hidden" name="id" value="<%= cliente.getId() %>"> <!-- Campo oculto para el ID -->

                <div class="form-group">
                    <label for="dni">DNI:</label>
                    <input type="text" class="form-control" id="dni" name="dni" value="<%= cliente.getDni() %>" required>
                </div>
                <div class="form-group">
                    <label for="cuil">CUIL:</label>
                    <input type="text" class="form-control" id="cuil" name="cuil" value="<%= cliente.getCuil() %>" required>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= cliente.getNombre() %>" required>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" value="<%= cliente.getApellido() %>" required>
                </div>
                <div class="form-group">
                    <label for="sexo">Sexo:</label>
                    <select class="form-control" id="sexo" name="sexo" required>
                        <option value="Masculino" <%= cliente.getSexo().equals("Masculino") ? "selected" : "" %>>Masculino</option>
                        <option value="Femenino" <%= cliente.getSexo().equals("Femenino") ? "selected" : "" %>>Femenino</option>
                        <option value="Otro" <%= cliente.getSexo().equals("Otro") ? "selected" : "" %>>Otro</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nacionalidad">Nacionalidad:</label>
                    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="<%= cliente.getNacionalidad() %>" required>
                </div>
                <div class="form-group">
                    <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<%= cliente.getFechaNacimiento() != null ? cliente.getFechaNacimiento().toString() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="direccion">Dirección:</label>
                    <input type="text" class="form-control" id="direccion" name="direccion" value="<%= cliente.getDireccion() %>" required>
                </div>
                <div class="form-group">
                    <label for="localidad">Localidad:</label>
                    <input type="text" class="form-control" id="localidad" name="localidad" value="<%= cliente.getLocalidad() %>" required>
                </div>
                <div class="form-group">
                    <label for="provincia">Provincia:</label>
                    <input type="text" class="form-control" id="provincia" name="provincia" value="<%= cliente.getProvincia() %>" required>
                </div>
                <div class="form-group">
                    <label for="correoElectronico">Correo Electrónico:</label>
                    <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" value="<%= cliente.getCorreoElectronico() %>" required>
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" class="form-control" id="telefono" name="telefono" value="<%= cliente.getTelefono() %>" required>
                </div>
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" class="form-control" id="usuario" name="usuario" value="<%= cliente.getUsuario() %>" required>
                </div>
                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" value="<%= cliente.getContraseña() %>"> <!-- Este campo puede ser opcional -->
                </div>

                <button type="submit" class="btn btn-primary btn-block">Modificar Cliente</button>
            </form>

            <% 
            } else { 
            %>
                <p>No se encontró el cliente.</p>
            <% 
            } 

            // Mostrar mensaje de error si existe
            String error = (String) request.getAttribute("error");
            if (error != null) { 
            %>
                <p style="color:red;"><%= error %></p>
            <% 
            } 
            %>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
