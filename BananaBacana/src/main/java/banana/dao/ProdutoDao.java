package banana.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.MysqlConnection;

import banana.model.Produto;

public class ProdutoDao {

	public void CadastrarProduto(Produto produto) {

		String sql = "INSERT INTO produto VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;

		try {

			conn = new MySqlConnection().getConnection();

			pStatement = conn.prepareStatement(sql);

			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setBoolean(4, produto.isOnline());

			pStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Tentar fechar o pStatement
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			// Tentar fechar a conexao
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public Produto BuscarProdutoPorId(int id) {
		String sql = "SELECT * FROM produto WHERE IdProduto = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Produto produto = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);		
			pStatement.setInt(1, id);			
			rs = pStatement.executeQuery();
			
			if (rs != null && rs.next()) {
				
				produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setOnline(rs.getBoolean("online"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pStatement != null) { pStatement.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conn != null) { conn.close(); }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return produto;
	}
	
	

	public ArrayList<Produto> BuscarProdutosPorDescricao(String descricao) {

		String sql = "SELECT * FROM produto WHERE descricao LIKE '%" + descricao + "%'";

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Produto produto = null;
		ArrayList<Produto> produtos = null;

		try {

			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();

			if (rs != null) {

				produtos = new ArrayList<Produto>();

				while (rs.next()) {

					produto = new Produto();
					produto.setIdProduto(rs.getInt("idProduto"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setPreco(rs.getDouble("preco"));
					produto.setOnline(rs.getBoolean("online"));

					produtos.add(produto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Tentar fechar o pStatement
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			// Tentar fechar a conexao
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return produtos;
	}
	
	
	public void ExcluirProduto(int idProduto) {
		String sql = "DELETE FROM produto WHERE idProduto = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idProduto);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Tentar fechar o pStatement
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			// Tentar fechar a conexao
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void AlterarProduto(Produto produto) {
		
		String sql = "UPDATE produto SET descricao = ?, quantidade = ?, preco = ?, online = ? WHERE idProduto = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setBoolean(4, produto.isOnline());
			pStatement.setInt(5, produto.getIdProduto());
			
			pStatement.execute();		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Tentar fechar o pStatement
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			// Tentar fechar a conexao
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
}
