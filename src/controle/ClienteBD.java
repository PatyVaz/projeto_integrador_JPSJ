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

			PreparedStatement ps = conexao.prepareStatement("delete from cadastro where id_cadastro=?");
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
			ps = conexao.prepareStatement ("select * from cadastro order by nome");
			rs= ps.executeQuery();
			while(rs.next( ) ) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id_cadastro"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getInt("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRua(rs.getString("rua"));
				cliente.setTelefone(rs.getInt("telefone"));
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
					"insert into cadastro (nome, cpf, email, rua,bairro, telefone, cep, cidade) values(?,?,?,?,?,?,?,?)");

			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getRua());
			ps.setString(5, cliente.getBairro());
			ps.setInt(6, cliente.getTelefone());
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
			

			PreparedStatement ps = conexao.prepareStatement("update cadastro set nome=? where id_cadastro = ?");
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps.executeUpdate();
			ps = conexao.prepareStatement("update cadastro set email=? where id_cadastro = ?");
			ps.setString(1, cliente.getEmail());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps = conexao.prepareStatement("update cadastro set cpf=? where id_cadastro = ?");
			ps.setInt(1, cliente.getCpf());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

			ps = conexao.prepareStatement("update cadastro set rua=? where id_cadastro = ?");
			ps.setString(1, cliente.getRua());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();
			
			ps = conexao.prepareStatement("update cadastro set bairro=? where id_cadastro = ?");
			ps.setString(1, cliente.getBairro());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();
			
			ps = conexao.prepareStatement("update cadastro set telefone=? where id_cadastro = ?");
			ps.setInt(1, cliente.getTelefone());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();
			
			ps = conexao.prepareStatement("update cadastro set cep=? where id_cadastro = ?");
			ps.setString(1, cliente.getCep());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();
			
			ps = conexao.prepareStatement("update cadastro set cidade=? where id_cadastro = ?");
			ps.setString(1, cliente.getCidade());
			ps.setInt(2, cliente.getId());
			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}

}
