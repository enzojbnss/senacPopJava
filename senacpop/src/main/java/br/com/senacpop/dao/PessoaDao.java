package br.com.senacpop.dao;

import javax.inject.Inject;

import br.com.senacpop.model.Pessoa;
import br.com.senacpop.repository.Interfaces.IPessoaRepositiry;
import br.com.senacpop.utils.TesteExecute;

public class PessoaDao {

	@Inject
	private IPessoaRepositiry repository;

	public TesteExecute incluir(Pessoa pessoa, String aceite) {
		return this.repository.incluir(pessoa, aceite);
	}

	public Integer getID(Pessoa pessoa) {
		return this.repository.getID(pessoa);
	}

	public Boolean existe(Pessoa pessoa) {
		return this.repository.existe(pessoa);
	}

}
