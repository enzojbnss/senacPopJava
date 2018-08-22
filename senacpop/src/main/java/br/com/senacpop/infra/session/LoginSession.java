package br.com.senacpop.infra.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("loginSession")
public class LoginSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9129909723432296568L;
	
	private Boolean logado = false;
	
	public LoginSession() {
		// TODO Auto-generated constructor stub
	}
	
	public void logar() {
		this.logado = true;
	}
	
	public void deslogar() {
		this.logado = false;
	}
	
	public Boolean isLogado() {
		return this.logado;
	}
	

}
