package br.com.senacpop.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.senacpop.model.Area;
import br.com.senacpop.repository.Interfaces.IAreaRepository;

public class AreaDao  {

	@Inject
	private IAreaRepository repository;
	
	
	public List<Area> getListaDiponiveis(Integer idQuestionario) {
		return this.repository.getListaDiponiveis(idQuestionario);
	}

}
