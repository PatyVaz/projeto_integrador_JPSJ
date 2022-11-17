
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.CadastroProdutos;

public class ProdutoBD {
	private Connection conexao;

	public ProdutoBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}

	public int removeProduto(CadastroProdutos cadastroProdutos) {

		try {

			PreparedStatement ps = conexao.prepareStatement("delete from produtos where id_produto=?");
			ps.setInt(1, cadastroProdutos.getId());
			return ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println(e1);
		}
		return 0;
	}

	public ArrayList<CadastroProdutos> listarTodosProdutos() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<CadastroProdutos> listaProdutos = new ArrayList<CadastroProdutos>();
		try {
			ps = conexao.prepareStatement("select * from produtos order by modelo");
			rs = ps.executeQuery();
			while (rs.next()) {
				CadastroProdutos cadastroprodutos = new CadastroProdutos();
				cadastroprodutos.setId(rs.getInt("id_produto"));
				cadastroprodutos.setCor(rs.getString("cor"));
				cadastroprodutos.setTamanho(rs.getInt("tamanho"));
				cadastroprodutos.setMarca(rs.getString("marca"));
				cadastroprodutos.setModelo(rs.getString("modelo"));
				cadastroprodutos.setPreco(rs.getDouble("preco"));
				cadastroprodutos.setQuantidade(rs.getInt("quantidade"));
				cadastroprodutos.setIdfornecedor(rs.getInt("fornecedores_id_fornecedor"));
				listaProdutos.add(cadastroprodutos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}

	public boolean inserirProduto(CadastroProdutos cadastroProdutos) {

		try {

			PreparedStatement ps = conexao.prepareStatement(
					"insert into produtos(cor, tamanho, marca, modelo, preco, quantidade,fornecedores_id_fornecedor) values(?,?,?,?,?,?,?)");

			ps.setString(1, cadastroProdutos.getCor());
			ps.setInt(2, cadastroProdutos.getTamanho());
			ps.setString(3, cadastroProdutos.getMarca());
			ps.setString(4, cadastroProdutos.getModelo());
			ps.setDouble(5, cadastroProdutos.getPreco());
			ps.setInt(6, cadastroProdutos.getQuantidade());
			ps.setInt(7, cadastroProdutos.getIdfornecedor());

			ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println(e1);
		}

		return false;
	}

	public int alterarProduto(CadastroProdutos cadastroProdutos) {

		try {

			PreparedStatement ps = conexao.prepareStatement("update produtos set cor=?,tamanho=?,marca=?, modelo=?, preco=?,quantidade=?   where id_produto = ?");
			ps.setString(1, cadastroProdutos.getCor());
			ps.setInt(2, cadastroProdutos.getTamanho());
			ps.setString(3, cadastroProdutos.getMarca());
			ps.setString(4, cadastroProdutos.getModelo());
			ps.setDouble(5, cadastroProdutos.getPreco());
			ps.setInt(6, cadastroProdutos.getQuantidade());
			ps.setInt(7, cadastroProdutos.getId());
			ps.executeUpdate();

			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}
	
	public int alterarQuantidade(CadastroProdutos cadastroProdutos) {

		try {

			PreparedStatement ps = conexao.prepareStatement("update produtos set quantidade=?   where id_produto = ?");
		
			ps.setInt(1, cadastroProdutos.getQuantidade());
			ps.setInt(2, cadastroProdutos.getId());
			ps.executeUpdate();

			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}

	public CadastroProdutos listarProdutosID(CadastroProdutos cadastroProdutos) {
		PreparedStatement ps;
		ResultSet rs;
		CadastroProdutos cadProd = null;
		try {
			ps = conexao.prepareStatement("select * from produtos where  id_produto = ? ");
			ps.setInt(1, cadastroProdutos.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				cadProd = new CadastroProdutos();
				cadProd.setId(rs.getInt("id_produto"));
				cadProd.setCor(rs.getString("cor"));
				cadProd.setTamanho(rs.getInt("tamanho"));
				cadProd.setMarca(rs.getString("marca"));
				cadProd.setModelo(rs.getString("modelo"));
				cadProd.setPreco(rs.getDouble("preco"));
				cadProd.setQuantidade(rs.getInt("quantidade"));
				cadProd.setIdfornecedor(rs.getInt("fornecedores_id_fornecedor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cadProd;
	}
	
	public CadastroProdutos listarquantidadeID(CadastroProdutos cadastroProdutos) {
		PreparedStatement ps;
		ResultSet rs;
		CadastroProdutos quantidadeID = null;
		try {
			ps = conexao.prepareStatement("select quantidade from produtos where  id_produto = ? ");
			ps.setInt(1, cadastroProdutos.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				quantidadeID = new CadastroProdutos();
				
				quantidadeID.setQuantidade(rs.getInt("quantidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidadeID;
	}
	
	public CadastroProdutos baixaNoEstoque(CadastroProdutos cadastroProdutos) {

		try {


			PreparedStatement ps = conexao.prepareStatement("update produtos set quantidade=? where id_produto = ?");
			ps.setInt(1, cadastroProdutos.getQuantidade());
			ps.setInt(2, cadastroProdutos.getId());
			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return null;
	}
}