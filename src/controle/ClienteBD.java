package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;

public class ClienteBD {
	
	private Connection conexao;
	public ClienteBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}

	public int removeCliente(Cliente cliente) {
		
		
		
		
		try {

			PreparedStatement ps = conexao.prepareStatement("delete from clientes where id_cadastro=?");
			ps.setInt(1, cliente.getId());
			return ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}
		return 0;
	}
	
	
	
	
	
	

	public ArrayList<Cliente> listarTodosClientes() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			ps = conexao.prepareStatement ("select * from clientes order by nome");
			rs= ps.executeQuery();
			while(rs.next( ) ) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id_cadastro"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRua(rs.getString("rua"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setCidade(rs.getString("cidade"));
				listaClientes.add(cliente);
		}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return listaClientes;
	}
	
	
	
	
	

	public boolean inserirCliente(Cliente cliente) {
	
		try {

			PreparedStatement ps = conexao.prepareStatement(
					"insert into clientes (nome, cpf, email, rua,bairro, telefone, cep, cidade) values(?,?,?,?,?,?,?,?)");

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getRua());
			ps.setString(5, cliente.getBairro());
			ps.setString(6, cliente.getTelefone());
			ps.setString(7, cliente.getCep());
			ps.setString(8, cliente.getCidade());
			ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}

		return false;
	}
	
	public int alterarClientes(Cliente cliente) {
	
		try {
			

			PreparedStatement ps = conexao.prepareStatement("update clientes set nome=?,email=?,cpf=?,rua=?,bairro=?,telefone=?,cep=?,cidade=? where id_cadastro = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getCpf());
			ps.setString(4, cliente.getRua());
			ps.setString(5, cliente.getBairro());
			ps.setString(6, cliente.getTelefone());
			ps.setString(7, cliente.getCep());
			ps.setString(8, cliente.getCidade());
			ps.setInt(9, cliente.getId());
			ps.executeUpdate();

			
		

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}
	public Cliente listarClientesID(Cliente cliente) {
		PreparedStatement ps;
		ResultSet rs;
		Cliente cl = null;
		try {
			ps = conexao.prepareStatement("select * from clientes where  id_cadastro = ? ");
			ps.setInt(1, cliente.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				cl = new Cliente();
				cl.setId(rs.getInt("id_cadastro"));
				cl.setNome(rs.getString("nome"));
				cl.setCpf(rs.getString("cpf"));
				cl.setEmail(rs.getString("email"));
				cl.setRua(rs.getString("rua"));
				cl.setTelefone(rs.getString("telefone"));
				cl.setBairro(rs.getString("bairro"));
				cl.setCep(rs.getString("cep"));
				cl.setCidade(rs.getString("cidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

}
