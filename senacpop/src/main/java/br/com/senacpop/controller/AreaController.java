package br.com.senacpop.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.AreaDao;
import br.com.senacpop.infra.session.PessoaSession;
import br.com.senacpop.model.Area;

@Controller
public class AreaController {

	@Inject
	AreaDao dao;
	@Inject
	Result result;
	@Inject
	PessoaSession pessoaSession;

	public void lista(Integer idQuestionario) {
		List<Area> areas = this.dao.getListaDiponiveis(idQuestionario);
		this.pessoaSession.remover();
		this.result.use(Results.json()).withoutRoot().from(areas).serialize();
	}

}
