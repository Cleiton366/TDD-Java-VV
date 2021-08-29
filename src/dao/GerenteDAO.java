package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conection.postgreConection;
import funcionarios.Atendente;
import funcionarios.Veterinario;


public class GerenteDAO {
	
	private Connection conexao;
	private postgreConection postgreConection;
	
	public GerenteDAO(postgreConection a) {
		this.postgreConection = a;
	}
	
	public boolean addFuncionario(String nome, String telefone, String email, String endereco, double salario, String cpf, String cargo, String senha, String CONFEA, int idade, String sql) {	
		try{
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        
			if(cargo.equals("Veterinario")) {
				Veterinario b = new Veterinario(nome, telefone, email, endereco, salario, cpf, idade, cargo, senha, CONFEA);
                                
                                stmt.setString(1, b.getSenha());
				stmt.setString(2, b.getNome());
				stmt.setString(3, b.getTelefone());
				stmt.setString(4, b.getEmail());
				stmt.setString(5, b.getEndereco());
				stmt.setDouble(6, b.getSalario());
				stmt.setString(7, b.getCpf());
				stmt.setInt(8, b.getIdade());
				stmt.setString(9, b.getCargo());
				stmt.setString(10, b.getConfea());
			}else 
				if(cargo.equals("Atendente")) {
                                    Atendente a = new Atendente(nome, telefone, email, endereco, salario, cpf, idade, cargo, senha);
					
                                        stmt.setString(1, a.getSenha());
                                        stmt.setString(2, a.getNome());
					stmt.setString(3, a.getTelefone());
					stmt.setString(4, a.getEmail());
					stmt.setString(5, a.getEndereco());
					stmt.setDouble(6, a.getSalario());
					stmt.setString(7, a.getCpf());
					stmt.setInt(8, a.getIdade());
					stmt.setString(9, a.getCargo());
				}
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir: " + e);
		} finally {
			try {
				this.conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Atendente buscarAtendente(String funcionario,String sql) {
		
		
            Atendente a1 = new Atendente();

            try {
                    this.conexao = postgreConection.getConnection();
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, funcionario);

                    ResultSet result = stmt.executeQuery();

                    if(result.next()) {

                            a1.setNome(result.getString("nome"));
                            a1.setTelefone(result.getString("telefone"));
                            a1.setEmail(result.getString("email"));
                            a1.setEndereco(result.getString("endereco"));
                            a1.setSalario(result.getDouble("salario"));
                            a1.setCpf(result.getString("cpf"));
                            a1.setIdade(result.getInt("idade"));
                            a1.setCargo(result.getString("cargo"));


                            return a1;
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
            return a1;
    }
    
    public Veterinario buscarVeterinario(String funcionario, String sql){
        
        Veterinario a1 = new Veterinario();
			
        try {
            this.conexao = postgreConection.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario);

            ResultSet result = stmt.executeQuery();

            if(result.next()) {

                    a1.setNome(result.getString("nome"));
                    a1.setTelefone(result.getString("telefone"));
                    a1.setEmail(result.getString("email"));
                    a1.setEndereco(result.getString("endereco"));
                    a1.setSalario(result.getDouble("salario"));
                    a1.setCpf(result.getString("cpf"));
                    a1.setIdade(result.getInt("idade"));
                    a1.setCargo(result.getString("cargo"));
                    a1.setConfea(result.getString("confea"));

                    return a1;
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
    return a1;
}
	
	public boolean removerFuncionario(String funcionario, String sql) {
		
            try {
                    this.conexao = postgreConection.getConnection();
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, funcionario);

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
	
	public boolean attInfo(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String sql) {
                           
                Atendente a = new Atendente(nome, telefone, email, endereco, salario, null, idade, null, null);
              
		try{
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, a.getNome());
                        stmt.setString(2, a.getTelefone());
                        stmt.setString(3, a.getEmail());
                        stmt.setString(4, a.getEndereco());
                        stmt.setDouble(5, a.getSalario());
                        stmt.setInt(6, a.getIdade());
			stmt.setString(7, cpf);
			
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
	
}
