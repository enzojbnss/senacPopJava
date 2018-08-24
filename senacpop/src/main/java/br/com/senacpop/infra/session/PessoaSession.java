package br.com.senacpop.infra.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senacpop.model.Pessoa;

@SessionScoped
@Named("pessoaSession")
public class PessoaSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5189076299241021175L;
	private Pessoa pessoa;

	public PessoaSession() {
		// TODO Auto-generated constructor stub
	}

	public void registrar(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void remover() {
		this.pessoa = null;
	}

	public Boolean isRegitred() {
		return (this.pessoa != null);
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public Integer getIDPessoa() {
		return this.pessoa.getId();
	}

}
