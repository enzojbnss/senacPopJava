package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.model.Intencao;
import br.com.senacpop.repository.Interfaces.IIntencaoRepository;
import br.com.senacpop.utils.TesteExecute;

public class IntencaoReporitory implements IIntencaoRepository {

	
	public List<Intencao> getListaDiponiveisRelevantes(Integer idQuestionario, Integer idResposta) {
		// TODO Auto-generated method stub
		String sql = "SELECT distinct idIntencao id, texto, ativo,count(idIntencao) peso FROM intencao "
				+ "inner join vwquetionariointencao using(idIntencao) where idresposta = ? and idQuestionario = ? "
				+ "group by idIntencao having peso = (SELECT max(peso) from "
				+ "  (SELECT distinct count(idIntencao) peso FROM intencao "
				+ "		inner join vwquetionariointencao using(idIntencao) "
				+ "		where idresposta = ? and idQuestionario = ? group by idIntencao) pesos); ";
		List<Intencao> intencaos = new ArrayList<Intencao>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idResposta);
			stmt.setInt(2, idQuestionario);
			stmt.setInt(3, idResposta);
			stmt.setInt(4, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				intencaos.add(new Intencao(rs.getInt("id"), rs.getString("texto"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return intencaos;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return intencaos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return intencaos;
		}
	}

	
	public List<Intencao> getListaDiponiveis(Integer idQuestionario, Integer idResposta) {
		// TODO Auto-generated method stub
		String sql = "SELECT distinct idIntencao id, texto, ativo,count(idIntencao) peso FROM intencao "
				+ "inner join vwquetionariointencao using(idIntencao) where idresposta = ? and idQuestionario = ? "
				+ "group by idIntencao having peso = (SELECT max(peso) from "
				+ "  (SELECT distinct count(idIntencao) peso FROM intencao "
				+ "		inner join vwquetionariointencao using(idIntencao) "
				+ "		where idresposta = ? and idQuestionario = ?  group by idIntencao) pesos); ";
		List<Intencao> intencaos = new ArrayList<Intencao>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idResposta);
			stmt.setInt(2, idQuestionario);
			stmt.setInt(3, idResposta);
			stmt.setInt(4, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				intencaos.add(new Intencao(rs.getInt("id"), rs.getString("texto"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return intencaos;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return intencaos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return intencaos;
		}
	}

	
	public Integer getPeso(Integer idQuestionario, Integer idResposta) {
		String sql = " SELECT max(peso) peso from  (SELECT distinct count(idIntencao) peso FROM intencao "
				+ "		inner join vwquetionariointencao using(idIntencao) "
				+ "		where idresposta = ? and idQuestionario = ? group by idIntencao) pesos; ";
		Integer id = 0;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idResposta);
			stmt.setInt(2, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("peso");
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

	
	public TesteExecute incluir(Integer idQuestionario, Integer idResposta, Integer peso) {
		String mensagem = "";
		String sql = "INSERT INTO `questionariointencao` (`idQuestionario`,`idIntencao`,peso) VALUES (?,?,?);";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idQuestionario);
			stmt.setInt(2, idResposta);
			stmt.setInt(3, peso);
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

	
	public TesteExecute incluirAutomaticamente(Integer idQuestionario, Integer idResposta) {
		String mensagem = "";
		String sql = "INSERT INTO `questionariointencao` (`idQuestionario`,`idIntencao`,`peso`) "
				+ "SELECT DISTINCT idQuestionario,idIntencao,count(idIntencao) peso FROM intencao "
				+ "INNER JOIN vwquetionariointencao using(idIntencao) "
				+ "WHERE idresposta = ? AND idQuestionario = ? GROUP BY idIntencao; ";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idResposta);
			stmt.setInt(2, idQuestionario);
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

}
