package br.com.senacpop.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.senacpop.model.Resposta;
import br.com.senacpop.repository.Interfaces.IRespostaRepository;
import br.com.senacpop.utils.TesteExecute;

public class RespostaDao {

	@Inject
	private IRespostaRepository repository;

	public List<Resposta> getListaPerguntas(Integer idPergunta) {
		return this.repository.getListaPerguntas(idPergunta);
	}

	public List<Resposta> getListaQuestionario(Integer idQuestionario) {
		return this.repository.getListaQuestionario(idQuestionario);
	}

	public TesteExecute incluir(Integer idQuestionario, Integer idResposta) {
		return this.repository.incluir(idQuestionario, idResposta);
	}

	public TesteExecute alterar(Integer idQuestionario, Integer idRespostaQuestionario) {
		return this.repository.alterar(idQuestionario, idRespostaQuestionario);
	}

	public Integer getIDRespotaQuestionario(Integer idPergunta, Integer idQuestionario) {
		return this.repository.getIDRespotaQuestionario(idPergunta, idQuestionario);
	}

	public Boolean existe(Integer idPergunta, Integer idQuestionario) {
		return this.repository.existe(idPergunta, idQuestionario);
	}

	public Integer getID(Integer idPergunta, Integer idResposta) {
		return this.repository.getID(idPergunta, idResposta);
	}

}
