package br.com.senacpop.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.senacpop.model.Pergunta;
import br.com.senacpop.repository.Interfaces.IPerguntaRepository;

public class PerguntaDao {

	@Inject
	IPerguntaRepository repository;

	public List<Pergunta> getLista() {
		return repository.getLista();
	}

}
