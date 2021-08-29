package MockitoTests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import conection.postgreConection;
import dao.VeterinarioDAO;
import registro.Exame;
import org.junit.*;


public class ExameTest {
	
	@Mock
	private postgreConection connection = Mockito.mock(postgreConection.class);
	
	@Mock
	private Connection con = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet rs = Mockito.mock(ResultSet.class);
	
	@Mock
	VeterinarioDAO veterinarioDAO = Mockito.mock(VeterinarioDAO.class);
	
	@Before
	public void setUp() throws Exception {
		Exame exame = new Exame("Carlos Nogueira", "Cachorro", 
				"Check-up", 300, "13/08/21", "16:30", "435");
		MockitoAnnotations.initMocks(this);
		Mockito.when(connection.getConnection()).thenReturn(con);
		Mockito.when(con.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(veterinarioDAO.buscarExame("1")).thenReturn(exame);
		
	}
	
	@Test
	public void cadastrarExame() throws Exception {
		veterinarioDAO.addExame("Carlos Nogueira", "Cachorro", 
				"Check-up", 300, "13/08/21", "16:30", "435");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void buscarExame() throws Exception {
		Exame exame2 = veterinarioDAO.buscarExame("1");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
		Assert.assertEquals("435", exame2.getIdExame());
	}
}
