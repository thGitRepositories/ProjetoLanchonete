package ProjetoLanchonete.com;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.SingleConnection;
import dao.DaoPedido;
import dao.DaoStatus;
import dao.DaoUser;
import entity.Pedido;
import entity.Status;
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
		Long id = 11L;
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
	public void insertUsers() {
		DaoUser dao = new DaoUser();
		List<String> usuarios = new ArrayList<String>();
	        usuarios.add("Thais");
	        usuarios.add("Thalita");
	        usuarios.add("Thomaz");
	        usuarios.add("Thales");
	        usuarios.add("Theodoro");
	        usuarios.add("Thaisla");
	        usuarios.add("Thalisson");
	        usuarios.add("Thor");
	        
	   dao.insertUsers(usuarios);
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
	
	
	@org.junit.Test
	public void listStatus() {
		DaoStatus dao = new DaoStatus();
		List<Status> status = dao.listStatus();
		for(Status status_unity: status) {
			System.out.println(status_unity);
		}
		
	}
	
	@org.junit.Test
	public void getStatus() {
		DaoStatus dao = new DaoStatus();
		Status status = dao.getStatus(1L);
		System.out.println(status);
		
	}
	
	@org.junit.Test
	public void getPedidos() {
		DaoPedido dao = new DaoPedido();
		List<Pedido> pedios = dao.listPedidos();
		for(Pedido pdUser: pedios) {
			System.out.println(pdUser);
		}
	}
	
	@org.junit.Test
	public void getPedido() {
		DaoPedido dao = new DaoPedido();
		Pedido pedido = dao.getPedido(2l);
		System.out.println(pedido);
	}
	
	@org.junit.Test
	public void insertPedido() {
		DaoPedido dao = new DaoPedido();
		String item = "Batata (400G)";
		Long cliente_id = 1L;
		Long status_id = 1L;
		Double price = 40.95;
		Integer quantity = 1;
		
		Pedido pedido = new Pedido();
		pedido.setCliente_id(cliente_id);
		pedido.setName(item);
		pedido.setPrice(price);
		pedido.setQuantiy(quantity);
		pedido.setStatus_id(status_id);
		dao.insertPedido(pedido);
	}
	
	@org.junit.Test
	public void updatePedido() {
		DaoPedido dao = new DaoPedido();
		Pedido pedido = dao.getPedido(2L);
		pedido.setName("X-TUDO COM BATATA FRITA");
		pedido.setPrice(55.75);
		pedido.setQuantiy(1);
		dao.updatePedido(2L, pedido);
	}
	
	@org.junit.Test
	public void deletarPedido() {
		DaoPedido dao = new DaoPedido();
		dao.deletePedido(9L);
	}
}


