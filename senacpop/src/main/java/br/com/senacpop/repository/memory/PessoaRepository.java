package br.com.senacpop.repository.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import br.com.senacpop.jdbc.FabricaDeConexao;
import br.com.senacpop.model.Pessoa;
import br.com.senacpop.repository.Interfaces.IPessoaRepositiry;
import br.com.senacpop.utils.TesteExecute;

public class PessoaRepository implements IPessoaRepositiry {

	@Inject
	Pessoa pessoa;

	@Override
	public TesteExecute incluir(Pessoa pessoa, String aceite) {
		// TODO Auto-generated method stub
		String mensagem = "";
		String sql = "";
		Boolean isdata = pessoa.getDataNascimento().equals("nf");
		Boolean status = false;
		if (isdata == true) {
			sql = "INSERT INTO pessoa (nome,sobrenome,email,cpf,celular,telefone,aceite) VALUES (?,?,?,?,?,?,?);";
		} else {
			sql = "INSERT INTO pessoa (nome,sobrenome,email,cpf,celular,telefone,aceite,dataNascimento) VALUES (?,?,?,?,?,?,?,?);";
		}
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getCpf());
			stmt.setString(5, pessoa.getCelular());
			stmt.setString(6, pessoa.getTelefone());
			stmt.setString(7, aceite);
			if (isdata == false) {
				stmt.setString(8, pessoa.getDataNascimento());
			}
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
	public Integer getID(Pessoa pessoa) {
		String sql = "SELECT idpessoa id FROM pessoa where nome = ? and sobrenome  = ? and   email = ? and   cpf = ? and  celular = ?  and   telefone = ? ";
		Integer id = 0;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getCpf());
			stmt.setString(5, pessoa.getCelular());
			stmt.setString(6, pessoa.getTelefone());
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
	public Boolean existe(Pessoa $pessoa) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) valor FROM pessoa where nome = ? and sobrenome  = ? and   email = ? and   cpf = ? and  celular = ?  and   telefone = ? ";
		Boolean status = false;
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getCpf());
			stmt.setString(5, pessoa.getCelular());
			stmt.setString(6, pessoa.getTelefone());
			stmt.setString(7, pessoa.getTelefone());
			if (pessoa.getDataNascimento() != "nf") {
				stmt.setString(8, pessoa.getDataNascimento());
			}
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
