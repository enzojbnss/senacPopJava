package br.com.senacpop.controller;


import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.IntencaoDao;
import br.com.senacpop.dao.QuestionarioDao;
import br.com.senacpop.dao.RespostaDao;
import br.com.senacpop.utils.TesteExecute;

@Controller
public class QuestionarioController {

	@Inject
	private QuestionarioDao dao;
	
	@Inject
	private RespostaDao respotaDao;

	@Inject
	private IntencaoDao intencaoDao;

	@Inject
	private Result result;

	
	public void add(Integer idPessoa) {
		TesteExecute execute = this.dao.inativaAnteriores(idPessoa);
		if (execute.getStatus()) {
			execute = this.dao.incluir(idPessoa);
		}
		this.result.use(Results.json()).withoutRoot().from(execute).serialize();
	}

	public void getID(Integer idPessoa) {
		Integer id = this.dao.getID(idPessoa);
		this.result.use(Results.json()).withoutRoot().from(id).serialize();
	}

	public void encerraQuestionario(Integer idQuestionario, Integer autoIntencao, Integer idResposta) {
		TesteExecute execute;
		if (autoIntencao > 0) {
			execute = intencaoDao.incluirAutomaticamente(idQuestionario, idResposta);
		} else {
			execute = new TesteExecute("Encerrado Con sucesso!", true);
		}
		this.result.use(Results.json()).withoutRoot().from(execute).serialize();
	}
	
	public void geraQuestionario(Integer idPessoa,List<Integer>  respostas) {
		TesteExecute execute = this.dao.inativaAnteriores(idPessoa);
		if (execute.getStatus()) {
			execute = this.dao.incluir(idPessoa);
			if(execute.getStatus()) {
				Integer idQuestionario = this.dao.getID(idPessoa);
				Integer index = 0;
				Integer idResposta = 0;
				for (Integer valor : respostas) {
					idResposta = this.respotaDao.getID((index + 1), valor);
					execute = this.respotaDao.incluir(idQuestionario, idResposta);
				}
				execute = intencaoDao.incluirAutomaticamente(idQuestionario, idResposta);
			}
		}
		this.result.use(Results.json()).withoutRoot().from(execute).serialize();
	}
}
