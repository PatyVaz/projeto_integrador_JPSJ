package modelo;

/**
 * Classe modelo para usuario que manipula o sistema
 * 
 * @author Julia
 *
 */

public class Usuario {

	private String emailAcesso;
	private String senha;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailAcesso() {
		return emailAcesso;
	}

	public void setEmailAcesso(String emailAcesso) {
		this.emailAcesso = emailAcesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
