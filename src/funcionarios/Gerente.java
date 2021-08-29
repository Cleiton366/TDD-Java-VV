package funcionarios;


public class Gerente extends Funcionario{
	
	
	public Gerente(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String cargo, String senha) {
		super(nome, telefone, email, endereco, salario, cpf, idade, cargo, senha);
		if(this.cpf == ""){
            throw new IllegalArgumentException(
                    "CPF nao pode ser nulo");
        }
	}
	
	public Gerente() {}
	
	@Override
	public String toString() {
		return "gerente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", salario=" + salario + ", cpf=" + cpf + ", idade=" + idade + ", cargo=" + cargo + "]";
	}

	
}
