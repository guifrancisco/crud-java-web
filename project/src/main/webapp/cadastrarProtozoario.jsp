<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Protozoarios</title>
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
		<form action="cadastrarProtozoario" method="post" class="protoForm">
			<div>
				<label><strong>Nome:</strong></label><input class="text" type="text"
					name="nome">
			</div>
			<div>
				<label><strong>Filo:</strong></label><input class="text" type="text"
					name="filo">
			</div>
			<div>
				<label><strong>Classe:</strong></label><input class="text" type="text"
					name="classe">
			</div>

			<div>
				<label><strong>Ordem:</strong></label><input class="text" type="text"
					name="ordem">
			</div>
			<div>
				<input class="protoButton" type="submit" name="salvar"
					value="Cadastrar Protozoario"><br>
			</div>

			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null) {
					out.print(mensagem);
				}
				%>
			</div>
		</form>
	</main>

</body>
</html>