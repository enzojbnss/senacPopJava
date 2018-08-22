package br.com.senacpop.dao;

import javax.inject.Inject;

import br.com.senacpop.repository.Interfaces.IQuestionarioRepository;
import br.com.senacpop.utils.TesteExecute;

public class QuestionarioDao  {
	
	@Inject
	private IQuestionarioRepository repository;

	public TesteExecute incluir(Integer idPessoa) {
		return this.repository.incluir(idPessoa);
	}

	public TesteExecute inativaAnteriores(Integer idPessoa) {
		return this.inativaAnteriores(idPessoa) ;
	}

	public Integer getID(Integer idPessoa) {
		return this.repository.getID(idPessoa);
	}

}
