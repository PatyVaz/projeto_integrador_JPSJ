package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.CadastroProdutos;
import modelo.Estoque;

public class EstoqueBD {
	static Connection conexao;
	
	public EstoqueBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}
	public ArrayList<Estoque> listarTodosEstoque() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();
		try {
			ps = conexao.prepareStatement(" select  estoque.id_estoque,produtos.modelo,fornecedores.nome,estoque.quantidade,estoque.valor,estoque.data from estoque inner join produtos on\r\n"
					+ " produtos.id_produto = estoque.id_produto inner join fornecedores on estoque.id_fornecedor = fornecedores.id_fornecedor");
			rs = ps.executeQuery();
			while (rs.next()) {
				Estoque estoque = new Estoque();
				estoque.setId_estoque(rs.getInt("id_estoque"));
				estoque.setFornecedor(rs.getString("fornecedores.nome"));
				estoque.setProduto(rs.getString("produtos.modelo"));
				estoque.setQuantidade(rs.getInt("quantidade"));
				estoque.setValor(rs.getString("valor"));
				estoque.setData(rs.getString("data"));
				
				listaEstoque.add(estoque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEstoque;
	}
	public boolean inserirEstoque(Estoque estoque) {

		try {

			PreparedStatement ps = conexao.prepareStatement(
					"insert into estoque( id_fornecedor ,id_produto ,quantidade ,valor ,data ) values(?,?,?,?,?)");

			
			ps.setString(1, estoque.getFornecedor());
			ps.setString(2, estoque.getProduto());
			ps.setInt(3, estoque.getQuantidade());
			ps.setString(4, estoque.getValor());
			ps.setString(5, estoque.getData());
		

			ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println(e1);
		}

		return false;
	}
}
