<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar Usuario</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Modificar Usuario</h2>
        
        <!-- Formulario para modificar un usuario -->
        <form action="servletModificarUsuario" method="post"> <!-- Cambiado para enviar los datos a servletModificarUsuario -->
            <div class="form-group">
                <label for="id">ID Usuario:</label>
                <input type="text" class="form-control" id="id" name="id" readonly value="${usuario.id}"> <!-- ID solo lectura -->
            </div>
            
            <div class="form-group">
                <label for="usuario">Usuario:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required value="${usuario.usuario}">
            </div>
            
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" class="form-control" id="password" name="password" required value="${usuario.password}">
            </div>
            
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required value="${usuario.nombre}">
            </div>
            
            <div class="form-group">
                <label for="admin">Admin:</label>
                <select class="form-control" id="admin" name="admin" required>
                    <option value="false" ${!usuario.admin ? 'selected' : ''}>No</option>
                    <option value="true" ${usuario.admin ? 'selected' : ''}>Sí</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block mt-3">Modificar Usuario</button>
            <a class="btn btn-secondary btn-block" href="ListarUsuarios.jsp">Volver</a>
        </form>
    </div>
</body>
</html>
