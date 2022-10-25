package modelo;

public class Venda {

	private int id;
	private int usuario;
	private int produto;
	private int cadastro;
	private Double valor;
	private String data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public int getCadastro() {
		return cadastro;
	}
	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}


