package controle;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioBD {
	static Connection conexao;
	
	public UsuarioBD() {
		conexao = ConexaoBD.ConexaoBanco();
	}
	
	
	
	
	public Usuario efetuarLogin(Usuario usuario) {
		try {
			PreparedStatement ps = conexao
			.prepareStatement("select * from usuario where login = ? and senha = ?");
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ResultSet rs = ps.executeQuery();
			while( rs.next() )
	        {
	             String id = rs.getString("id_usuario");
	             String login = rs.getString("login");
	             String senha = rs.getString("senha");
	             usuario.setId(Integer.parseInt(rs.getString("id_usuario")));
	             return usuario;

	        }
			
			
		} catch (SQLException e3) {

			
			System.out.println("deu ruim!");			
			}
		return null;
	}
	public ArrayList<Usuario> buscarUsuarios() {

		PreparedStatement ps;
	    ResultSet rs;
	    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	    
		try {
			ps = conexao.prepareStatement ("select * from usuario  order by nome");
			rs = ps.executeQuery();
			while( rs.next() ){
			    Usuario usuario = new Usuario();
			    usuario.setId(rs.getInt("id_usuario"));
			    usuario.setNome(rs.getString("nome"));
			    usuario.setLogin(rs.getString("login"));
			    usuario.setSenha(rs.getString("senha"));
			    listaUsuarios.add(usuario);
		    	
	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return listaUsuarios;
	}
	
	public int removerUsuario(Usuario u) {
		try {
			
			  PreparedStatement ps = conexao.prepareStatement("delete from usuario where  id_usuario=?");
		        ps.setInt(1,u.getId());
		        return ps.executeUpdate();
			
			}catch(SQLException e1)
			{
				System.out.println("Erro ao conectar ï¿½ base de dados.");
			}
		return 0;
	}
	public int inserirUsuario(Usuario u) {
		
		

		try {
			
			  PreparedStatement ps = conexao.prepareStatement("insert into usuario (login,senha,nome) values(?,?,?)");
			
			ps.setString(1,u.getLogin());
			ps.setString(2,u.getSenha());
			ps.setString(3,u.getNome());
			
			ps.executeUpdate();
		
			
			}catch(SQLException e1)
			{
				System.out.println("Erro ao conectar ï¿½ base de dados.");
			}
	return 0;
}
	
	

}
