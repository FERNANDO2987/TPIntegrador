<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cuenta</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
        <h2 class="text-center mb-4">Agregar Cuenta</h2>
        
            <form>
				<div class="form-group">
					<label for="admin">Tipo de cuenta:</label>
                    <select class="form-control" id="tiposcuenta" name="tiposcuenta" required>
                        <option value="1">Caja de ahorros</option>
                        <option value="2" >Cuenta corriente</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary btn-block mt-3">Agregar Cuenta</button>
                <a class= "btn btn-secondary btn-block" href="Home.jsp">Volver</a>
            </form>

    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>