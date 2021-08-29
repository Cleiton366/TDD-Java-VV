/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;


import controller.GerenteController;
import org.junit.Test;

import java.util.Random;

import org.junit.Assert;


public class AtendenteTest {
    
    GerenteController gerenteController = new GerenteController();
    Random rand = new Random();

    //testando a classe Atendente
    @Test
    public void instanciarAtendente() {
        new Atendente("Joana Maria", "98232451", "joana537@comercial.com", 
                "Rua Joao Martins", 2.500, "678.291.321-95", 25, "Atendente",  "joana123");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void instanciarAtendenteComCpfNulo() {
        new Atendente("Joana Maria", "98232451", "joana537@comercial.com", 
                "Rua Joao Martins", 2.500, "", 25, "Atendente",  "joana123");
    }
    
    //testando a função de cadastro
    @Test
    public void cadastrarAtendente(){
    	gerenteController.addFuncionario("Jose Carlos", "952131445", "carlos_dc@comercial.com", 
    			"Rua São Caetano", 2.500, "345.678.124-55", "Atendente", "", 42, "carlos123");
    }

    //testando a função de busca
    @Test
    public void buscarAtendente() {
    	Atendente atendente = gerenteController.buscarAtendente("678.291.321-95");
    	Assert.assertEquals("678.291.321-95", atendente.getCpf());
    }
    
    //testando a função de alteração
    @Test
    public void alterarAtendente() {
    	double novoSalario = rand.nextDouble();
    	gerenteController.attInfo("Joana Maria", "98232451", 
    			"joana537@comercial.com", "Rua Joao Martins", 
    			novoSalario, "678.291.321-95", 26, "Atendente", "");
    }
    
    //testando a função de remoção
    @Test
    public void removerAtendente(){
        gerenteController.removerFuncionario("345.678.124-55", 1);
    }
    
}
