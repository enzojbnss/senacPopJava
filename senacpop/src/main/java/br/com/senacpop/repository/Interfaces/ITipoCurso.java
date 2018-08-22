package br.com.senacpop.repository.Interfaces;

import java.util.List;

import br.com.senacpop.model.TipoCurso;

public interface ITipoCurso {
	
	public List<TipoCurso> getListaDiponiveis(Integer idQuestionario);

}
