package br.com.senacpop.repository.Interfaces;

import br.com.senacpop.model.Pessoa;
import br.com.senacpop.utils.TesteExecute;

public interface IPessoaRepositiry {

	
	public TesteExecute incluir(Pessoa pessoa, String aceite);
	
	public Integer getID(Pessoa pessoa);
	
	public Boolean existe(Pessoa pessoa);

}
