package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Venda;
import modelo.VendaCompleto;

public class RelatorioBD {
	private Connection conexao;
	
	 public RelatorioBD() {
		
		conexao = ConexaoBD.ConexaoBanco();
	}
	 
		public ArrayList<VendaCompleto> listarTodasVendas() {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listaVenda = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement(" select venda.id_venda,clientes.nome,usuario.nome,cadastroprodutos.modelo,venda.preco,venda.data  from venda inner join clientes on venda.id_doCliente = clientes.id_cadastro inner join usuario on usuario.id_usuario = venda.id_doUsuario inner join cadastroprodutos on cadastroprodutos.id_produto = venda.id_doProduto;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "");
				rs = ps.executeQuery();
				while (rs.next()) {
					VendaCompleto VC = new VendaCompleto();

					VC.setId(rs.getInt("id_venda"));
					VC.setCadastro(rs.getString("cadastro.nome"));
					VC.setUsuario(rs.getString("usuario.nome"));
					VC.setProduto(rs.getString("cadastroprodutos.modelo"));
					VC.setValor(rs.getDouble("preco"));
					VC.setData(rs.getString("data"));
					
					listaVenda.add(VC);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listaVenda;
		}
		
		
		public ArrayList<VendaCompleto> listarVendaID(VendaCompleto vc) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listarVenda = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement(" select venda.id_venda,clientes.nome,usuario.nome,produtos.modelo,venda.preco,venda.data  from venda inner join clientes on venda.id_doCliente = clientes.id_cadastro inner join usuario on usuario.id_usuario = venda.id_doUsuario inner join produtos on produtos.id_produto = venda.id_doProduto  where  venda.id_doUsuario = ? ;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ " ");
				
				ps.setInt(1, vc.getId_usuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("id_venda"));
					vc.setCadastro(rs.getString("clientes.nome"));
					vc.setUsuario(rs.getString("usuario.nome"));
					vc.setProduto(rs.getString("produtos.modelo"));
					vc.setValor(rs.getDouble("preco"));
					vc.setData(rs.getString("data"));
					
					listarVenda.add(vc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVenda;
		}
		
		public ArrayList<VendaCompleto> listarVendaCliente(VendaCompleto vc) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listarVendaCliente = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement(" select venda.id_venda,clientes.nome,usuario.nome,produtos.modelo,venda.preco,venda.data  from venda inner join clientes on venda.id_doCliente = clientes.id_cadastro inner join usuario on usuario.id_usuario = venda.id_doUsuario inner join produtos on produtos.id_produto = venda.id_doProduto  where  venda.id_doCliente = ? ;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ " ");
				
				ps.setInt(1, vc.getId_cliente());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("id_venda"));
					vc.setCadastro(rs.getString("clientes.nome"));
					vc.setUsuario(rs.getString("usuario.nome"));
					vc.setProduto(rs.getString("produtos.modelo"));
					vc.setValor(rs.getDouble("preco"));
					vc.setData(rs.getString("data"));
					
					listarVendaCliente.add(vc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendaCliente;
		}
		
		public ArrayList<VendaCompleto> listarVendaClienteVendedor(VendaCompleto vc) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listarVendaClienteVendedor = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement(" select venda.id_venda,clientes.nome,usuario.nome,produtos.modelo,venda.preco,venda.data  from venda inner join clientes on venda.id_doCliente = clientes.id_cadastro inner join usuario on usuario.id_usuario = venda.id_doUsuario inner join produtos on produtos.id_produto = venda.id_doProduto  where  venda.id_doCliente = ? and venda.id_doUsuario = ? ;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ " ");
				ps.setInt(1, vc.getId_cliente());
				ps.setInt(2, vc.getId_usuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("id_venda"));
					vc.setCadastro(rs.getString("clientes.nome"));
					vc.setUsuario(rs.getString("usuario.nome"));
					vc.setProduto(rs.getString("produtos.modelo"));
					vc.setValor(rs.getDouble("preco"));
					vc.setData(rs.getString("data"));
					
					listarVendaClienteVendedor.add(vc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendaClienteVendedor;
		}
		
		
		public ArrayList<VendaCompleto> listarVendasData(VendaCompleto vc) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listarVendasData = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement("select venda.id_venda,clientes.nome,usuario.nome,produtos.modelo,venda.preco,venda.data  from venda inner join clientes on venda.id_doCliente = clientes.id_cadastro inner join usuario on usuario.id_usuario = venda.id_doUsuario inner join produtos on produtos.id_produto = venda.id_doProduto  where  venda.data = ? ;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ " ");
				ps.setString(1, vc.getData());
				
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("id_venda"));
					vc.setCadastro(rs.getString("clientes.nome"));
					vc.setUsuario(rs.getString("usuario.nome"));
					vc.setProduto(rs.getString("produtos.modelo"));
					vc.setValor(rs.getDouble("preco"));
					vc.setData(rs.getString("data"));
					
					listarVendasData.add(vc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listarVendasData;
		}
		
}
