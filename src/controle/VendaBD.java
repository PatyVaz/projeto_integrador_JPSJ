package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import modelo.Venda;


public class VendaBD {
	static Connection conexao;

	public VendaBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}
	
	public ArrayList<Venda> buscarVenda() {

		PreparedStatement ps;
	    ResultSet rs;
	    ArrayList<Venda> listarVenda = new ArrayList<Venda>();
	    
		try {
			ps = conexao.prepareStatement ("select * from venda");
			rs = ps.executeQuery();
			while( rs.next() ){
				Venda venda = new Venda();
			    venda.setId(rs.getInt("id_venda"));
			    venda.setCadastro(rs.getInt("id_doCliente"));
			    venda.setUsuario(rs.getInt("id_doUsuario"));
			    venda.setProduto(rs.getInt("id_doProduto"));
			    venda.setValor(rs.getDouble("preco"));
			    venda.setData(rs.getString("data"));
		    	
	     }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    return listarVenda;
	}
	
	public int inserirVenda(Venda v) {
		
		

		try {
			
			  PreparedStatement ps = conexao.prepareStatement("insert into venda ( clientes_id_cadastro , usuario_id_usuario  , preco , data) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1,v.getCadastro());
			ps.setInt(2,v.getUsuario());
			ps.setDouble(3,v.getValor());
			ps.setString(4,v.getData());
			
		    ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if (rs.next()){
				
			    int resultado = rs.getInt(1);
			
			    ps = conexao.prepareStatement("insert into venda_has_produtos (venda_id_venda,produtos_id_produto) values(?,?)");	
			  
			     ps.setInt(1,resultado);
			
			     ps.setInt(2,v.getId_produto());
			
			     ps.executeUpdate();
			   
			}
			
			}catch(SQLException e1)
			{
				System.out.println("Erro ao conectar ï¿½ base de dados.");
			}
	return 0;
}
	

	
	
}