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