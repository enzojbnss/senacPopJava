<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="css/bootstrap.css"/>" rel="stylesheet"
	type="text/css" media="screen" />
<link href="<c:url value="css/bootstrap-theme.css"/>" rel="stylesheet"
	type="text/css" media="screen" />
<link href="<c:url value="css/jquery/jquery-ui.css"/>" rel="stylesheet"
	type="text/css" media="screen" />
<link href="<c:url value="css/jquery/jquery-ui.theme.css"/>"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="css/jquery/jquery-ui.structure.css"/>"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="css/menu.css"/>" rel="stylesheet"
	type="text/css" media="screen" />
<link href="<c:url value="css/pagina.css"/>" rel="stylesheet"
	type="text/css" media="screen" />
<style>
#tela {
	font-family: Verdana Regular;
	position: relative;
	top: 5%;
	background: transparent;
	opacity: 0.55:;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 7px;
}

.jumbotron {
	background: #a7c7dc;
	text-align: center;
	font-size: 1.7em;
	width: 100% 100%;
	height: 300px;
	margin-left: 0%;
	opacity: 0.55;
}

.jumbotron 	img {
	width: 6%;
}

body {
	background: url('img/Background.png');
	background-size: 100% 100%;
	background-repeat: no-repeat;
}

.logo {
	width: 20%;
}

@media ( max-width : 800px) {
	body {
		background: url('img/Background.png');
		background-size: 100% 110%;
		background-repeat: no-repeat;
	}
	.jumbotron {
		height: 300px;
	}
	.jumbotron 	img {
		width: 2%;
	}
	.logo {
		width: 10%;
	}
}

.jumbotron 	img:active {
	position: relative;
	padding: 10px;
}

.jumbotron 	input {
	font-family: Verdana Regular;
}

.pergunta {
	margin-top: 20%;
	font-size: 2em;
}

.form-group {
	margin-bottom: 30px;
	font-family: Verdana Regular;
	font-size: 0.8em
}

.form-horizontal h4 {
	margin-bottom: 30px;
}

.col-md-12 button {
	font-size: 16px;
	text-indent: 2px;
}

.imgchkbox {
	position: relative;
	height: 4%
}

#txtTitulo {
	font-family: Verdana Bold;
	font-weight: lighter;
	font-size: 1.7em;
}

.imgOptBox {
	position: relatiove;
	width: 6%;
}
</style>

<script type="text/javascript"
	src="<c:url value="js/jquery/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/knockout.js"/>"></script>
<script type="text/javascript" src="js/jquery/jquery.mask.js"></script>
<script type="text/javascript" src="js/service/PessoaService.js"></script>
<script type="text/javascript" src="js/componente/control/CheckBox.js"></script>
<script type="text/javascript" src="js/app/home/index.js"></script>
<title>Programa de orientação profissional</title>

</head>
<body>



	<div id="logo" class="container"
		style="text-align: center; margin-top: 35px;">
		<img class="logo" alt="" src="img/logoSemfundo.png" > <br>
		<label style="color: #ffffff; font-size: 1.7em">Esse quiz
			serve para te ajudar a escolher qual área seguir, de acordo com a sua
			personalidade, ok? Não é um teste vocacional.</label>
	</div>




	<div class="container" id="tela">
		<div class="jumbotron"
			style="background-color: #FFFFFF; opacity: 0.8; margin-top: 28px; padding-top: 28px;">
			<div class="form-horizontal">
				<h4>
					<label id="txtTitulo">Cadastro de participante</label>
				</h4>
				<div class="form-group">
					<div class="col-sm-6 col-md-6">
						<input name="txtNome" type="text" class="form-control"
							id="txtNome" required="required" size="45" maxlength="70"
							placeholder="*Nome" data-bind="value: nome" />
					</div>
					<div class="col-sm-6 col-md-6">
						<input name="txtEmail" type="email" class="form-control"
							id="txtEmail" size="50" maxlength="60" placeholder="*Email"
							data-bind="value: email" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6 col-md-6">
						<input name="txtTelefone" type="text" class="form-control"
							id="txtTelefone" size="50" maxlength="60" placeholder="Telefone"
							style="margin-top: 12px;" data-bind="value: email" />
					</div>
					<div class="col-sm-6 col-md-6" style="opacity: 0;">
						<input name="txtCelular" type="text" class="form-control"
							id="txtCelular" size="50" maxlength="60" placeholder="Celular"
							style="margin-top: 12px;" data-bind="value: email" />
					</div>

				</div>
				<div class="form-group">
					<div class="col-sm-6 col-md-6">
						<button type="button" name="btnSalvar" id="btnSalvar">#PartiuComeçar</button>
					</div>
					<div class="col-sm-6 col-md-6">
						<button type="reset" name="btnLimpar" id="btnLimpar">Limpar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="display: none;">
		<div class="form-group">
			<div class="col-md-6">
				<input name="txtSobrenome" type="text" class="form-control"
					id="txtSobrenome" required="required" size="45" maxlength="70"
					placeholder="Sobrenome" data-bind="value: sobrenome" />
			</div>
			<div class="col-sm-4 col-md-3"
				style="font-family: Verdana Regular; font-size: 0.8em; margin-top: 12px; font-weight: normal; margin-left: -50px;">
				Data de nascimento</div>
			<div class="col-sm-4 col-md-3">
				<input title="Data de nascimento" id="txtDataNascimento"
					class="form-control" type="date" data-bind="value: dataNascimento"
					min="1918-12-31" max="2004-12-31" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-12 col-md-6">
				<input name="txtCpf" type="text" class="form-control" id="txtCpf"
					size="50" maxlength="60" placeholder="CPF" data-bind="value: Cpf" />
			</div>
			<div class="col-sm-12 col-md-6">
				<div class="checkbox">
					<label for="optTermo" style="font-size: 0.8em;"><input
						id="optTermo" type="checkbox"
						style="width: 15px; height: 15px; top: 12px;" />Aceito receber
						ofertas de cursos do Senac - SP</label>
				</div>
			</div>
		</div>

	</div>
</body>
</html>