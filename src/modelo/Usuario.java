package modelo;

/**
 * Classe modelo para usuario que manipula o sistema
 * 
 * @author Julia
 *
 */

public class Usuario {

	
	private String login;
	private int senha;
	private int id;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



}
