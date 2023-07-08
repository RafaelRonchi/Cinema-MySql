package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import Interfaces.IFuncionario;
import conexao.ConexaoMySql;
import modelo.Funcionario;

public class FuncionarioDAO implements IFuncionario{
	  private static FuncionarioDAO instancia;
	  private static ArrayList<Funcionario> funcionario = new ArrayList<>();
	  private Connection conexao;

	// Construtor privado para impedir a criação de instâncias diretamente
	    private FuncionarioDAO() {
	        conexao = ConexaoMySql.getConexao();
	        // Restante da lógica de inicialização
	    }
	    
	 // Método estático para obter a instância única do FuncionarioDAO
	    public static FuncionarioDAO getInstancia() {
	        if (instancia == null) {
	            instancia = new FuncionarioDAO();
	            funcionario = new ArrayList<>();
	        }
	        
	        return instancia;
	    }

	@Override
	public boolean inserir(Funcionario p) {

		String insertSQL = "INSERT INTO FUNCIONARIO (cpf_funcionario, nome_funcionario, funcionario_valor_vendas) VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		
		try {			
			ps = conexao.prepareStatement(insertSQL);
			ps.setString( 1, String.valueOf(p.getCpf()));
			double valor = 0.00;
			ps.setString( 2, p.getNome());
			ps.setDouble(3, valor);
			
			ps.execute();
			ps.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		

	}
	@Override
	public boolean remover(Funcionario f) {
	    String deleteSQL = "DELETE FROM FUNCIONARIO WHERE cpf_funcionario = ?";
	    PreparedStatement ps = null;
	    
	    try {
			ps = conexao.prepareStatement(deleteSQL);
			ps.setString(1, String.valueOf(f.getCpf()));
			
			int rowsAffected = ps.executeUpdate();
	        ps.close();
	        
	        if (rowsAffected > 0) {
	            return true;
	        } else {
	        	return false;
	        }
		} catch (Exception e) {
			 e.printStackTrace();	
			 return false;
		}
	}

	@Override
	public boolean alterar(Funcionario novoFuncionario) {
		String updateSQL = "UPDATE FUNCIONARIO SET nome_funcionario = ? WHERE cpf_funcionario = ?";
	    PreparedStatement ps = null;
	    try {            
	        ps = conexao.prepareStatement(updateSQL);
	        ps.setString(1, novoFuncionario.getNome());
	        ps.setString(2, String.valueOf(novoFuncionario.getCpf()));
	        
	        int rowsAffected = ps.executeUpdate();
	        ps.close();
	        
	        if (rowsAffected > 0) {
	            return true;
	        } else {
	        	return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public boolean verificarLogin(Funcionario funcionario) {
	    String selectSQL = "SELECT cpf_funcionario, nome_funcionario FROM FUNCIONARIO WHERE cpf_funcionario = ? AND nome_funcionario = ?";
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = conexao.prepareStatement(selectSQL);
	        ps.setLong(1, funcionario.getCpf());
	        ps.setString(2, funcionario.getNome());
	        rs = ps.executeQuery();

	        return rs.next(); // Retorna true se houver um resultado na consulta, indicando um login válido

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
	
	@Override
	public ArrayList<Funcionario> listarFuncionario() {
	    ArrayList<Funcionario> lista = new ArrayList<>();
	    
	    String selectSQL = "SELECT cpf_funcionario, nome_funcionario FROM FUNCIONARIO";
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        ps = conexao.prepareStatement(selectSQL);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            long cpf = rs.getLong("cpf_funcionario");
	            String nome = rs.getString("nome_funcionario");
	            
	            Funcionario funcionario = new Funcionario(cpf, nome);
	            lista.add(funcionario);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
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
	    
	    return lista;
	}


}
