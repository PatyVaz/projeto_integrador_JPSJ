package modelo;

public class Estoque {
private int id_estoque;
private int fornecedor;
private int produto;
private int quantidade;
private String valor;
private String data;
public int getId_estoque() {
	return id_estoque;
}
public void setId_estoque(int id_estoque) {
	this.id_estoque = id_estoque;
}
public int getFornecedor() {
	return fornecedor;
}
public void setFornecedor(int fornecedor) {
	this.fornecedor = fornecedor;
}
public int getProduto() {
	return produto;
}
public void setProduto(int produto) {
	this.produto = produto;
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
}
