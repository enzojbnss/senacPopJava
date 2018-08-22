package br.com.senacpop.repository.Interfaces;

import java.util.List;

import br.com.senacpop.model.Resposta;
import br.com.senacpop.utils.TesteExecute;

public interface IRespostaRepository {
	
	public List<Resposta> getListaPerguntas(Integer idPergunta);
	
	public List<Resposta> getListaQuestionario(Integer idQuestionario);
	
	public TesteExecute incluir(Integer idQuestionario, Integer idResposta);
	
	public TesteExecute alterar(Integer idQuestionario, Integer idRespostaQuestionario);
	
	public Integer getIDRespotaQuestionario(Integer idPergunta,Integer idQuestionario);
	
	public Boolean existe(Integer idPergunta,Integer idQuestionario);
	
	public Integer getID(Integer idPergunta,Integer idResposta);

}
