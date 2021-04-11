<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sumario</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>
.pattern {
	background-color: #39c0db;
	opacity: 1;
	background-image: linear-gradient(30deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(150deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(30deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(150deg, #000000 12%, transparent 12.5%, transparent 87%,
		#000000 87.5%, #000000),
		linear-gradient(60deg, #00000077 25%, transparent 25.5%, transparent 75%
		, #00000077 75%, #00000077),
		linear-gradient(60deg, #00000077 25%, transparent 25.5%, transparent 75%
		, #00000077 75%, #00000077);
	background-size: 40px 70px;
	background-position: 0 0, 0 0, 20px 35px, 20px 35px, 0 0, 20px 35px;
}

.black {
	background-color: #000000;
}
.vertical-center {
  min-height: 100%;  /* Fallback for browsers do NOT support vh unit */
  min-height: 100vh; /* These two lines are counted as one :-)       */

  align-items: center;
}
</style>
<body class="pattern">
	<div class="container black vertical-center">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 mt-4">
					<h3 class="text-center text-warning">SUMARIO</h3>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 py-3">
					<form action="geraGrupos" method="post">
						<button type="submit" value="gerar"
							class="btn btn-block btn-info btn-lg">GERAR GRUPOS</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 py-3">
					<form action="geraJogos" method="post">
						<button type="submit" value="Gerar"
							class="btn btn-success btn-block btn-lg">GERAR JOGOS</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 py-3">
					<form action="listagemGrupos" method="post">
						<button type="submit" value="mostrar"
							class="btn btn-block btn-lg btn-danger">MOSTRAR GRUPOS</button>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 py-3 text-center">
				<form action="pesquisaJogos" method="post">
					<div>
						<label class="text-white">PESQUISA POR DATA</label>
					</div>
					<div>
						<input type="date" name="data" id="data" placeholder="data">
					</div>
					<div>
						<input type="submit" value="Pesquisar">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>