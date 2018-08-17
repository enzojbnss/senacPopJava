package br.com.senacpop.dao;

import javax.inject.Inject;

import br.com.senacpop.model.Pessoa;
import br.com.senacpop.repository.Interfaces.IPessoaRepositiry;
import br.com.senacpop.utils.TesteExecute;

public class PessoaDao {
	
	@Inject
	private IPessoaRepositiry repository;
	
	public TesteExecute add(Pessoa pessoa) {
		try {
			return repository.add(pessoa);
		} catch (Exception e) {
			return new TesteExecute(e.getMessage(),false);
		}
	}

}
