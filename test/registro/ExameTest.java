package registro;

import org.junit.Assert;
import org.junit.Test;

import controller.VeterinarioController;

public class ExameTest {
	
	VeterinarioController veterinarioController = new VeterinarioController();
	
	@Test
	public void cadastrarExame() {
		veterinarioController.cadastrarExame("Carlos Nogueira", "Cachorro", "Check-up", 300, "13/08/21", "16:30", "435");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarConsultaComIdNulo() {
		new Exame("Carlos Nogueira", "Cachorro", "Check-up", 300, "13/08/21", "16:30", "");
	}
	
	@Test
	public void buscarExame() {
		Exame exame = veterinarioController.buscarExame("435");
		Assert.assertEquals("435", exame.getIdExame());
	}
}
