var AreaService = function(){
	
	this.getLista = function(funcao) {
		var caminho = "area/lista"
		var dados = {
				"idQuestionario" : idQuestionario
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
		}).done(function (retorno) {
			eval(funcao + "(retorno)");
		})
	}
}