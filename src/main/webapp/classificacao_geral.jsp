<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jogos</title>
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
					CLASSIFICAÇÃO GERAL
					<table class="table">
						<thead>
							<tr>
								<th>TIME</th>
								<th>PTS</th>
								<th>PJ</th>
								<th>V</th>
								<th>D</th>
								<th>E</th>
								<th>GP</th>
								<th>GC</th>
								<th>SG</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="grupos" items="${listagem}"
								varStatus="contador">
								<tr class="table-warning">
									<c:if test="${contador.count == 1}">
										<td><input class="text-center"
											style="background-color: green;" value="${grupos.getTime()}"
											readonly></td>
									</c:if>
									<c:if test="${contador.count > 12}">
										<td><input class="text-center"
											style="background-color: red;" value="${grupos.getTime()}"
											readonly></td>
									</c:if>
									<c:if test="${contador.count > 1 && contador.count < 13}">
										<td><input class="text-center"
											value="${grupos.getTime()}" readonly></td>
									</c:if>
									<td>${grupos.getPontos()}</td>
									<td>${grupos.getnJogos()}</td>
									<td>${grupos.getVitorias()}</td>
									<td>${grupos.getDerrotas()}</td>
									<td>${grupos.getEmpates()}</td>
									<td>${grupos.getGolPro()}</td>
									<td>${grupos.getGolCom()}</td>
									<td>${grupos.getSaldoGol()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</h3>
			</div>
		</div>
	</div>

</body>
</html>