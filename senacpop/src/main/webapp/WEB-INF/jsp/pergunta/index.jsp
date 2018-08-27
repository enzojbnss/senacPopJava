<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/bootstrap-theme.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/jquery/jquery-ui.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="../css/jquery/jquery-ui.theme.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="../css/jquery/jquery-ui.structure.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="../css/menu.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="../css/pagina.css" rel="stylesheet" type="text/css"
	media="screen" />

<style>
#tela {
	font-family: Verdana Regular;
	position: relative;
	top: 5%;;
	background: transparent;
	opacity: 0.55:;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 7px;
}

.jumbotron {
	font-family: Verdana Regular;
	background: #a7c7dc;
	text-align: center;
	font-size: 1em;
	width: 100%;
	height: 500px;
	background-color: #FFFFFF;
	opacity: 0.65;
	margin-top: 35px;
	padding-top: 35px;
}

.jumbotron 	img {
	width: 50%
}

.jumbotron 	img:active {
	position: relative;
	padding: 10px;
}

.jumbotron 	table {
	width: 80%;
	text-align: center;
	margin-left: 10%;
	margin-right: 10%;
}

.pergunta {
	margin-top: 10%;
	font-size: 2em;
}

.pergunta input {
	font-weight: bolder;
	font-stretch: ultra-expanded;
	font-size: 1.5em;
}

@media ( max-width : 800px) {
	.jumbotron 	img {
		width: 15%;
	}
}
</style>
<script type="text/javascript" src="../js/jquery/jquery.js"></script>
<script type="text/javascript" src="../js/knockout.js"></script>
<script type="text/javascript" src="../js/service/PessoaService.js"></script>
<script type="text/javascript" src="../js/service/PerguntaService.js"></script>
<script type="text/javascript"
	src="../js/service/QuestionarioService.js"></script>
<script type="text/javascript" src="../js/service/RespostaService.js"></script>
<script type="text/javascript" src="../js/service/AreaService.js"></script>
<script type="text/javascript" src="../js/app/pergunta/index.js"></script>
<title>Programa de orientação profissional</title>
</head>
<body
	style="background: url('../img/Background.png'); background-repeat: no-repeat; background-size: 165%">
	<div id="logo" class="container"
		style="text-align: center; margin-top: 35px;">
		<img alt="" src="../img/logoSemfundo.png" style="width: 30%;"> <br>
		<label style="color: #ffffff; font-size: 1.7em">Esse quiz
			serve para te ajudar a escolher qual área seguir, de acordo com a sua
			personalidade, ok? Não é um teste vocacional.</label>
	</div>
	<div class="container" id="tela">
		<div id="dvPerguntas" class="jumbotron">
			<div></div>
			<div class="pergunta">
				<div class="col-md-3" style="margin-left: 0px">
					<img id="btnPositivo" alt="" src="../img/positivo.png" />
				</div>
				<div class="col-md-6">
					<label id="txtPergunta"></label>
				</div>
				<div class="col-md-3">
					<img id="btnNegativo" alt="" src="../img/negativo.png" />
				</div>
				<br>
				<div class="form-group">
					<div class="col-md-12">
						<button type="button" name="btnVoltar" id="btnVoltarQuestao">Voltar</button>
					</div>
				</div>
			</div>
		</div>
		<div id="dvAreas" class="jumbotron">
			<div>VocÃª se enquadra no seguinte perfil:</div>
			<div class="pergunta">
				<table data-bind="foreach: areas">
					<tr>
						<td><input type="text" style="font-weight: bolder;"
							data-bind="value: descricao" readonly="readonly" /></td>
					</tr>
				</table>
				<br>
				<div class="form-group">
					<div class="col-md-12">
						<button type="button" name="btnVoltar" id="btnVoltar">Voltar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
