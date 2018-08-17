package br.com.senacpop.model;

public class Area {

	private Integer id;
	private String descricao;
	private String ativo;
	private String cursos;

	public Area() {
	}

	public Area(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Area(Integer id, String descricao, String ativo) {
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public Area(Integer id, String descricao, String ativo, String cursos) {
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.cursos = cursos;
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

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}

}
