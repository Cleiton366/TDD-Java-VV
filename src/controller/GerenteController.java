package controller;

import conection.postgreConection;
import dao.GerenteDAO;
import funcionarios.Atendente;
import funcionarios.Veterinario;

public class GerenteController {

	postgreConection conection = new postgreConection();
	GerenteDAO gerenteDAO = new GerenteDAO(conection);
	
	public boolean addFuncionario(String nome, String telefone, String email, String endereco, double salario, String cpf, String cargo, String CONFEA, int idade, String senha) {
            
            String sql = null;
            
            if(CONFEA.equals("")){
                sql = "insert into atendente (senha, nome, telefone, email, endereco, salario, cpf, idade, cargo)values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            }else sql = "insert into veterinario (senha, nome, telefone, email, endereco, salario, cpf, idade, cargo, confea)values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            return gerenteDAO.addFuncionario(nome, telefone, email, endereco, salario, cpf, cargo, senha, CONFEA, idade, sql);
            	
	}
	
	public Veterinario buscarVeterinario(String funcionario) {
		
           String sql = "select * from veterinario where cpf = ?";
           return gerenteDAO.buscarVeterinario(funcionario, sql);
            
	}
        public Atendente buscarAtendente(String funcionario){
            
            String sql = "select * from atendente where cpf = ?";
            return gerenteDAO.buscarAtendente(funcionario, sql);  
        }
	
	public boolean removerFuncionario(String funcionario, int op) {
	
            String sql = null;
            if(op == 1){
                sql = "delete from atendente where cpf = ?";
            }else sql = "delete from veterinario where cpf = ?";
	
            return gerenteDAO.removerFuncionario(funcionario, sql);
	}
	
	public boolean attInfo(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String cargo, String CONFEA) {
		
            String sql = null;

             if(cargo.equals("Atendente")){
                sql = "update atendente set nome = ?, telefone = ?, email = ?, endereco = ?, salario = ?, idade = ? where cpf = ?";
            }else sql = "update veterinario set nome = ?, telefone = ?, email = ?, endereco = ?, salario = ?, idade = ? where cpf = ?";
                                
             return gerenteDAO.attInfo(nome, telefone, email, endereco, salario, cpf, idade, sql);	
	}
}
