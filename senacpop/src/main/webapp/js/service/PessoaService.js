var PessoaService = function() {

	this.incluir = function(funcao) {
		var caminho = "pessoa/add";
		var dados = {
			"id" : 0,
			"nome" : pessoa.nome,
			"sobrenome" : pessoa.sobrenome,
			"email" : pessoa.email,
			"dataNascimento" : pessoa.dataNascimento,
			"cpf" : pessoa.cpf,
			"celular" : pessoa.celular,
			"telefone" : pessoa.telefone,
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