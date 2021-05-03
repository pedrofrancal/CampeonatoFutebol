<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jogos por Data</title>
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
</style>
<body class="black">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-success text-center">
					JOGOS NO DIA
					<c:out value="${data}"></c:out>
					<form action="atualizaJogos" method="post">
						<table class="table">
							<thead>
								<tr>
									<th>TIME A</th>
									<th>GOLS</th>
									<th></th>
									<th>GOLS</th>
									<th>Time B</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="grupos" items="${listagem}" varStatus="contador" >
									<tr class="table-warning">
										<input type="hidden" name="codigoA${contador.count}"
											value="${grupos.getCodigoTimeA()}" type="text">
										<input type="hidden" name="codigoB${contador.count}"
											value="${grupos.getCodigoTimeB()}" type="text">
										<td><input class="text-center"
											name="timeA${contador.count}"
											value="${grupos.getNomeTimeA()}" readonly></td>
										<td>
											<div class="form-group mx-sm-3 mb-2">
												<input class="form-control text-center" type="number"
													name="golsA${contador.count}"
													value="${grupos.getGolsTimeA()}">
											</div>
										</td>
										<td>X</td>
										<td>
											<div class="form-group mx-sm-3 mb-2">
												<input class="form-control text-center" type="number"
													name="golsB${contador.count}"
													value="${grupos.getGolsTimeB()}">
											</div>
										</td>
										<td><input class="text-center"
											name="timeA${contador.count}"
											value="${grupos.getNomeTimeB()}" readonly></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<input type="submit" value="ATUALIZAR PLACAR">
					</form>
				</h3>
			</div>
		</div>
	</div>
</body>
</html>