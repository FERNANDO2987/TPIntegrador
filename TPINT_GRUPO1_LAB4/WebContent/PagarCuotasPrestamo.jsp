<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pagar Cuotas de Préstamo</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Pagar Cuotas de Préstamo</h2>
        <form action="servletPagoCuotas" method="POST">
            <div class="form-group">
                <label for="numeroPrestamo">Número de Préstamo:</label>
                <input type="text" class="form-control" id="numeroPrestamo" name="numeroPrestamo" placeholder="Ingrese el número de préstamo" required>
            </div>
            <div class="form-group">
                <label for="montoCuota">Monto de la Cuota:</label>
                <input type="number" class="form-control" id="montoCuota" name="montoCuota" placeholder="Ingrese el monto a pagar" required>
            </div>
            <div class="form-group">
                <label for="fechaPago">Fecha de Pago:</label>
                <input type="date" class="form-control" id="fechaPago" name="fechaPago" required>
            </div>
            <div class="form-group">
                <label for="metodoPago">Método de Pago:</label>
                <select class="form-control" id="metodoPago" name="metodoPago" required>
                    <option value="">Seleccionar</option>
                    <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                    <option value="Débito Automático">Débito Automático</option>
                    <option value="Transferencia Bancaria">Transferencia Bancaria</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Pagar Cuota</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
