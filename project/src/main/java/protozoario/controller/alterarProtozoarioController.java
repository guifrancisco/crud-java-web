package protozoario.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import protozoario.model.Protozoario;

@WebServlet("/alterarProtozoario")
public class alterarProtozoarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarProtozoarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("Passei Pelo post");
		String nome = request.getParameter("nome");
		String filo = request.getParameter("filo");
		String classe = request.getParameter("classe");
		String ordem = request.getParameter("ordem");
		//String descricao = request.getParameter("descricao");
		String id = request.getParameter("id");
		String mensagem;
		
		System.out.println("esse é o:"+id);
		
		if (nome != null && !nome.isEmpty() && filo != null
				&& !filo.isEmpty() && classe != null
				&& !classe.isEmpty()&& ordem != null
				&& !ordem.isEmpty()) {
//			int quantidade;
//			double preco;
//			quantidade = Integer.parseInt(request.getParameter("quantidade"));
//			preco = Double.parseDouble(request.getParameter("preco"));
//			boolean online = false;
//			if (request.getParameter("online") != null && request.getParameter("online").equals("true"))
//				online = true;
			Protozoario protozoario = new Protozoario(nome, filo, classe, ordem);
			protozoario.setIdProtozoario(Integer.valueOf(id));
			protozoario.alterar();
			mensagem = "Protozoario alterado com sucesso!";
		} else
			mensagem = "Os campos precisam ser preenchidos!";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProtozoario.jsp");
		request.setAttribute("mensagem", mensagem);
		dispatcher.forward(request, response);
		
		
		
		
	}

}