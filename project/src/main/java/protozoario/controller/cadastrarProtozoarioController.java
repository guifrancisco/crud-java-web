package protozoario.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import protozoario.model.Protozoario;

import java.io.IOException;


/**
 * Servlet implementation class cadastrarProdutoController
 */
public class cadastrarProtozoarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cadastrarProtozoarioController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Desta forma ele envia direto para o post, pois fazem o mesmo trabalho
		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		System.out.println("ENVIADO VIA POST");

		String nome = request.getParameter("nome");
		String filo = request.getParameter("filo");
		String classe = request.getParameter("classe");
		String ordem = request.getParameter("ordem");
		//boolean online = false;
		String mensagem;

		// Necess�rio para enviar o retorno da mensagem ao cliente
		RequestDispatcher dispacher = request.getRequestDispatcher("cadastrarProtozoario.jsp");

		// Valida��o dos campos
		if (nome != null && !nome.isEmpty() && filo != null
				&& !filo.isEmpty() && classe != null
				&& !classe.isEmpty()&& ordem != null
				&& !ordem.isEmpty()) {

			//int quantidade;
			//double preco;

			//quantidade = Integer.parseInt(request.getParameter("quantidade"));
			//preco = Double.parseDouble(request.getParameter("preco"));

			// Verifica se o campo n�o foi marcado pelo usuario para evitar erro
			//if (request.getParameter("online") != null && request.getParameter("online").equals("on")) {
			//	online = true;
			//}

			// Envia os valores para montagem do objeto usando o construtor
			Protozoario protozoario = new Protozoario(nome, filo, classe, ordem);
			protozoario.salvar();

			mensagem = "Protozoario cadastrado com sucesso!";

		} else {

			mensagem = "Os campos precisam ser preenchidos!";

		}

		// Fora do if para garantir que sempre ser� enviado
		request.setAttribute("mensagem", mensagem);
		dispacher.forward(request, response);

	}

}
