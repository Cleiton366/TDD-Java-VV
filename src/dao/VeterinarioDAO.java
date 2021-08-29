package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conection.postgreConection;
import java.sql.ResultSet;
import registro.Consulta;
import registro.Exame;

public class VeterinarioDAO {

	private Connection conexao;
	private postgreConection postgreConection;
	
	public VeterinarioDAO(postgreConection a) {
		this.postgreConection = a;
	}
	
	public boolean addExame(String nomeCliente, String especieAnimal, String nomeExame, double valor, String data, String hora, String idExame) {
		
		String sql = "insert into exame(nomeExame, nomeCliente, especie, valor, horario, data, idExame) values(?, ?, ?, ?, ?, ?, ?)";
		
                Exame a = new Exame(nomeExame, nomeCliente, especieAnimal, valor, hora, data, idExame);
                
		try {
			this.conexao = postgreConection.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, a.getNomeExame());
			stmt.setString(2, a.getNomeCliente());
			stmt.setString(3, a.getEspecie());
			stmt.setDouble(4, a.getValor());
			stmt.setString(5, a.getHorario());
			stmt.setString(6, a.getData());
                        stmt.setString(7, a.getIdExame());
		
			
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
        
        public Consulta buscarConsulta(String idConsulta){
            
            String sql = "select * from consulta where idconsulta = ?";
            
            Consulta a = new Consulta();
            
                try {
                    this.conexao = postgreConection.getConnection();
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, idConsulta);

                    ResultSet rs = stmt.executeQuery();
                    if(rs.next()) {
                            a.setNomeCliente(rs.getString("nomecliente"));
                            a.setEspecie(rs.getString("especie"));
                            a.setHorario(rs.getString("horario"));
                            a.setData(rs.getString("data"));
                            a.setIdConsulta(rs.getString("idconsulta"));
                            
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
	
        public Exame buscarExame(String nomeCliente){
            
            String sql = "select * from exame where idexame = ?";
            
            Exame a = new Exame();
            
                try {
                    this.conexao = postgreConection.getConnection();
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, nomeCliente);

                    ResultSet rs = stmt.executeQuery();
                    if(rs.next()) {
                            a.setNomeCliente(rs.getString("nomeCliente"));
                            a.setNomeExame(rs.getString("nomeExame"));
                            a.setEspecie(rs.getString("especie"));
                            a.setValor(rs.getDouble("valor"));
                            a.setHorario(rs.getString("horario"));
                            a.setData(rs.getString("data"));
                            a.setIdExame(rs.getString("idexame"));
                            
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
}
