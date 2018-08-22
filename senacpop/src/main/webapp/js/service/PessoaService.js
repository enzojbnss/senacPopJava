var PessoaService = function() {

	this.incluir = function(funcao) {
		var caminho = "pessoa/add";
		var dados = {
			"pessoa.id" : 0,
			"pessoa.nome" : pessoa.nome,
			"pessoa.sobrenome" : pessoa.sobrenome,
			"pessoa.email" : pessoa.email,
			"pessoa.dataNascimento" : pessoa.dataNascimento,
			"pessoa.cpf" : pessoa.cpf,
			"pessoa.celular" : pessoa.celular,
			"pessoa.telefone" : pessoa.telefone,
			"aceite" : aceite
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