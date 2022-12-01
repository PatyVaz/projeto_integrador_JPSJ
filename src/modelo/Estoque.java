package modelo;

public class Estoque {
private int id_estoque;
private String fornecedor;
private String produto;
private int quantidade;
private String valor;
private String data;
public int getId_estoque() {
	return id_estoque;
}
public void setId_estoque(int id_estoque) {
	this.id_estoque = id_estoque;
}

public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public String getValor() {
	return valor;
}
public void setValor(String valor) {
	this.valor = valor;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getProduto() {
	return produto;
}
public void setProduto(String produto) {
	this.produto = produto;
}
public String getFornecedor() {
	return fornecedor;
}
public void setFornecedor(String fornecedor) {
	this.fornecedor = fornecedor;
}
}
