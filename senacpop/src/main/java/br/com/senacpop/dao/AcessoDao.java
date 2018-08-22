package br.com.senacpop.dao;

import javax.inject.Inject;

import br.com.senacpop.repository.Interfaces.IAcessoRepository;

public class AcessoDao {

	@Inject
	private IAcessoRepository repository;
	
	public Boolean logar(String login, String senha) {
		return repository.logar(login, senha);
	}

}
