var service = "";
var login = "";
var senha = "";

$(function() {
	$(document).on('click', "#btnEnviar", function() {
		logar();
	});
});


function logar() {
	login = $("#txtLogin").val();
	senha = $("#txtSenha").val();
	if (validaDados(login,senha)) {
		service = new AcessoService();
		service.logar("finalizaLogin")
	}
}

function finalizaLogin(retorno) {
	if (retorno) {
		window.location = "";
	}
}


function validaDados(login,senha) {
	var valor = false;
	if (login != "" && login != "") {
		valor = true;
	} else {
		alert("Login e senha não podem estar em branco!");
	}
	return valor;
}

