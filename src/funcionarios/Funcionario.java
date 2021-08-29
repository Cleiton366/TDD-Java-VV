package funcionarios;

public abstract  class Funcionario {
	
	protected String nome;
	protected String telefone;
	protected String email;
	protected String endereco;
	protected double salario;
	protected String cpf;
	protected int idade;
	protected String cargo;
    protected String senha;

    public String getSenha() {
    	return senha;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Funcionario() {}
	
	public Funcionario(String nome, String telefone, String email, String endereco, double salario, String cpf, int idade, String cargo, String senha) {
		
                if(this.cpf == ""){
                    throw new IllegalArgumentException(
                            "CPF nao pode ser nulo");
                }
            
                this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
		this.cpf = cpf;
		this.idade = idade;
		this.cargo = cargo;
                this.senha = senha;
	}
	
	public String toString() {
		return "funcionario [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", salario=" + salario + ", cpf=" + cpf + ", idade=" + idade + ", cargo=" + cargo + "]";
	}
        
        
	
}
