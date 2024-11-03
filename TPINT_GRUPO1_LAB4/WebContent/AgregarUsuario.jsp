<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Agregar Usuario</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
        <h2 class="text-center mb-4">Agregar Usuario</h2>
        
            <form>
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" class="form-control" id="usuario" name="usuario" value="">
                </div>
                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" value="">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="" required>
                </div>
				<div class="form-group">
					<label for="admin">Admin:</label>
                    <select class="form-control" id="admin" name="admin" required>
                        <option value="0">No</option>
                        <option value="1" >Si</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-block mt-3">Agregar Usuario</button>
                <a class= "btn btn-secondary btn-block" href="ListarUsuarios.jsp">Volver</a>
            </form>

    </div>
</body>
</html>