package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.repository.Interfaces.IQuestionarioRepository;
import br.com.senacpop.utils.TesteExecute;

public class QuestionarioRepository implements IQuestionarioRepository {

	@Override
	public TesteExecute incluir(Integer idPessoa) {
		// TODO Auto-generated method stub
		String mensagem = "";
		String sql = "INSERT INTO questionario (`idPessoa`) VALUES (?);";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPessoa);
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
	public TesteExecute inativaAnteriores(Integer idPessoa) {
		// TODO Auto-generated method stub
		String mensagem = "";
		String sql = "UPDATE questionario  SET `ativo` = 'n' WHERE `idPessoa` = ? ;";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPessoa);
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
	public Integer getID(Integer idPessoa) {
		// TODO Auto-generated method stub
		String sql = "SELECT idQuestionario id FROM questionario where ativo = 's' and `idPessoa` = ?; ";
		Integer id = 0;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idPessoa);
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
