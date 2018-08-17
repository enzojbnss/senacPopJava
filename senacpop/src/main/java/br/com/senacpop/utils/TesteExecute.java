package br.com.senacpop.utils;

public class TesteExecute {

	private String mensagem;
	private Boolean status;

	public TesteExecute() {
		// TODO Auto-generated constructor stub
	}

	public TesteExecute(String mensagem, Boolean status) {
		this.mensagem = mensagem;
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
