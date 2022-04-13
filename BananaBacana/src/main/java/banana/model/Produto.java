package banana.model;

import java.util.ArrayList;

import banana.dao.ProdutoDao;

public class Produto {

	private int idProduto;
	private String descricao;
	private int quantidade;
	private double preco;
	private boolean online;

	public Produto() {

	}

	public Produto(int idProduto, String descricao, int quantidade, double preco, boolean online) {

		this.idProduto = idProduto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.online = online;

	}

	public Produto(String descricao, int quantidade, double preco, boolean online) {

		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.online = online;
	}

	public int getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
	//Atraves da model é enviado as classes DAO o trabalho de salvar no banco
	public void salvar() {
		new ProdutoDao().CadastrarProduto(this);
	}
	
	
	public Produto buscarProdutoPorId(int idProduto) {
		return new ProdutoDao().BuscarProdutoPorId(idProduto);
	}
	
	public ArrayList<Produto> BuscarProdutosPorDescricao (String descricao) {
		return new ProdutoDao().BuscarProdutosPorDescricao(descricao);
	}
	
	public void excluir(int idProduto) {
		new ProdutoDao().ExcluirProduto(idProduto);
	}

}
