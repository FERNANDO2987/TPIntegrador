<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Agregar Usuario</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Agregar Usuario</h2>
        
        <form action="servletUsuario" method="post"> <!-- Cambiado para enviar los datos al servletUsuario -->
            <div class="form-group">
                <label for="usuario">Usuario:</label>
                <input type="text" class="form-control" id="usuario" name="usuario" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label> <!-- Cambiado el name a "password" -->
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="admin">Admin:</label>
                <select class="form-control" id="admin" name="admin" required>
                    <option value="false">No</option>
                    <option value="true">Sí</option>
                </select>
            </div>
         
             
                <button type="submit" class="btn btn-primary btn-block">Agregar Usuario</button>
            <a class="btn btn-secondary btn-block" href="ListarUsuarios.jsp">Volver</a>
        </form>

    </div>
</body>
</html>
