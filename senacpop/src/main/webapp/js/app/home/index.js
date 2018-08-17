var service = "";
var checkBoxGroup = [];
var aceite = "n";
pessoa = new Object();

$(function() {
	$(document).on('click', "#btnSalvar", function() {
		salvar();
	});
	$("#txtCpf").mask("999.999.999-99");
	$("#txtCelular").mask("(99) 99999-9999");
	$("#txtTelefone").mask("(99) 99999-9999");
});


function salvar() {
	pessoa = getPessoa()
	if (validaDados(pessoa)) {
		service = new PessoaService();
		service.incluir("finalizaCadastro")
	}
}

function finalizaCadastro(retorno) {
	if (retorno.status) {
		window.location = "pergunta";
	}
}



function getPessoa() {
	var dataTeste = new String($("#txtDataNascimento").val());
	if ((dataTeste == "")) {
		dataTeste = "nf";
	}
	pessoa.nome = $("#txtNome").val();
	pessoa.sobrenome = $("#txtSobrenome").val();
	pessoa.email = $("#txtEmail").val();
	pessoa.dataNascimento = dataTeste;
	pessoa.cpf = $("#txtCpf").val();
	pessoa.celular = $("#txtCelular").val();
	pessoa.telefone = $("#txtTelefone").val();
	return pessoa;
}

function validaDados(pessoa) {
	var valor = false;
	if (pessoa.nome != "" && validacaoEmail(pessoa.email)) {
		valor = true;
	} else {
		alert("Por favor preencha o nome e e-mail");
	}
	return valor;
}

function validacaoEmail(field) {
	valor = false;
	var field = new String(field);
	usuario = field.substring(0, field.indexOf("@"));
	dominio = field.substring(field.indexOf("@") + 1, field.length);
	if ((usuario.length >= 1) && (dominio.length >= 3)
			&& (usuario.search("@") == -1) && (dominio.search("@") == -1)
			&& (usuario.search(" ") == -1) && (dominio.search(" ") == -1)
			&& (dominio.search(".") != -1) && (dominio.indexOf(".") >= 1)
			&& (dominio.lastIndexOf(".") < dominio.length - 1)) {
		return true;
	}
	if (valor == false) {
		// alert("O campo e-mail é invalido");
	}
}