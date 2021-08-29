package funcionarios;

public class Atendente extends Funcionario{
	
	
	public Atendente() {}

	public Atendente(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String cargo, String senha) {
		super(nome, telefone, email, endereco, salario, cpf, idade, cargo, senha);
		if(this.cpf == ""){
            throw new IllegalArgumentException(
                    "CPF nao pode ser nulo");
        }
	}
	
	@Override
	public String toString() {
		return "atendente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", salario=" + salario + ", cpf=" + cpf + ", idade=" + idade + ", cargo=" + cargo + "]";
	}
	
	
}
