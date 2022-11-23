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
	 
		public ArrayList<VendaCompleto> listarTodasVendas(VendaCompleto vc2) {
			PreparedStatement ps;
			ResultSet rs;
			ArrayList<VendaCompleto> listaVenda = new ArrayList<VendaCompleto>();
			try {
				ps = conexao.prepareStatement("select venda_id_venda,venda.clientes_id_cadastro,venda.usuario_id_usuario,produtos.modelo,venda.preco,venda.data  from venda_has_produtos\r\n"
						+ " inner join venda on venda_has_produtos.venda_id_venda = venda.id_venda\r\n"
						+ " inner join produtos on venda_has_produtos.produtos_id_produto= produtos.id_produto ");
				rs = ps.executeQuery();
				while (rs.next()) {
					VendaCompleto vc = new VendaCompleto();

					vc.setId(rs.getInt("venda_id_venda"));
					vc.setCadastro(rs.getString("clientes_id_cadastro"));
					vc.setUsuario(rs.getString("venda.usuario_id_usuario"));
					vc.setProduto(rs.getString("produtos.modelo"));
					vc.setValor(rs.getDouble("preco"));
					vc.setData(rs.getString("data"));
					
					listaVenda.add(vc);
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
				ps = conexao.prepareStatement("select venda_id_venda,venda.clientes_id_cadastro,venda.usuario_id_usuario,produtos.modelo,venda.preco,venda.data  from venda_has_produtos inner join venda on venda_has_produtos.venda_id_venda = venda.id_venda inner join produtos on venda_has_produtos.produtos_id_produto= produtos.id_produto  where  venda.usuario_id_usuario = ? ");
				
				ps.setInt(1, vc.getId_usuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("venda_id_venda"));
					vc.setCadastro(rs.getString("clientes_id_cadastro"));
					vc.setUsuario(rs.getString("venda.usuario_id_usuario"));
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
				ps = conexao.prepareStatement(" select venda_id_venda,venda.clientes_id_cadastro,venda.usuario_id_usuario,produtos.modelo,venda.preco,venda.data  from venda_has_produtos inner join venda on venda_has_produtos.venda_id_venda = venda.id_venda inner join produtos on venda_has_produtos.produtos_id_produto= produtos.id_produto where  venda.clientes_id_cadastro = ? ");
				
				ps.setInt(1, vc.getId_cliente());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("venda_id_venda"));
					vc.setCadastro(rs.getString("clientes_id_cadastro"));
					vc.setUsuario(rs.getString("venda.usuario_id_usuario"));
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
				ps = conexao.prepareStatement(" select venda_id_venda,venda.clientes_id_cadastro,venda.usuario_id_usuario,produtos.modelo,venda.preco,venda.data  from venda_has_produtos\r\n"
						+ " inner join venda on venda_has_produtos.venda_id_venda = venda.id_venda\r\n"
						+ " inner join produtos on venda_has_produtos.produtos_id_produto= produtos.id_produto  where  venda.clientes_id_cadastro= ? and venda.usuario_id_usuario = ? ");
				ps.setInt(1, vc.getId_cliente());
				ps.setInt(2, vc.getId_usuario());
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("venda_id_venda"));
					vc.setCadastro(rs.getString("clientes_id_cadastro"));
					vc.setUsuario(rs.getString("venda.usuario_id_usuario"));
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
				ps = conexao.prepareStatement("select venda_id_venda,venda.clientes_id_cadastro,venda.usuario_id_usuario,produtos.modelo,venda.preco,venda.data  \r\n"
						+ "from venda_has_produtos inner join venda on venda_has_produtos.venda_id_venda = venda.id_venda inner join produtos on venda_has_produtos.produtos_id_produto= produtos.id_produto where  venda.data = ? ;");
				ps.setString(1, vc.getData());
				
				rs = ps.executeQuery();
				while (rs.next()) {
					vc = new VendaCompleto();

					vc.setId(rs.getInt("venda_id_venda"));
					vc.setCadastro(rs.getString("clientes_id_cadastro"));
					vc.setUsuario(rs.getString("venda.usuario_id_usuario"));
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
