package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.repository.Interfaces.IAcessoRepository;

public class AcessoRepository implements IAcessoRepository {

	@Override
	public Boolean logar(String login, String senha) {
		String sql = "SELECT  count(distinct login ) valor FROM vwacesso "
		         + "WHERE login = ? AND senha = ?; ";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
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

}
