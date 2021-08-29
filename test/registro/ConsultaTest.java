package registro;

import org.junit.Assert;
import org.junit.Test;

import controller.AtendenteController;
import controller.VeterinarioController;

public class ConsultaTest {
	
	AtendenteController atendenteController = new AtendenteController();
	VeterinarioController veterinarioController = new VeterinarioController();
	
	@Test
	public void cadastrarConsulta() {
		atendenteController.cadastrarConsulta("Carlos Nogueira", 
				"Cachorro", "15:30", "20/11/21", "423234");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarConsultaComIdNulo() {
		new Consulta("Carlos Nogueira", "Cachorro", "15:30", "20/11/21", "");
	}
	
	@Test
	public void buscarConsulta() {
		Consulta consulta = veterinarioController.buscarConsulta("423234");
		Assert.assertEquals("423234", consulta.getIdConsulta());
	}
	
	
}
