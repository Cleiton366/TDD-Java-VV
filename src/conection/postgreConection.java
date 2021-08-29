package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class postgreConection {

	private final String ip = "localhost";
	private final Integer port = 5555;
	private final String user = "postgres";
	private final String password = "123";
	private final String database = "projeto-vv";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
