<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Solicitar Préstamo</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Solicitar Préstamo</h2>
        <form action="servletPrestamo" method="POST">
            <div class="form-group">
                <label for="tipoPrestamo">Tipo de Préstamo:</label>
                <select class="form-control" id="tipoPrestamo" name="tipoPrestamo" required>
                    <option value="">Seleccionar</option>
                    <option value="Personal">Préstamo Personal</option>
                    <option value="Hipotecario">Préstamo Hipotecario</option>
                    <option value="Automotriz">Préstamo Automotriz</option>
                </select>
            </div>
            <div class="form-group">
                <label for="monto">Monto Solicitado:</label>
                <input type="number" class="form-control" id="monto" name="monto" placeholder="Ingrese el monto a solicitar" required>
            </div>
            <div class="form-group">
                <label for="plazo">Plazo (en meses):</label>
                <input type="number" class="form-control" id="plazo" name="plazo" placeholder="Ingrese el plazo en meses" required>
            </div>
            <div class="form-group">
                <label for="ingresos">Ingresos Mensuales:</label>
                <input type="number" class="form-control" id="ingresos" name="ingresos" placeholder="Ingrese sus ingresos mensuales" required>
            </div>
            <div class="form-group">
                <label for="detalle">Detalle (opcional):</label>
                <input type="text" class="form-control" id="detalle" name="detalle" placeholder="Descripción de la solicitud">
            </div>
            <button type="submit" class="btn btn-primary btn-block">Solicitar Préstamo</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
