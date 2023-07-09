package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Interfaces.IFilme;
import conexao.ConexaoMySql;
import modelo.Filme;

public class FilmeDAO implements IFilme{
	private static Connection conexao;
	private static FilmeDAO instancia;
	private static ArrayList<Filme> filme = new ArrayList<>();
	
	private FilmeDAO() {
		conexao = ConexaoMySql.getConexao();
	}
	
	public static FilmeDAO getInstancia() {
        if (instancia == null) {
            instancia = new FilmeDAO();
            filme = new ArrayList<>();
        }
        
        return instancia;
    }
	
	@Override
	public ArrayList<Filme> mostraFilme() {
		ArrayList<Filme> filmes = new ArrayList<>();
		
		String selectSQL = "SELECT filme_nome FROM FILME";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(selectSQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Filme f = new Filme(rs.getString("filme_nome"));
				filmes.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		
		return filmes;
	}
	
	

}
