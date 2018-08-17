var RespostaService = function() {

	this.getID = function(funcao) {
		var caminho = "resposta/getID";
		var dados = {
			"idPergunta" : perguntas[perguntaAtual].id,
			"idResposta" : valorResposta
		}
		this.enviar(caminho, dados, funcao);
	}

	this.add = function(funcao) {
		var caminho = "resposta/add";
		var dados = {
			"idPergunta" : perguntas[perguntaAtual].id,
			"idQuestionario" : idQuestionario,
			"idResposta" : idResposta
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