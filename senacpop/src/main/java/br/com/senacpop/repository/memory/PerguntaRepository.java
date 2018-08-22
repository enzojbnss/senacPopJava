package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.model.Pergunta;
import br.com.senacpop.repository.Interfaces.IPerguntaRepository;

public class PerguntaRepository implements IPerguntaRepository {

	@Override
	public List<Pergunta> getLista() {
		// TODO Auto-generated method stub
		String sql = "SELECT idPergunta id, texto, ativo FROM pergunta ;";
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				perguntas.add(new Pergunta(rs.getInt("id"), rs.getString("texto"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return perguntas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return perguntas;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return perguntas;
		}
	}

}
