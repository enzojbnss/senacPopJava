package br.com.senacpop.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.senacpop.model.Intencao;
import br.com.senacpop.repository.Interfaces.IIntencaoRepository;
import br.com.senacpop.utils.TesteExecute;

public class IntencaoDao {
	
	@Inject
	private IIntencaoRepository repository;

	
	public List<Intencao> getListaDiponiveisRelevantes(Integer idQuestionario, Integer idResposta) {
		return this.repository.getListaDiponiveisRelevantes(idQuestionario, idResposta);
	}

	
	public List<Intencao> getListaDiponiveis(Integer idQuestionario, Integer idResposta) {
		return this.repository.getListaDiponiveis(idQuestionario, idResposta);
	}

	
	public Integer getPeso(Integer idQuestionario, Integer idResposta) {
		return this.repository.getPeso(idQuestionario, idResposta);
	}

	
	public TesteExecute incluir(Integer idQuestionario, Integer idResposta, Integer peso) {
		return this.repository.incluir(idQuestionario, idResposta, peso);
	}

	
	public TesteExecute incluirAutomaticamente(Integer idQuestionario, Integer idResposta) {
		return this.repository.incluirAutomaticamente(idQuestionario, idResposta);
	}

}
