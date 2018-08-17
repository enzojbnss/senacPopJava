package br.com.senacpop.model;

public class Pergunta {

	private Integer id;
	private String texto;
	private String ativo;
	private Resposta respostas;

	public Pergunta() {
		// TODO Auto-generated constructor stub
	}

	public Pergunta(Integer id, String texto) {
		this.id = id;
		this.texto = texto;
	}

	public Pergunta(Integer id, String texto, String ativo) {
		this.id = id;
		this.texto = texto;
		this.ativo = ativo;
	}

	public Pergunta(Integer id, String texto, String ativo, Resposta respostas) {
		this.id = id;
		this.texto = texto;
		this.ativo = ativo;
		this.respostas = respostas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Resposta getRespostas() {
		return respostas;
	}

	public void setRespostas(Resposta respostas) {
		this.respostas = respostas;
	}

}
