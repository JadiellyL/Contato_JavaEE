<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="row">
		<div class="col s12">
			<h1 class="center blue-text text-darken-2">Agenda de contatos</h1>
		</div>
	</div>
	
	<div class="container center row">

		<a href="novo.html" class="waves-effect light-blue darken-4 btn white-text">Novo
			contato</a> <a href="report"
			class="waves-effect red darken-2 btn white-text">Relatorio</a>
	</div>

	<div class="container row">
		<table class="centered">
			<thead class="light-blue darken-4">
				<tr class="white-text">
					<th>Id</th>
					<th>Nome</th>
					<th>Fone</th>
					<th>Email</th>
					<th>Opções</th>
				</tr>
			</thead>

			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getIdcontato()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a
						href="select?idcontato=<%=lista.get(i).getIdcontato()%>"
						class="waves-effect light-blue darken-4 btn white-text">Editar</a> <a
						href="javascript:confirmar(<%=lista.get(i).getIdcontato()%>)"
						class="waves-effect red darken-2 btn white-text">Excluir</a></td>
				</tr>
				<%}%>
			</tbody>
		</table>
	</div>
	<script src="scripts/confirmador.js"></script>
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>