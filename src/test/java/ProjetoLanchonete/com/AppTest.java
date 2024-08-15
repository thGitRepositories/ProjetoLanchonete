package ProjetoLanchonete.com;

import java.sql.Connection;
import java.util.List;

import connection.SingleConnection;
import dao.DaoUser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@org.junit.Test
	public void connectar() {
		Connection connection = SingleConnection.getConnection();
	}
	
	@org.junit.Test
	public void listUsers() {
		DaoUser dao = new DaoUser();
		
		dao.listUser();
	}

}


