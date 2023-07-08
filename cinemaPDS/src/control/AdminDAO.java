package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.IAdmin;
import conexao.ConexaoMySql;
import modelo.Admin;
import modelo.Funcionario;


public class AdminDAO implements IAdmin{
	
	private Connection conexao;
	 private static AdminDAO instancia;
	 private static ArrayList<Admin> admin = new ArrayList<>();

	// Construtor privado para impedir a criação de instâncias diretamente
	    private AdminDAO() {
	        conexao = ConexaoMySql.getConexao();
	        // Restante da lógica de inicialização
	    }
	    
	 // Método estático para obter a instância única do FuncionarioDAO
	    public static AdminDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new AdminDAO();
	            admin = new ArrayList<>();
	        }
	        
	        return instancia;
	    }
	@Override
	public Boolean VerAdmin(Admin a) {
	    ArrayList<Admin> lista = new ArrayList<>();

	    String selectSQL = "SELECT admin_login, admin_pass FROM admin";
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = conexao.prepareStatement(selectSQL);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            String login = rs.getString("admin_login");
	            String pass = rs.getString("admin_pass");

	            Admin admin = new Admin(login, pass);
	            lista.add(admin);
	        }

	        for (Admin admin : lista) {
	            if (a.getLogin().equals(admin.getLogin()) && a.getPass().equals(admin.getPass())) {
	                return true;
	            }
	        }

	        return false;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


}
