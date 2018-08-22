package br.com.senacpop.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.PerguntaDao;
import br.com.senacpop.infra.session.LoginSession;
import br.com.senacpop.infra.session.PessoaSession;
import br.com.senacpop.model.Pergunta;

@Controller
public class PerguntaController {
	
	@Inject
	private PerguntaDao dao;
	
	@Inject 
	private PessoaSession pessoaSession;
	
	@Inject 
	private LoginSession loginSession;
	
	@Inject
	private Result result;
	
	public void index() {
		if(this.loginSession.isLogado()) {
			if(this.pessoaSession.isRegitred()) {
				
			}else {
				this.result.forwardTo(IndexController.class).index();
			}
		}else {
			this.result.forwardTo(LoginController.class).index();
		}
	}
	
	
	public void lista() {
		List<Pergunta> perguntas = this.dao.getLista();
		this.result.use(Results.json()).withoutRoot().from(perguntas).serialize();
	}
	
	

}
