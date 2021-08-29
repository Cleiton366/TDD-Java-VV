package funcionarios;

public class Veterinario extends Funcionario {
	
	private String confea;

	public String getConfea() {
		return confea;
	}

	public void setConfea(String confea) {
		this.confea = confea;
	}

	public Veterinario() {}
	
	public Veterinario(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String cargo, String senha, String confea) {
		super(nome, telefone, email, endereco, salario, cpf, idade, cargo, senha);
		if(this.cpf == ""){
            throw new IllegalArgumentException(
                    "CPF nao pode ser nulo");
        }
		this.confea = confea;
		
	}

	@Override
	public String toString() {
		return "veterinario [confea=" + confea + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", salario=" + salario + ", cpf=" + cpf + ", idade=" + idade + ", cargo="
				+ cargo + "]";
	}
	
	
	
	
}
