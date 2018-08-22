package br.com.senacpop.repository.Interfaces;

import java.util.List;

import br.com.senacpop.model.Area;

public interface IAreaRepository {
	
	public List<Area> getListaDiponiveis(Integer idQuestionario);

}
