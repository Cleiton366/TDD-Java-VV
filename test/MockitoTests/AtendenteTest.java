package MockitoTests;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;

import org.junit.*;
import org.mockito.*;

import conection.postgreConection;
import dao.GerenteDAO;
import funcionarios.Atendente;

public class AtendenteTest {
	
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
		
		Atendente atendente = new Atendente("Joana Maria", "98232451", "joana537@comercial.com", 
                "Rua Joao Martins", 2.500, "678.291.321-95", 25, "Atendente",  "joana123");
		MockitoAnnotations.initMocks(this);
		Mockito.when(connection.getConnection()).thenReturn(con);
		Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(gerenteDAO.buscarAtendente("1", ""))
		.thenReturn(atendente);
		
	}
	
	@Test
	public void cadastrarAtendente() throws Exception {
		gerenteDAO.addFuncionario("Jose Carlos", 
				"952131445", "carlos_dc@comercial.com", 
    			"Rua São Caetano", 2.500, "345.678.124-55", 
    			"Atendente", "123", "", 42, "");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void buscarAtendente() throws Exception {
		Atendente atendente2 = gerenteDAO.buscarAtendente("1", "");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
		Assert.assertEquals("678.291.321-95", atendente2.getCpf());
	}
	
	@Test
	public void alterarAtendente() throws Exception {
		gerenteDAO.attInfo("Joana Maria", "98232451", 
    			"joana537@comercial.com", "Rua Joao Martins", 
    			1.0, "678.291.321-95", 26, "");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void removerAtendente() throws Exception {
		gerenteDAO.removerFuncionario(Mockito.anyString(), Mockito.anyString());
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
}
