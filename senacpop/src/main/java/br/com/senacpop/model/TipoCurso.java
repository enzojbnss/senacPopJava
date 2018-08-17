package br.com.senacpop.model;

public class TipoCurso {

	private Integer id;
	private String descricao;
	private String ativo;

	public TipoCurso() {
		// TODO Auto-generated constructor stub
	}

	public TipoCurso(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoCurso(Integer id, String descricao, String ativo) {
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
