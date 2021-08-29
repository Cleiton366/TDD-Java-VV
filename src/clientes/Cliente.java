package clientes;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	public String toString() {
		return "Nome: " + this.nome + "/n" +
			"CPF: " + this.cpf + "/n" +
			"E-mail: " + this.email + "/n" +
			"Telefone: " + this.telefone + "/n";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf, String email, String telefone) {
		super();               
                if(this.cpf == ""){
                    throw new IllegalArgumentException(
                            "CPF nao pode ser nulo");
                }
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	
}
