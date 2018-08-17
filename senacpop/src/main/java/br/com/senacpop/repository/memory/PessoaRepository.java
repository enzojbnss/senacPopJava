package br.com.senacpop.repository.memory;

import javax.inject.Inject;

import br.com.senacpop.model.Pessoa;
import br.com.senacpop.repository.Interfaces.IPessoaRepositiry;
import br.com.senacpop.utils.TesteExecute;

public class PessoaRepository implements IPessoaRepositiry {
	
	
	@Inject
	Pessoa pessoa;

	@Override
	public TesteExecute add(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.pessoa = pessoa;
		return new TesteExecute("Salvo com sucesso!", true);
	}

}
