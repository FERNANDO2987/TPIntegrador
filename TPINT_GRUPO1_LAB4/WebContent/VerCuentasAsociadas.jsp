<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas Asociadas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="text-center mb-5">
        <h3>Cuentas Asociadas</h3>
    </div>

    <div class="row pt-1">
		
		<%
			//obtner lista de prestamos del request
			List<Cuenta> listaCuentas = (List<Cuenta>)request.getAttribute("listado");
			if(listaCuentas == null || listaCuentas.isEmpty()){
		%>
		<div class="alert alert-warning" role="alert">
			No se encontraron pr�stamos para mostrar.
		</div>
		<%
			} else {
		%>
        <div class="col-md-4">
        
        	<%
        		for (Cuenta c : listaCuentas)
        		{
        	%>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Nro de Cuenta: <%=c.getNroCuenta()%></h5>
                    <hr>
                    <p class="card-text">
                        <strong><%=c.getTipoCuenta().getDescripcion()%></strong><hr>
                        <strong>CBU:</strong> <%=c.getCbu()%> <hr>
                        <strong>Fecha de creacion:</strong> <%=c.getFechaCreacion()%>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item" style="font-size: 23px;"><strong> $423.588,58 </strong></li>
                </ul>
                <div class="card-body pt-1 pb-1">
                	<form method="get" action="servletListarMovimientosXCuenta">
                		<input type="submit" name="btnListarMovimientosXCuenta" value="Historial de movimientos" class="btn btn-secondary">
                		<input type="hidden" name="nrocuenta" value="<%=c.getNroCuenta()%>">
                	</form>
                </div>
            </div>       
            <%
				}
			%>
        </div>
        <%
			}
		%>

        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Cuenta N�3</h5>
                    <hr>
                    <p class="card-text">
                        <strong>Caja de Ahorro</strong><hr>
                        <strong>CBU:</strong> 18797894565641 <hr>
                        <strong>Fecha de creacion:</strong> 11/09/2021
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item" style="font-size: 23px;"><strong> $37.255,99 </strong></li>
                </ul>
                <div class="card-body pt-1 pb-1">
                    <a href="<%= request.getContextPath() %>/HistorialDeMovimientos.jsp" style="font-size:13px;">Historial de movimientos</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <a href="AgregarCuenta.jsp" class="card d-flex align-items-center justify-content-center text-decoration-none" style="width: 18rem; height: 100%;">
                <div class="text-center">
                    <h1 style="font-size: 50px; margin: 0;">+</h1>
                    <p><strong>Agregar nueva cuenta</strong></p>
                </div>
            </a>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
