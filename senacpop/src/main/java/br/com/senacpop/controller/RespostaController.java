package br.com.senacpop.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.senacpop.dao.RespostaDao;
import br.com.senacpop.utils.TesteExecute;

public class RespostaController {
	
	@Inject
	private RespostaDao dao;
	@Inject
	private Result result;
	
    public void add(Integer idPergunta,Integer idQuestionario,Integer idResposta) {
    	TesteExecute execute;
    	Boolean existe = this.dao.existe(idPergunta, idQuestionario);
    	if(existe) {
    		Integer idRespostaQuestionario = this.dao.getIDRespotaQuestionario(idPergunta, idQuestionario);
    		execute = this.dao.alterar(idQuestionario, idRespostaQuestionario);
    	}else {
    		execute = this.dao.incluir(idQuestionario, idResposta);
    	}
    	this.result.use(Results.json()).withoutRoot().from(execute).serialize();
    }
    
    public void getId(Integer idPergunta,Integer idResposta) {
    	Integer id = this.dao.getID(idPergunta, idResposta);
    	this.result.use(Results.json()).withoutRoot().from(id).serialize();
    }
}
