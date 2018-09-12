var QuestionarioService = function() {

	this.add = function(funcao) {
		var caminho = "../questionario/add";
		var dados = {
			"idPessoa" : idPessoa
		}
		this.enviar(caminho, dados, funcao);
	}

	this.encerraQuestionario = function(funcao) {
		var caminho = "../questionario/encerraQuestionario";
		var dados = {
			"idQuestionario" : idQuestionario,
			"autoIntencao" : 1,
			"idResposta" : 1
		}
		this.enviar(caminho, dados, funcao);
	}
	
	this.geraQuestionario = function(funcao) {
		var resposta = [];
		resposta[0] = 1;
		resposta[1] = 2;
		resposta[3] = 1;
		resposta[4] = 2;
		resposta[5] = 2;
		var caminho = "../questionario/geraQuestionario";
		var dados = {
			"respostas" : resposta
		}
		this.enviar(caminho, dados, funcao);
	}
	

	this.getID = function(funcao) {
		var caminho = "../questionario/getID";
		var dados = {
			"idPessoa" : idPessoa
		}
		this.enviar(caminho, dados, funcao);
	}

	this.enviar = function(caminho, dados, funcao) {
		$.ajax({
			method : 'POST',
			url : caminho,
			xhrFields : {
				withCredentials : true
			},
			data : dados
		}).done(function(retorno) {
			eval(funcao + "(retorno)");
		})
	}

}