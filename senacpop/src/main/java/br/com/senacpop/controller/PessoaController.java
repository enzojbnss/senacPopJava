package br.com.senacpop.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.PessoaDao;
import br.com.senacpop.model.Pessoa;
import br.com.senacpop.utils.TesteExecute;


@Controller
public class PessoaController {
	
	@Inject 
	PessoaDao dao;
	@Inject 
	Result result;
	
	
	public void add(Pessoa pessoa) {
		TesteExecute execute = this.dao.add(pessoa);
		this.result.use(Results.json()).withoutRoot().from(execute).serialize();
	}

}
