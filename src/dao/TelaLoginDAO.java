package dao;

import conection.postgreConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLoginDAO {
    
    private Connection conexao;
    private postgreConection postgreConection;
        
    public TelaLoginDAO(postgreConection a){
        
        this.postgreConection = a;
        
    }
    
    public boolean logar(String login, String senha, int op){
        
        String sql = null;
        
        switch (op){
            case 1: 
                
                sql = "select from gerente where cpf = ? and senha = ?";
                try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, login);
                        stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
            case 2:
                
                sql = "select from atendente where cpf = ? and senha = ?";
                
                try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, login);
                        stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
                
            case 3:
                
                sql = "select from veterinario where cpf = ? and senha = ?";
                
                try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, login);
                        stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
        }
       return false; 
    }
    
}
