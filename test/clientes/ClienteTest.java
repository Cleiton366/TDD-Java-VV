package clientes;

import org.junit.Test;

import controller.AtendenteController;

public class ClienteTest {
	
	AtendenteController atendenteController = new AtendenteController();
	
	@Test
	public void cadastrarCliente() {
		atendenteController.cadastrarCliente("Ricardo de Souza", "134.564.242-53", "973434231", "ricardo87@gmail.com");
	}
	
	@Test
	public void buscarCliente() {
		atendenteController.buscarCliente("134.564.242-53");
	}
	
	@Test
	public void editarEmailCliente() {
		atendenteController.attEmail("134.564.242-53", "ricardo875@hotmail.com");
	}
	
	@Test
	public void editarNomeCliente() {
		atendenteController.attNome("134.564.242-53", "Ricardo de Souza Martins");
	}
	
	@Test
	public void editarTelefoneCliente() {
		atendenteController.attTelefone("134.564.242-53", "95439824");
	}
}
