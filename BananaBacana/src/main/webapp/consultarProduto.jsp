<%@ page import="java.util.*"%>
<%@ page import="banana.model.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bananaStyle.css">
<meta charset="UTF-8">
<title>Banana Bacana</title>
</head>
<body>
	<nav class="bananaNav">
		<ul>
			<li><span style="color: yellow">BananaBacana</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	<main class="bananaMain">
		<div class="bananaForm">
			<form action="buscarProdutos" method="post">
				<div>
					<label><strong>Busca pela Descrição:</strong></label><input
						class="bananaInputText" type="text" name="descricao">
				</div>
				<br>
				<div class="bananaColumn">
					<input class="bananaButton" id="bananaButton" type="submit"
						name="salvar" value="Consultar Produto">
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
			if (request.getAttribute("produtos") != null) {
				List<?> produtos = (List<?>) request.getAttribute("produtos");
				for (int contador = 0; contador <= (produtos.size() - 1); contador++) {
					Produto produto = (Produto) produtos.get(contador);
			%>
			<form action="modificarProduto" method="post">
				<table class="bananaTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>Descrição</th>
							<th>Quantidade</th>
							<th>Preço</th>
							<th>Online</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<%
								out.print(produto.getIdProduto());
								%> <input type="hidden" name="id"
								value="<%out.print(produto.getIdProduto());%>">
							</td>
							<td>
								<%
								out.print(produto.getDescricao());
								%>
							</td>
							<td>
								<%
								out.print(produto.getQuantidade());
								%>
							</td>
							<td>
								<%
								out.print(produto.getPreco());
								%>
							</td>
							<td>
								<%
								out.print(produto.isOnline());
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