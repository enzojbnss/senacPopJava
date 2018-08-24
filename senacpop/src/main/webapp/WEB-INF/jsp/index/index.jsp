<%@ include file="/header.jsp"%>
	

		
		
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
<script type="text/javascript" src="js/jquery/jquery.mask.js"></script>
<script type="text/javascript" src="js/service/PessoaService.js"></script>
<script type="text/javascript" src="js/componente/control/CheckBox.js"></script>
<script type="text/javascript" src="js/app/home/index.js"></script>
<div class="container" id="tela">
	<div class="jumbotron"
		style="background-color: #FFFFFF; opacity: 0.8; margin-top: 28px; padding-top: 28px;">
		<div class="form-horizontal">
			<h4>
				<label id="txtTitulo">Cadastro de participante</label>
			</h4>
			<div class="form-group">
				<div class="col-sm-6 col-md-6">
					<input name="txtNome" type="text" class="form-control" id="txtNome"
						required="required" size="45" maxlength="70" placeholder="*Nome"
						data-bind="value: nome" />
				</div>
				<div class="col-sm-6 col-md-6">
					<input name="txtEmail" type="email" class="form-control"
						id="txtEmail" size="50" maxlength="60" placeholder="*Email"
						data-bind="value: email" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6 col-md-6" >
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
				<label for="optTermo" style="font-size: 0.8em;"><input id="optTermo"
					type="checkbox" style="width: 15px; height: 15px; top: 12px;" />Aceito
					receber ofertas de cursos do Senac - SP</label>
			</div>
		</div>
	</div>

</div>

		
		
	
<%@ include file="/footer.jsp"%>