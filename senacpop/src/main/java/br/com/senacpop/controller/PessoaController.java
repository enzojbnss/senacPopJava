package br.com.senacpop.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.PessoaDao;
import br.com.senacpop.infra.session.PessoaSession;
import br.com.senacpop.model.Pessoa;
import br.com.senacpop.utils.TesteExecute;

@Controller
public class PessoaController {

	@Inject
	PessoaDao dao;
	@Inject
	Result result;
	@Inject
	PessoaSession pessoaSession;

	public void add(Pessoa pessoa, String aceite) {
		TesteExecute execute;
		if (dao.existe(pessoa) != true) {
			execute = this.dao.incluir(pessoa, aceite);
		} else {
			execute = new TesteExecute("Cadastrado com Sucesso", true);
		}
		if (execute.getStatus()) {
			this.pessoaSession.registrar(pessoa);
		}
		this.result.use(Results.json()).withoutRoot().from(execute).serialize();
	}

	public void getIdAtual() {
		if (this.pessoaSession.isRegitred())
			this.result.use(Results.json()).withoutRoot().from(this.pessoaSession.getPessoa()).serialize();
		else
			this.result.use(Results.json()).withoutRoot().from(0).serialize();
	}

}
