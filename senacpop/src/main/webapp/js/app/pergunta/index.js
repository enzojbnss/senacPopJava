var idPessoa = 0;
var service = "";
var perguntas = [];
var respostas = [];
var perguntaAtual = 0;
var idQuestionario = 0;
var idResposta = 0;
var valorResposta = 0;
$(function() {
	$("#dvAreas").hide();
	getIdAtual();
	service = new PerguntaService();
	service.getLista("carregaPerguntas");
	service = null;
	$(document).on('click', "#btnPositivo", function() {
		responder(true);
	});
	$(document).on('click', "#btnNegativo", function() {
		responder(false);
	});
	$(document).on('click', "#btnVoltar", function() {
		voltar();
	});
	$(document).on('click', "#btnVoltarQuestao", function() {
		voltarPergunta();
	});

	areaViewModel = new AreaListViewModel();
	ko.applyBindings(areaViewModel);
});

function voltar() {
	window.location = "../";
}

function getIdAtual() {
	var pessoaService = new PessoaService();
	pessoaService.getIdAtual("retornaID")
}

function retornaID(id) {
	idPessoa = id;
}

function voltarPergunta() {
	perguntaAtual--;
	exibiPergunta();
}

function carregaPerguntas(retorno) {
	perguntas = retorno;
	exibiPergunta();
}

function responder(valor) {
	idQuestionario
	if (valor) {
		valorResposta = 1;
	} else {
		valorResposta = 2;
	}
	respostas[perguntaAtual] = valorResposta
}

function gerarQuestionario() {
	service = new QuestionarioService();
	service.add("finalizaGeracao");
}

function finalizaGeracao(retorno) {
	if (retorno.status) {
		service.getID("defineIDQuestionario");
	}
}





function exibiPergunta() {
	$("#txtPergunta").text(perguntas[perguntaAtual].texto);
	if (perguntaAtual == 0) {
		$("#btnVoltarQuestao").css("opacity", 0);
	} else {
		$("#btnVoltarQuestao").css("opacity", 1);
	}
	if (perguntaAtual == (perguntas.length - 1)) {
		$("#btnPositivo").css("opacity", 0);
		$("#btnNegativo").css("opacity", 0);
		$("#txtPergunta").css("opacity", 0);
		service = new QuestionarioService();
		service.encerraQuestionario("finalizaQuestionario");
	}
}

function finalizaQuestionario(retorno) {
	if (retorno.status) {
		service = new AreaService();
		service.getLista("carregarAreas");
	} else {
	}
}

function carregarAreas(retorno) {
	contador = 0;
	$.each(retorno, function(index, area) {
		if (contador <= 1) {
			areaViewModel.addTask(area);
			contador++;
		}
	});
	$("#dvPerguntas").hide();
	$("#dvAreas").show();
}

function Area(data) {
	this.id = ko.observable(data.id);
	this.descricao = ko.observable(data.descricao);
	this.ativo = ko.observable(data.ativo);
}

function AreaListViewModel() {
	this.areas = ko.observableArray([]);

	this.addTask = function(area) {
		this.areas.push(new Area({
			id : area.id,
			descricao : area.descricao,
			ativo : area.ativo
		}));
	};
}


function teste(){
	service = new QuestionarioService();
	service.geraQuestionario("fteste");
}

function fteste(retorno){
	alert(retorno);
}

