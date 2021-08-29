package MockitoTests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;

import org.junit.*;
import dao.AtendenteDAO;
import org.mockito.*;

import conection.postgreConection;

import clientes.Cliente;


public class ClienteTest {
	
	@Mock
	private postgreConection connection = Mockito.mock(postgreConection.class);
	
	@Mock
	private Connection con = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet rs = Mockito.mock(ResultSet.class);
	
	@Mock
	private AtendenteDAO atendenteDAO = Mockito.mock(AtendenteDAO.class);
	
	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente("Ricardo de Souza", 
				"134.564.242-53", "973434231", "ricardo87@gmail.com");
		MockitoAnnotations.initMocks(this);
		Mockito.when(connection.getConnection()).thenReturn(con);
		Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.when(stmt.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getString(Mockito.anyInt())).thenReturn("1");
		Mockito.when(atendenteDAO.buscarCliente("1", ""))
		.thenReturn(cliente);
		
	}
	
	@Test
	public void cadastrarCliente() throws Exception {
		atendenteDAO.addCliente(Mockito.anyString(),
				Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void buscarCliente() throws Exception {
		Cliente cliente2 = atendenteDAO.buscarCliente("1", "");
		Assert.assertEquals("134.564.242-53", cliente2.getCpf());
	}
	
	@Test
	public void editarEmailCliente() throws Exception {
		atendenteDAO.attInfo(Mockito.anyString(), 
				Mockito.anyString(), "134.564.242-53");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void editarNomeCliente() throws Exception {
		atendenteDAO.attInfo(Mockito.anyString(), 
				Mockito.anyString(), "134.564.242-53");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void editarTelefoneCliente() throws Exception {
		atendenteDAO.attInfo(Mockito.anyString(), 
				Mockito.anyString(), "134.564.242-53");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
}
