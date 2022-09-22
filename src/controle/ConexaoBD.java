package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	static Connection conexao;

	public static Connection ConexaoBanco() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/deemodb", "root", "sasalegal123");

		} catch (SQLException e) {
			System.out.println("Erro ao conectar ï¿½ base de dados.");
		}
		return conexao;
	}
	
}
