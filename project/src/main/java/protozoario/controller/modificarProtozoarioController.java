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
 * Servlet implementation class modificarProdutoController
 */
public class modificarProtozoarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public modificarProtozoarioController() {
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

			new Protozoario().excluir(Integer.valueOf(id));
			RequestDispatcher dispacher = request.getRequestDispatcher("consultarProtozoario.jsp");
			request.setAttribute("mensagem", "Protozoario apagado com sucesso!");
			dispacher.forward(request, response);

		} else if (alterar != null && id != null){
			Protozoario protozoario = new Protozoario().buscarProtozoarioPorId(Integer.valueOf(id));
			RequestDispatcher dispacher = request.getRequestDispatcher("alterarProtozoario.jsp");
			request.setAttribute("protozoario", protozoario);
			dispacher.forward(request, response);
		}
	}

}
