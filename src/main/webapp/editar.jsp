<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="center blue-text text-darken-2">Editar contato</h1>

	<div class="container">
		<div class="row container center">
			<div class="input-field col s12 centered">
				<form name="frmContato" action="update">
					<table>
						<tr>
							<td><input type="text" name="idcontato" class="caixa3"
								readonly
								value="<%out.print(request.getAttribute("idcontato"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="nome" class="caixa1"
								value="<%out.print(request.getAttribute("nome"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="fone" class="caixa2"
								value="<%out.print(request.getAttribute("fone"));%>"></td>
						</tr>
						<tr>
							<td><input type="text" name="email" class="caixa1"
								value="<%out.print(request.getAttribute("email"));%>"></td>
						</tr>
					</table>
					<input type="button" value="Salvar" class="waves-effect light-blue darken-4 btn text-white"
						onclick="validar()">
				</form>
			</div>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>