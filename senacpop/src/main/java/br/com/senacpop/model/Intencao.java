package br.com.senacpop.model;

public class Intencao {

	private Integer id;
	private String texto;
	private String ativo;

	public Intencao() {

	}

	public Intencao(Integer id, String texto, String ativo) {
		this.id = id;
		this.texto = texto;
		this.ativo = ativo;
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

}
