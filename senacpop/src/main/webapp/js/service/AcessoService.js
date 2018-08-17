var AcessoService = function(){
	
	this.logar = function(funcao) {
		var caminho = "login/logar"
		var dados = {
				"login" : login,
				"senha" : senha
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