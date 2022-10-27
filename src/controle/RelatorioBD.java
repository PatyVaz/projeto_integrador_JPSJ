package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.CadastroProdutos;
import modelo.Cliente;
import modelo.Venda;

public class RelatorioBD {
	private Connection conexao;
	
	 public RelatorioBD() {
		
		conexao = ConexaoBD.ConexaoBanco();
	}
	 
		public ArrayList<Venda> listarTodasVendas() {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<Venda> listaVenda = new ArrayList<Venda>();
			try {
				ps = conexao.prepareStatement("select * from venda");
				rs = ps.executeQuery();
				while (rs.next()) {
					Venda venda = new Venda();

					venda.setCadastro(rs.getInt("id_venda"));
					venda.setCadastro(rs.getInt("id_doCliente"));
					venda.setUsuario(rs.getInt("id_doUsuario"));
					venda.setProduto(rs.getInt("id_doProduto"));
					venda.setValor(rs.getDouble("preco"));
					venda.setData(rs.getString("data"));
					
					listaVenda.add(venda);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaVenda;
		}
		
		
		public ArrayList<Venda> listarVendaID(Venda v) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<Venda> listarVenda = new ArrayList<Venda>();
			try {
				ps = conexao.prepareStatement("select * from venda where  id_doUsuario = ? ");
				
				ps.setInt(1, v.getUsuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					 v = new Venda();

					v.setCadastro(rs.getInt("id_venda"));
					v.setCadastro(rs.getInt("id_doCliente"));
					v.setUsuario(rs.getInt("id_doUsuario"));
					v.setProduto(rs.getInt("id_doProduto"));
					v.setValor(rs.getDouble("preco"));
					v.setData(rs.getString("data"));
					
					listarVenda.add(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVenda;
		}
		
		public ArrayList<Venda> listarVendaCliente(Venda v) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<Venda> listarVendaCliente = new ArrayList<Venda>();
			try {
				ps = conexao.prepareStatement("select * from venda where  id_doCliente = ? ");
				
				ps.setInt(1, v.getCadastro());
				rs = ps.executeQuery();
				while (rs.next()) {
					 v = new Venda();

					v.setCadastro(rs.getInt("id_venda"));
					v.setCadastro(rs.getInt("id_doCliente"));
					v.setUsuario(rs.getInt("id_doUsuario"));
					v.setProduto(rs.getInt("id_doProduto"));
					v.setValor(rs.getDouble("preco"));
					v.setData(rs.getString("data"));
					
					listarVendaCliente.add(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendaCliente;
		}
		
		public ArrayList<Venda> listarVendaClienteVendedor(Venda v) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<Venda> listarVendaClienteVendedor = new ArrayList<Venda>();
			try {
				ps = conexao.prepareStatement("select * from venda where  id_doCliente = ? and id_doUsuario = ? ");
				ps.setInt(1, v.getCadastro());
				ps.setInt(2, v.getUsuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					 v = new Venda();

					v.setCadastro(rs.getInt("id_venda"));
					v.setCadastro(rs.getInt("id_doCliente"));
					v.setUsuario(rs.getInt("id_doUsuario"));
					v.setProduto(rs.getInt("id_doProduto"));
					v.setValor(rs.getDouble("preco"));
					v.setData(rs.getString("data"));
					
					listarVendaClienteVendedor.add(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendaClienteVendedor;
		}
		
		
		public ArrayList<Venda> listarVendasData(Venda v) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<Venda> listarVendasData = new ArrayList<Venda>();
			try {
				ps = conexao.prepareStatement("select * from venda where  data = ? ");
				ps.setString(1, v.getData());
				
				rs = ps.executeQuery();
				while (rs.next()) {
					 v = new Venda();

					v.setCadastro(rs.getInt("id_venda"));
					v.setCadastro(rs.getInt("id_doCliente"));
					v.setUsuario(rs.getInt("id_doUsuario"));
					v.setProduto(rs.getInt("id_doProduto"));
					v.setValor(rs.getDouble("preco"));
					v.setData(rs.getString("data"));
					
					listarVendasData.add(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendasData;
		}
		
}
