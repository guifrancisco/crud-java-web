package banana.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import banana.model.Produto;

/**
 * Servlet implementation class cadastrarProdutoController
 */
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cadastrarProdutoController() {
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

		String descricao = request.getParameter("descricao");
		boolean online = false;
		String mensagem;

		// Necessário para enviar o retorno da mensagem ao cliente
		RequestDispatcher dispacher = request.getRequestDispatcher("cadastrarProduto.jsp");

		// Validação dos campos
		if (descricao != null && !descricao.isEmpty() && request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() && request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {

			int quantidade;
			double preco;

			quantidade = Integer.parseInt(request.getParameter("quantidade"));
			preco = Double.parseDouble(request.getParameter("preco"));

			// Verifica se o campo não foi marcado pelo usuario para evitar erro
			if (request.getParameter("online") != null && request.getParameter("online").equals("on")) {
				online = true;
			}

			// Envia os valores para montagem do objeto usando o construtor
			Produto produto = new Produto(descricao, quantidade, preco, online);
			produto.salvar();

			mensagem = "Produto cadastrado com sucesso!";

		} else {

			mensagem = "Os campos precisam ser preenchidos!";

		}

		// Fora do if para garantir que sempre será enviado
		request.setAttribute("mensagem", mensagem);
		dispacher.forward(request, response);

	}

}
