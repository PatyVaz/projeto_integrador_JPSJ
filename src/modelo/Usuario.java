package modelo;

/**
 * Classe modelo para usuario que manipula o sistema
 * 
 * @author Julia
 *
 */

public class Usuario {

	
	private String login;
	private String senha;
	private int id;
	private String nome;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}



}
