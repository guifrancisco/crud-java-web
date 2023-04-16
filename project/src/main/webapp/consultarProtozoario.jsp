<%@ page import="java.util.*"%>
<%@ page import="protozoario.model.Protozoario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Protozoario</title>
</head>
<body>
	<nav class="protoNav">
		<ul>
			<li><span style="color: blue">Protozoario</span></li>
			<li><a href="cadastrarProtozoario.jsp">Cadastrar Protozoario</a></li>
			<li><a href="consultarProtozoario.jsp">Consultar Protozoario</a></li>
		</ul>
	</nav>
	<main class="protoMain">
		<div class="protoForm">
			<form action="buscarProtozoario" method="post">
				<div>
					<label><strong>Busca pelo Nome:</strong></label><input
						class="text" type="text" name="nome">
				</div>
				<br>
				<div class="protoColumn">
					<input class="protoButton" id="protoButton" type="submit"
						name="salvar" value="Consultar Protozoario">
				</div>
			</form>

			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null) {
					out.print(mensagem);
				}
				%>
			</div>
			<%
			if (request.getAttribute("protozoarios") != null) {
				List<?> protozoarios = (List<?>) request.getAttribute("protozoarios");
				for (int contador = 0; contador <= (protozoarios.size() - 1); contador++) {
					Protozoario protozoario = (Protozoario) protozoarios.get(contador);
			%>
			<form action="modificarProtozoario" method="post">
				<table class="protoTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Filo</th>
							<th>Classe</th>
							<th>Ordem</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
								out.print(protozoario.getIdProtozoario());
								%> <input type="hidden" name="id"
								value="<%out.print(protozoario.getIdProtozoario());%>">
							</td>
							<td>
								<%
								out.print(protozoario.getNome());
								%>
							</td>
							<td>
								<%
								out.print(protozoario.getFilo());
								%>
							</td>
							<td>
								<%
								out.print(protozoario.getClasse());
								%>
							</td>
							<td>
								<%
								out.print(protozoario.getOrdem());
								%>
							</td>
							<td><input id="" type="submit" name="alterar"
								value="Alterar"> <input id="" type="submit"
								name="apagar" value="Apagar"></td>
						</tr>
					</tbody>
				</table>
				<br>
				<%
				}
				}
				%>
			</form>
		</div>
	</main>
</body>
</html>