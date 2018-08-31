package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.model.Resposta;
import br.com.senacpop.repository.Interfaces.IRespostaRepository;
import br.com.senacpop.utils.TesteExecute;

public class RespostaRepository implements IRespostaRepository {

	@Override
	public List<Resposta> getListaPerguntas(Integer idPergunta) {
		String sql = "SELECT id, texto, ativo  FROM vwrespostapergunta where idPergunta = ?; ";
		List<Resposta> respostas = new ArrayList<Resposta>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPergunta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				respostas.add(new Resposta(rs.getInt("id"), rs.getString("texto"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return respostas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	@Override
	public List<Resposta> getListaQuestionario(Integer idQuestionario) {
		String sql = "SELECT id, texto, ativo  FROM vwrespostaquestionario where idQuestionario = ?";
		List<Resposta> respostas = new ArrayList<Resposta>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				respostas.add(new Resposta(rs.getInt("id"), rs.getString("texto"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return respostas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	
	public TesteExecute incluir(Integer idQuestionario, Integer idResposta) {
		// TODO Auto-generated method stub
		String mensagem = "";
		String sql = "INSERT INTO `respotaquestionario` (`idQuestionario`,`idPerguntaRespota`) VALUES (?,?)";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,idQuestionario );
			stmt.setInt(2,idResposta );
			stmt.execute();
			status = true;
			mensagem = "cadastro gravado com sucesso!";
			stmt.close();
			connection.close();
			connection = null;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			mensagem = "falha ao gravar o cadastro! : " + e.getMessage();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			mensagem = "falha ao gravar o cadastro! : " + e.getMessage();
		}
        return new TesteExecute(mensagem, status);
	}

	@Override
	public TesteExecute alterar(Integer idQuestionario, Integer idRespostaQuestionario) {
		// TODO Auto-generated method stub
		String mensagem = "";
		String sql = "UPDATE respotaquestionario SET idPerguntaRespota = ? WHERE idrespotaquestionario = ?;";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,idQuestionario );
			stmt.setInt(2,idRespostaQuestionario );
			stmt.execute();
			status = true;
			mensagem = "cadastro gravado com sucesso!";
			stmt.close();
			connection.close();
			connection = null;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			mensagem = "falha ao gravar o cadastro! : " + e.getMessage();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			mensagem = "falha ao gravar o cadastro! : " + e.getMessage();
		}
        return new TesteExecute(mensagem, status);
	}

	@Override
	public Integer getIDRespotaQuestionario(Integer idPergunta, Integer idQuestionario) {
		// TODO Auto-generated method stub
		String sql = "SELECT idrespotaquestionario id FROM testevocacional.respotaquestionario "
		+ "INNER JOIN perguntarespota USING(idPerguntaRespota) "
		+ "WHERE idPergunta = ? AND idQuestionario = ?; ";
		Integer id = 0;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,idPergunta );
			stmt.setInt(2,idQuestionario );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return id;
		}
	}

	@Override
	public Boolean existe(Integer idPergunta, Integer idQuestionario) {
		// TODO Auto-generated method stub
		String sql = "SELECT Count(idrespotaquestionario) valor FROM testevocacional.respotaquestionario "
		+ "INNER JOIN perguntarespota USING(idPerguntaRespota) "
		+ "WHERE idPergunta = ? AND idQuestionario = ?; ";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPergunta);
			stmt.setInt(2, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				status = (rs.getInt("valor") > 0);
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return status;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return status;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return status;
		}
	}

	@Override
	public Integer getID(Integer idPergunta, Integer idResposta) {
		// TODO Auto-generated method stub
		String sql = "SELECT idPerguntaRespota idr FROM perguntarespota where idPergunta = ? and idResposta = ?  ";
		Integer id = 0;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,idPergunta );
			stmt.setInt(2,idPergunta );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return id;
		}
	}

}
