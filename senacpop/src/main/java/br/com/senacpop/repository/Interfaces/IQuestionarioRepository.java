package br.com.senacpop.repository.Interfaces;

import br.com.senacpop.utils.TesteExecute;

public interface IQuestionarioRepository {
	
	public TesteExecute incluir(Integer idPessoa);
	
	public TesteExecute inativaAnteriores(Integer idPessoa);
	
	public Integer getID(Integer idPessoa);

}
