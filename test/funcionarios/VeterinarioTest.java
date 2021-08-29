package funcionarios;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import controller.GerenteController;

public class VeterinarioTest {
	
	GerenteController gerenteController = new GerenteController();
	Random rand = new Random();
	
	//testando a classe Veterinario
	@Test
    public void instanciarVeterinario() {
        new Veterinario("Joana Maria", "98232451", "joana537@comercial.com", 
                "Rua Joao Martins", 2.500, "678.291.321-95", 25, "Atendente",  "joana123", "123455");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void instanciarVeterinarioComCpfNulo() {
        new Veterinario("Joana Maria", "98232451", "joana537@comercial.com", 
                "Rua Joao Martins", 2.500, "", 25, "Atendente",  "joana123", "123455");
    }
    
    //testando a função de cadastro
    @Test
    public void cadastrarVeterinario(){
    	gerenteController.addFuncionario("Pegg Nogueira", "983276374", "pegg87@vet.com", 
    			"Rua Domingos Santos", 6.760, "132.563.768-90", "Veterinario", "534-2325", 47, "pegg123");
    }
    
    //testando a função de busca
    @Test
    public void buscarVeterinario() {
    	Veterinario veterinario = gerenteController.buscarVeterinario("245.675.432-67");
    	Assert.assertEquals("245.675.432-67", veterinario.getCpf());
    }
    
    //testando a função de alteração
    @Test
    public void alterarVeterinario() {
    	double novoSalario = rand.nextDouble();
    	gerenteController.attInfo("Marcos Nunes", "912324435", 
    			"nunes_carlos44@vet.com", "Rua Pinheiro Branco", novoSalario, "245.675.432-67", 47, "Veterinario", "564-4345");
    }
    
    //testando a função de remoção
    @Test
    public void removerVeterinario(){
        gerenteController.removerFuncionario("132.563.768-90", 2);
    }
    
    
}
