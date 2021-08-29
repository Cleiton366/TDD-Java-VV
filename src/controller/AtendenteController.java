package controller;

import clientes.Cliente;
import conection.postgreConection;
import dao.AtendenteDAO;
import registro.Consulta;

public class AtendenteController {

	postgreConection conection = new postgreConection();
	AtendenteDAO atendenteDAO = new AtendenteDAO(conection);
	
	
	public boolean cadastrarCliente(String nome, String cpf, String telefone, String email) {
			
            return atendenteDAO.addCliente(nome, cpf, telefone, email);
	}
	
	public Cliente buscarCliente(String cliente) {
		
            String sql = "select * from cliente where cpf = ?";
            
            return atendenteDAO.buscarCliente(cliente, sql);
	}
	
	public boolean removerCliente(int op, String id) {
		
		String sql = null;
		String cliente = null;
			
		switch(op) {
		
		case 1:
			sql = "delete from cliente where nome = ?";
			cliente = id;
			break;
		case 2:
			sql = "delete from cliente where cpf = ?";
			cliente = id;
			break;
		}
		
		return atendenteDAO.removerCliente(cliente, sql);	
		
	}
	
	
	public boolean cadastrarConsulta(String nomeCliente, String especie, String horario, String data, String idConsulta) {
		return atendenteDAO.cadastrarConsulta(nomeCliente, especie, horario, data, idConsulta);
		
	}
	
        public boolean attNome(String cpf, String novoNome){
            
            String sql = "update cliente set nome = ? where cpf = ?";
            
            return atendenteDAO.attInfo(sql, novoNome, cpf);
            
        }
        
        public boolean attTelefone(String cpf, String novoTelefone){
        
        String sql = "update cliente set telefone = ? where cpf = ?";
        return atendenteDAO.attInfo(sql, novoTelefone, cpf);
        
       }
        
       public boolean attEmail(String cpf, String novoEmail){
            
        String sql = "update cliente set email = ? where cpf = ?";
        return atendenteDAO.attInfo(sql, novoEmail, cpf);
        
       }
}
