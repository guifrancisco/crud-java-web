package protozoario.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import protozoario.model.Protozoario;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Servlet implementation class buscarProdutoController
 */
public class buscarProtozoarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProtozoarioController() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome = request.getParameter("nome");
		ArrayList<Protozoario> protozoarios = new Protozoario().BuscarProtozoarioPorNome(nome);
		
		request.setAttribute("protozoarios", protozoarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProtozoario.jsp");
		dispatcher.forward(request, response);
		
	}

}
