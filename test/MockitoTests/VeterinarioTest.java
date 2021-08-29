package MockitoTests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;

import org.junit.*;
import org.mockito.*;

import conection.postgreConection;
import dao.GerenteDAO;
import funcionarios.Veterinario;

public class VeterinarioTest {
	
	@Mock
	private postgreConection connection = Mockito.mock(postgreConection.class);
	
	@Mock
	private Connection con = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet rs = Mockito.mock(ResultSet.class);
	
	@Mock
	GerenteDAO gerenteDAO = Mockito.mock(GerenteDAO.class);
	
	@Before
	public void setUp() throws Exception {

		Veterinario veterinario = new Veterinario("Pegg Nogueira", "983276374", "pegg87@vet.com", 
    			"Rua Domingos Santos", 6.760, "132.563.768-90", 56, "Veterinario", "5123", "534-2325");
		MockitoAnnotations.initMocks(this);
		Mockito.when(connection.getConnection()).thenReturn(con);
		Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.when(stmt.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getString(Mockito.anyInt())).thenReturn("1");
		Mockito.when(gerenteDAO.buscarVeterinario("1", "1"))
		.thenReturn(veterinario);
		
	}
	
	@Test
	public void cadastrarVeterinario() throws Exception {
		gerenteDAO.addFuncionario("Jose Carlos", 
				"952131445", "carlos_dc@comercial.com", 
    			"Rua São Caetano", 2.500, "345.678.124-55", 
    			"Atendente", "123", "", 42, "");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void buscarVeterinario() throws Exception {
		Veterinario vet = gerenteDAO.buscarVeterinario("1", "");
		Assert.assertEquals("132.563.768-90", vet.getCpf());
	}
	
	@Test
	public void alterarVeterinario() throws Exception {
		gerenteDAO.attInfo("Joana Maria", "98232451", 
    			"joana537@comercial.com", "Rua Joao Martins", 
    			1.0, "678.291.321-95", 26, "");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void removerVeterinario() throws Exception {
		gerenteDAO.removerFuncionario(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
}
