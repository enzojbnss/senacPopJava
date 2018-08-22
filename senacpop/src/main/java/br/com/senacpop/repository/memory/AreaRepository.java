package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.model.Area;
import br.com.senacpop.repository.Interfaces.IAreaRepository;

public class AreaRepository implements IAreaRepository {

	@Override
	public List<Area> getListaDiponiveis(Integer idQuestionario) {
		String sql = "SELECT distinct idArea id, descricao, ativo  FROM area "
				+ "INNER JOIN intencaoarea USING(idArea) INNER JOIN questionariointencao USING(idIntencao) "
				+ "WHERE (questionariointencao.peso = "
				+ "(SELECT MAX(peso) FROM questionariointencao where idQuestionario = ? )) "
				+ "AND idQuestionario = ? order by questionariointencao.peso desc;";
		List<Area> areas = new ArrayList<Area>();
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idQuestionario);
			stmt.setInt(2, idQuestionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				areas.add(new Area(rs.getInt("id"), rs.getString("descricao"), rs.getString("ativo")));
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return areas;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

}
