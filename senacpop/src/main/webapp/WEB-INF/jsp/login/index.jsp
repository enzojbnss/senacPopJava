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
<script type="text/javascript"
	src="<c:url value="js/jquery/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/knockout.js"/>"></script>
<title>Programa de orientação profissional</title>

</head>
<body
	style="background: url('img/Background.png'); background-repeat: no-repeat;">



	<div id="logo" class="container"
		style="text-align: center; margin-top: 35px;">
		<img alt="" src="img/logoSemfundo.png" style="width: 30%;"> <br>
		<label style="color: #ffffff; font-size: 1.7em">Esse quiz
			serve para te ajudar a escolher qual área seguir, de acordo com a sua
			personalidade, ok? Não é um teste vocacional.</label>
	</div>

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
	width: 100%;
	height: 300px;
	margin-left: 0%;
	opacity: 0.55;
}

.jumbotron 	img {
	width: 6%;
}

@media ( max-width : 800px) {
	.jumbotron {
		height: 300px;
	}
	.jumbotron 	img {
		width: 3%;
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
	<script type="text/javascript" src="js/service/AcessoService.js"></script>
	<script type="text/javascript" src="js/app/login/index.js"></script>
	<div class="container" id="tela">
		<div class="jumbotron"
			style="background-color: #FFFFFF; opacity: 0.8; margin-top: 28px; padding-top: 28px;">
			<div class="form-horizontal">
				<h4>
					<label id="txtTitulo">Login</label>
				</h4>
				<div class="form-group">
					<div class="col-sm-3 col-md-3"></div>
					<div class="col-sm-6 col-md-6">
						<input name="txtLogin" type="text" class="form-control"
							id="txtLogin" required="required" size="45" maxlength="70"
							placeholder="Login" data-bind="value: login" />
					</div>
					<div class="col-sm-3 col-md-3"></div>
				</div>
				<div class="form-group">
					<div class="col-sm-3 col-md-3"></div>
					<div class="col-sm-6 col-md-6">
						<input name="txtSenha" type="password" class="form-control"
							id="txtSenha" size="50" maxlength="60" placeholder="Senha"
							data-bind="value: senha" />
					</div>
					<div class="col-sm-3 col-md-3"></div>
				</div>

				<div class="form-group">
					<div class="col-sm-3 col-md-3"></div>
					<div class="col-sm-3 col-md-3">
						<button type="button" name="btnEnviar" id="btnEnviar">Entrar</button>
					</div>
					<div class="col-sm-3 col-md-3">
						<button type="reset" name="btnLimpar" id="btnLimpar">Limpar</button>
					</div>
					<div class="col-sm-3 col-md-3"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
