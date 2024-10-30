<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Iniciar Sesión</h2>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <%
                    // Verifica si hay un error en las credenciales
                    String error = request.getParameter("error");
                    if ("true".equals(error)) {
                %>
                    <div class="alert alert-danger" role="alert">
                        Credenciales no válidas. Inténtalo de nuevo.
                    </div>
                <% } %>
                <form action="servletLogin" method="post"> 
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" id="usuario" name="usuario" 
                               placeholder="Ingresa tu usuario" 
                               value="<%= request.getParameter("usuario") != null ? request.getParameter("usuario") : "" %>">
                    </div>
                    <div class="form-group">
                        <label for="contraseña">Contraseña</label>
                        <input type="password" class="form-control" id="contraseña" name="contraseña" 
                               placeholder="Ingresa tu contraseña">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
