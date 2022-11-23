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
			ps = conexao.prepareStatement("select * from estoque order by id_produto");
			rs = ps.executeQuery();
			while (rs.next()) {
				Estoque estoque = new Estoque();
				estoque.setId_estoque(rs.getInt("id_estoque"));
				estoque.setFornecedor(rs.getInt("id_fornecedor"));
				estoque.setProduto(rs.getInt("id_produto"));
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

			
			ps.setInt(1, estoque.getFornecedor());
			ps.setInt(2, estoque.getProduto());
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
