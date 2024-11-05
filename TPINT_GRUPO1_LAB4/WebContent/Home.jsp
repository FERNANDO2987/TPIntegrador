<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú de Gestión de Banco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function showAlert(option) {
            alert("Seleccionaste: " + option);
        }
        
        function redirectToHome() {
            window.location.href = 'tu_url_de_inicio_aqui'; //url
        }
    </script>
</head>
<body>

<div class="container mt-5">
    <h1>Menú de Gestión de Banco</h1>
    
    <button class="btn btn-primary mb-3" onclick="redirectToHome()">Inicio</button> <!-- Botón para ir a Inicio -->
    
    <div class="accordion" id="menuAccordion">
        <!-- Menú Administrador -->
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingAdmin">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseAdmin" aria-expanded="true" aria-controls="collapseAdmin">
                    Menú Administrador
                </button>
            </h2>
            <div id="collapseAdmin" class="accordion-collapse collapse show" aria-labelledby="headingAdmin" data-bs-parent="#menuAccordion">
                <div class="accordion-body">
                    <ul class="list-group">
                        <li class="list-group-item">Gestión de Clientes
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/AgregarCliente.jsp" class="text-decoration-none">Agregar Cliente</a></li>
                                <li><a href="<%= request.getContextPath() %>/ListarClientes.jsp" class="text-decoration-none">Listar Clientes</a></li>
                               
                            </ul>
                        </li>
                        <li class="list-group-item">Gestión de Usuarios
                            <ul>
                               <li><a href="#" onclick="showAlert('Asignar Usuario a Cliente')" class="text-decoration-none">Agregar Usuario</a></li>
                                <li><a href="ListarUsuarios.jsp" class="text-decoration-none">Listar Usuarios</a></li>
                               
                            </ul>
                        </li>
                        <li class="list-group-item">Gestión de Cuentas
                            <ul>
                                <li><a href="AgregarCuenta.jsp" class="text-decoration-none">Agregar Cuenta</a></li>
                                <li><a href="#" onclick="showAlert('Listar Cuentas')" class="text-decoration-none">Listar Cuentas</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Préstamos
                            <ul>
                                <li><a href="#" onclick="showAlert('Autorizar Préstamo')" class="text-decoration-none">Autorizar Préstamo</a></li>
                                <li><a href="#" onclick="showAlert('Rechazar Préstamo')" class="text-decoration-none">Rechazar Préstamo</a></li>
                                <li><a href="#" onclick="showAlert('Listar Préstamos')" class="text-decoration-none">Listar Préstamos</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Informes
                            <ul>
                                <li><a href="InformeIngresosEgresos.jsp" class="text-decoration-none">Generar Informe de Ingresos y Egresos</a></li>
                                <li><a href="InformeClientesActivosInactivos.jsp" class="text-decoration-none">Generar Informe de Clientes Activos</a></li>
                                <li><a href="#" onclick="showAlert('Otros Reportes Estadísticos')" class="text-decoration-none">Otros Reportes Estadísticos</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item"><button class="btn btn-danger" onclick="showAlert('Cerrar Sesión')">Cerrar Sesión</button></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Menú Cliente -->
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingCliente">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseCliente" aria-expanded="false" aria-controls="collapseCliente">
                    Menú Cliente
                </button>
            </h2>
            <div id="collapseCliente" class="accordion-collapse collapse" aria-labelledby="headingCliente" data-bs-parent="#menuAccordion">
                <div class="accordion-body">
                    <ul class="list-group">
                        <li class="list-group-item">Consultar Información Personal
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/VerDatosPersonales.jsp"  class="text-decoration-none">Ver Datos Personales</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Gestión de Cuentas
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/VerCuentasAsociadas.jsp"  class="text-decoration-none">Ver Cuentas Asociadas</a></li>
                       
                            </ul>
                        </li>
                        <li class="list-group-item">Transferencias
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/TransferirCuentasPropias.jsp"  class="text-decoration-none">Transferir Dinero Entre Cuentas Propias</a></li>
                                <li><a href="<%= request.getContextPath() %>/TransferirAOtroCliente.jsp"  class="text-decoration-none">Transferir Dinero a Otro Cliente</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Préstamos
                            <ul>
                                <li><a href="#" onclick="showAlert('Solicitar Préstamo')" class="text-decoration-none">Solicitar Préstamo</a></li>
                                <li><a href="#" onclick="showAlert('Ver Estado de Solicitud de Préstamo')" class="text-decoration-none">Ver Estado de Solicitud de Préstamo</a></li>
                                <li><a href="#" onclick="showAlert('Pagar Cuotas de Préstamo')" class="text-decoration-none">Pagar Cuotas de Préstamo</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item"><button class="btn btn-danger" onclick="showAlert('Cerrar Sesión')">Cerrar Sesión</button></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
