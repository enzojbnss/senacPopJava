package br.com.senacpop.model;

public class Curso {
	private Integer id;
	private String nome;
	private String tipoCurso;

	public Curso() {
	}

	public Curso(Integer id, String nome, String tipoCurso) {
		this.id = id;
		this.nome = nome;
		this.tipoCurso = tipoCurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

}
