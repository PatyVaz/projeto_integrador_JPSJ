package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioBD {
	static Connection conexao;
	
	public UsuarioBD() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemodb", "root", "sasalegal123");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	public Usuario efetuarLogin(Usuario usuario) {
		try {
			PreparedStatement ps = conexao
			.prepareStatement("select * from usuario where login = ? and senha = ?");
			ps.setString(1, usuario.getLogin());
			ps.setInt(2, usuario.getSenha());
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

}
