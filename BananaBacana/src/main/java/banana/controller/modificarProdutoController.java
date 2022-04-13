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
 * Servlet implementation class modificarProdutoController
 */
public class modificarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public modificarProdutoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String apagar = request.getParameter("apagar");
		String alterar = request.getParameter("alterar");
		String id = request.getParameter("id");

		if (apagar != null && id != null) {

			new Produto().excluir(Integer.valueOf(id));
			RequestDispatcher dispacher = request.getRequestDispatcher("consultarProduto.jsp");
			request.setAttribute("mensagem", "Produto apagado com sucesso!");
			dispacher.forward(request, response);

		} else if (alterar != null && id != null){
			Produto produto = new Produto().buscarProdutoPorId(Integer.valueOf(id));
			RequestDispatcher dispacher = request.getRequestDispatcher("alterarProduto.jsp");
			request.setAttribute("produto", produto);
			dispacher.forward(request, response);
		}
	}

}
