package controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Fornecedor;

public class FornecedorBD {
	
	private Connection conexao;
	public FornecedorBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}

	public int removeFornecedor(Fornecedor fornecedor) {
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement("delete from fornecedores where id_fornecedor=?");
			
			ps.setInt(1, fornecedor.getId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e1) {
			System.out.println("erro delete.");
		}
		return 0;
	}
	
	public ArrayList<Fornecedor> listarTodosFornecedor() {
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		try {
			ps = conexao.prepareStatement ("select * from fornecedores order by nome");
			rs= ps.executeQuery();
			while(rs.next( ) ) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id_fornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setEmail(rs.getString("email"));
				
				fornecedor.setTelefone(rs.getString("telefone"));
				
				listaFornecedor.add(fornecedor);
		}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return listaFornecedor;
	}
	
	public boolean inserirFornecedor(Fornecedor fornecedor ) {
	
		try {

			PreparedStatement ps = conexao.prepareStatement("insert into fornecedores (nome, cnpj, telefone, email) values(?,?,?,?)");
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3	, fornecedor.getTelefone());
			ps.setString(4, fornecedor.getEmail());
		
		
			ps.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}

		return false;
	}
	
	public int alterarFornecedor(Fornecedor fornecedor) {
	
		try {
			

			PreparedStatement ps = conexao.prepareStatement("update fornecedores set nome=?,email=?,cnpj=?,telefone=? where id_fornecedor = ?");
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getEmail());
			ps.setString(3, fornecedor.getCnpj());
			ps.setString(4, fornecedor.getTelefone());
			ps.setInt(5, fornecedor.getId());
			ps.executeUpdate();

			

			

			

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return 0;
	}

}