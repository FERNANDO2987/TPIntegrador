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
        <form action="servletModificarUsuario" method="post">
            <input type="hidden" name="id" value="${usuario.id}">
            <div class="form-group">
                <label>Usuario</label>
                <input type="text" name="usuario" class="form-control" value="${usuario.usuario}" required>
            </div>
            <div class="form-group">
                <label>Contraseña</label>
                <input type="password" name="password" class="form-control" value="${usuario.password}" required>
            </div>
            <div class="form-group">
                <label>Nombre</label>
                <input type="text" name="nombre" class="form-control" value="${usuario.nombre}" required>
            </div>
            <div class="form-check">
                <input type="checkbox" name="admin" class="form-check-input" ${usuario.admin ? 'checked' : ''}>
                <label class="form-check-label">Administrador</label>
            </div>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="ListadoUsuarios.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
