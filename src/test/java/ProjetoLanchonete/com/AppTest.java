package ProjetoLanchonete.com;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import connection.SingleConnection;
import dao.DaoUser;
import entity.User;
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
		List<User> users = dao.listUser();
		for(User user: users) {
			System.out.println("----------------------------");
			System.out.println(user);
			
		}
		
		
	}
	
	@org.junit.Test
	public void getUser() {
		DaoUser dao = new DaoUser();
		Long id = 2L;
		User user = dao.getUser(id);
		System.out.println(user);
	}
	
	@org.junit.Test
	public void insertUser() {
		DaoUser dao = new DaoUser();
		String name = JOptionPane.showInputDialog("Digite o nome");
		dao.insertUser(name);
	}
	
	@org.junit.Test
	public void updateUser() {
		DaoUser dao = new DaoUser();
		Long id = Long.parseLong(JOptionPane.showInputDialog("Digite o id a ser alterado: "));
		String name = JOptionPane.showInputDialog("Digite o nome");
		dao.updateUser(id, name);
		
	}
	
	@org.junit.Test
	public void deleteUser() {
		DaoUser dao = new DaoUser();
		Long id = Long.parseLong(JOptionPane.showInputDialog("Digite o id"));
		dao.deleteUser(id);
		
	}
}


