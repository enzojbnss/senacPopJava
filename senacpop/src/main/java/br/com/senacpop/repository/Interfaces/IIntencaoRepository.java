package br.com.senacpop.repository.Interfaces;

import java.util.List;

import br.com.senacpop.model.Intencao;
import br.com.senacpop.utils.TesteExecute;

public interface IIntencaoRepository {
	
	public List<Intencao> getListaDiponiveisRelevantes(Integer idQuestionario, Integer idResposta);
	
	public List<Intencao> getListaDiponiveis(Integer idQuestionario, Integer idResposta);
	
	public Integer getPeso(Integer idQuestionario, Integer idResposta);
	
	public TesteExecute incluir(Integer idQuestionario, Integer idResposta, Integer peso);
	
	public TesteExecute incluirAutomaticamente(Integer idQuestionario, Integer idResposta);

}
