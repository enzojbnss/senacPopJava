/**
 * http://usejsdoc.org/
 */
var PerguntaService = function() {

	this.getLista = function(funcao) {
		var caminho = "lista"
		this.enviar(caminho, {}, funcao);
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