package protozoario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import com.mysql.cj.MysqlConnection;

import protozoario.model.Protozoario;

public class ProtozoarioDao {

	public void CadastrarProtozoario(Protozoario protozoario) {

		String sql = "INSERT INTO protozoario VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;

		try {

			conn = new MySqlConnection().getConnection();

			pStatement = conn.prepareStatement(sql);

			pStatement.setString(1, protozoario.getNome());
			pStatement.setString(2, protozoario.getFilo());
			pStatement.setString(3, protozoario.getClasse());
			pStatement.setString(4, protozoario.getOrdem());

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
	
	public Protozoario BuscarProtozoarioPorId(int id) {
		String sql = "SELECT * FROM protozoario WHERE IdProtozoario = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Protozoario protozoario = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);		
			pStatement.setInt(1, id);			
			rs = pStatement.executeQuery();
			
			if (rs != null && rs.next()) {
				
				protozoario = new Protozoario();
				protozoario.setIdProtozoario(rs.getInt("idProtozoario"));
				protozoario.setNome(rs.getString("nome"));
				protozoario.setFilo(rs.getString("filo"));
				protozoario.setClasse(rs.getString("classe"));
				protozoario.setOrdem(rs.getString("ordem"));
				
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
		
		return protozoario;
	}
	
	

	public ArrayList<Protozoario> BuscarProtozoarioPorNome(String descricao) {

		String sql = "SELECT * FROM protozoario WHERE nome LIKE '%" + descricao + "%'";

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Protozoario protozoario = null;
		ArrayList<Protozoario> protozoarios = null;

		try {

			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();

			if (rs != null) {

				protozoarios = new ArrayList<Protozoario>();

				while (rs.next()) {

					protozoario = new Protozoario();
					protozoario.setIdProtozoario(rs.getInt("idProtozoario"));
					protozoario.setNome(rs.getString("nome"));
					protozoario.setFilo(rs.getString("filo"));
					protozoario.setClasse(rs.getString("classe"));
					protozoario.setOrdem(rs.getString("ordem"));

					protozoarios.add(protozoario);
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

		return protozoarios;
	}
	
	
	public void ExcluirProtozoario(int idProtozoario) {
		String sql = "DELETE FROM protozoario WHERE idProtozoario = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idProtozoario);
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
	
	public void AlterarProtozoario(Protozoario protozoario) {
		
		String sql = "UPDATE protozoario SET nome = ?, filo = ?, classe = ?, ordem = ? WHERE idProtozoario = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, protozoario.getNome());
			pStatement.setString(2, protozoario.getFilo());
			pStatement.setString(3, protozoario.getClasse());
			pStatement.setString(4, protozoario.getOrdem());
			pStatement.setInt(5, protozoario.getIdProtozoario());
			
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
