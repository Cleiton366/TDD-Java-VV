package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clientes.Cliente;
import conection.postgreConection;
import registro.Consulta;

public class AtendenteDAO {

	private Connection conexao;
	private postgreConection postgreConection;
	
	public AtendenteDAO(postgreConection a) {
		this.postgreConection = a;
	}
	
	public boolean addCliente(String nome, String cpf, String telefone, String email) {
		Cliente a = new Cliente();
                a.setNome(nome);
                a.setCpf(cpf);
                a.setTelefone(telefone);
                a.setEmail(email);
		String sql = "insert into cliente(nome, cpf, email, telefone) values (?, ?, ?, ?)";
		
		try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getCpf());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getTelefone());
		
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
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
	
	public Cliente buscarCliente(String cliente, String sql) {
		
		Cliente a = new Cliente();
		
		try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				a.setNome(rs.getString("nome"));
				a.setCpf(rs.getString("cpf"));
				a.setEmail(rs.getString("email"));
				a.setTelefone(rs.getString("telefone"));              
                return a;
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
		return a;
		
	}
	
	
	public boolean removerCliente(String busca, String sql) {
			
		try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, busca);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) return true;
			return false;
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
	public boolean attInfo(String sql, String novoDado, String cpf) {
		
            
             try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, novoDado);
			stmt.setString(2, cpf);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) return true;
			return false;
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
            
	}
	
	public boolean cadastrarConsulta(String nomeCliente, String especie, String horario, String data, String idConsulta) {
		
		String sql = "insert into consulta(nomeCliente, especie, horario, data, idConsulta) values (?, ?, ?, ?, ?)";
		Consulta a = new Consulta(nomeCliente, especie, horario, data, idConsulta);
		try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, a.getNomeCliente());
			stmt.setString(2, a.getEspecie());
			stmt.setString(3, a.getHorario());
			stmt.setString(4, a.getData());
                        stmt.setString(5, a.getIdConsulta());
		
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
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
}
