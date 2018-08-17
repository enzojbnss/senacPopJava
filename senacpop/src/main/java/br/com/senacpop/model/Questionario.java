package br.com.senacpop.model;

public class Questionario {
	private Integer id;
	private String perguntas;
	private String data;
	private String ativo;

	public Questionario() {
		// TODO Auto-generated constructor stub
	}

	public Questionario(Integer id, String data) {
		this.id = id;
		this.data = data;
	}

	public Questionario(Integer id, String perguntas, String data) {
		this.id = id;
		this.perguntas = perguntas;
		this.data = data;
	}

	public Questionario(Integer id, String perguntas, String data, String ativo) {
		this.id = id;
		this.perguntas = perguntas;
		this.data = data;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(String perguntas) {
		this.perguntas = perguntas;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
