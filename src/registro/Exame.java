package registro;

public class Exame {
	
	private String nomeExame;
	private String nomeCliente;
	private String especie;
	private double valor;
	private String horario;
	private String data;
        private String idExame;

        
        public String getIdExame() {
            return idExame;
        }
        public void setIdExame(String idExame) {
            this.idExame = idExame;
        }
	public String getNomeExame() {
		return nomeExame;
	}
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Exame() {
		
	}
	
	public Exame(String nomeExame, String nomeCliente, String especie, double valor, String horario, String data, String idExame) {
		if(idExame == ""){
			throw new IllegalArgumentException(
					"ID nao pode ser nulo");
		}
		this.nomeExame = nomeExame;
		this.nomeCliente = nomeCliente;
		this.especie = especie;
		this.valor = valor;
		this.horario = horario;
		this.data = data;
                this.idExame = idExame;
	}
	
	@Override
	public String toString() {
		return "Exame [nomeExame=" + nomeExame + ", nomeCliente=" + nomeCliente + ", especie=" + especie + ", valor="
				+ valor + ", horario=" + horario + ", data=" + data + "]";
	}
	
	
	
	
}
