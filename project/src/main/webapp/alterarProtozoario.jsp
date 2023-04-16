<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="protozoario.model.Protozoario"%>	
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
		<form action="alterarProtozoario" method="post" class="protoForm">
			<%
			Protozoario protozoario = null;
			if (request.getAttribute("protozoario") != null){
				protozoario = (Protozoario) request.getAttribute("protozoario");
			}
			%>
		
			<div>
				<label><strong>Nome:</strong></label><input class="text" type="text"
					name="nome" value="<%out.print(protozoario.getNome());%>">
			</div>
			<div>
				<label><strong>Filo:</strong></label><input class="text" type="text"
					name="filo" value="<%out.print(protozoario.getFilo());%>">
			</div>
			<div>
				<label><strong>Classe:</strong></label><input class="text" type="text"
					name="classe" value="<%out.print(protozoario.getClasse());%>">
			</div>

			<label><strong>Ordem:</strong></label><input class="text" type="text" 
					name="ordem" value="<%out.print(protozoario.getOrdem());%>"><br>
			<div>
				<input class="protoButton" type="submit" name="alterar"
					value="Alterar Protozoario">
			</div>
			
			<div>
				<input type="hidden" name="id" value="<%out.print(protozoario.getIdProtozoario());%>">
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