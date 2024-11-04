<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Informes de Clientes Activos e Inactivos</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Icono -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
	<div class="container mt-5" style="width: 800px; height: 400px;">
		<h2 class="text-center mb-4">Informe de Clientes Activos e Inactivos</h2>     
		
		<div>
  			<canvas id="myChart_Clientes" ></canvas>
		</div>
		<div>
  			<a class= "col btn btn-secondary" href="#">Generar Informe</a>
		</div>
	</div>	
	
	<!-- Graficas de Clientes -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script>
		const ctx1 = document.getElementById('myChart_Clientes');
		new Chart(ctx1, {
		  type: 'doughnut',
		  data: {
		    labels: ['Activos', 'Inactivos'],
		    datasets: [{
		      label: ' Ingresos',
		      data: [12, 5],  //Ejemplos de valor
		      backgroundColor:[
		          'rgb(54, 162, 235)',
		    	  'rgb(255, 99, 132)'
		      ],
		      borderWidth: 1
		    }]
		  },
		  options: {
		    scales: {
		      y: {
		        beginAtZero: true,
		      }
		    }
		  }
		});
	</script>
</body>
</html>