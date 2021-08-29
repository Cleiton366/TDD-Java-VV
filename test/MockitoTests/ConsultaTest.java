package MockitoTests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import conection.postgreConection;
import dao.AtendenteDAO;
import dao.VeterinarioDAO;
import registro.Consulta;

public class ConsultaTest {
	
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
	
	@Mock
	private VeterinarioDAO veterinarioDAO = Mockito.mock(VeterinarioDAO.class);
	
	@Before
	public void setUp() throws Exception {
		Consulta consulta = new Consulta("Carlos Nogueira", 
				"Cachorro", "15:30", "20/11/21", "423234");
		MockitoAnnotations.initMocks(this);
		Mockito.when(connection.getConnection()).thenReturn(con);
		Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(veterinarioDAO.buscarConsulta("1")).thenReturn(consulta);
		
	}
	
	@Test
	public void cadastrarConsulta() throws Exception {
		atendenteDAO.cadastrarConsulta("Carlos Nogueira", 
				"Cachorro", "15:30", "20/11/21", "423234");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
		
	}
	
	@Test
	public void buscarConsulta() throws Exception {
		Consulta consulta2 = veterinarioDAO.buscarConsulta("1");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
		Assert.assertEquals("423234", consulta2.getIdConsulta());
	}
}
