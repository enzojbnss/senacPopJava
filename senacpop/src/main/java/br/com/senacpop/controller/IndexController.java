package br.com.senacpop.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.senacpop.infra.session.LoginSession;
import br.com.senacpop.infra.session.PessoaSession;

@Controller
public class IndexController {

	@Inject
	private PessoaSession pessoaSession;
	@Inject
	private LoginSession loginSession;
	@Inject
	private Result result;

	@Path("/")
	public void index() {
		if (loginSession.isLogado()) {
			if (this.pessoaSession.isRegitred()) {
				this.pessoaSession.remover();
			}
		}else {
			this.result.forwardTo(LoginController.class).index();
		}
	}

}
