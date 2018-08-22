package br.com.senacpop.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.AcessoDao;
import br.com.senacpop.infra.session.LoginSession;

@Controller
public class LoginController {

	@Inject
	private AcessoDao dao;
	@Inject
	private LoginSession loginSession;
	@Inject
	private Result result;
	
	public void index() {

	}
	
	public void logar(String login,String senha) {
        Boolean teste = this.dao.logar(login, senha);
        if(teste)this.loginSession.logar();
        else this.loginSession.deslogar();
        this.result.use(Results.json()).withoutRoot().from(teste).serialize();
	}
}
