package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
	// Usuario do banco
	private static final String url = "jdbc:mysql://localhost:3306/cinemapds";
	private static final String user = "root";
	private static final String pass= "root";
	
	// Var da conexão
	private static Connection conn;
	
	// Ver se já tem conexão
	public static Connection getConexao()
	{			
		try {
			if(conn == null) {
					conn = DriverManager.getConnection(url, user, pass);
					return conn;
			} else {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
