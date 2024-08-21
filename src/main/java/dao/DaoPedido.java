package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entity.Pedido;
import entity.User;

public class DaoPedido {
	Connection connection = SingleConnection.getConnection();
	
	public List<Pedido> listPedidos() {
		String sql = "select * from pedidos_table";
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Long id = result.getLong("id");
				Long cliente_id = result.getLong("cliente_pedido_id");
				Long status_id = result.getLong("pedido_status");
				String name = result.getString("item");
				Double price = result.getDouble("valor");
				Integer quantity = result.getInt("quantidade");
				Pedido pedido = new Pedido(id, cliente_id, status_id, name, price, quantity);
				pedidos.add(pedido);
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	
	public Pedido getPedido(Long id) {
		String sql = "select * from pedidos_table where id = "+id;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				
				Long cliente_id = result.getLong("cliente_pedido_id");
				Long status_id = result.getLong("pedido_status");
				String name = result.getString("item");
				Double price = result.getDouble("valor");
				Integer quantity = result.getInt("quantidade");
				Pedido pedido = new Pedido(id, cliente_id, status_id, name, price, quantity);
				return pedido;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void insertPedido(Pedido pedido) {
		String sql = "insert into pedidos_table (item,cliente_pedido_id,pedido_status,valor,quantidade) values(?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pedido.getName());
			statement.setLong(2, pedido.getCliente_id());
			statement.setLong(3, pedido.getStatus_id());
			statement.setDouble(4 ,pedido.getPrice());
			statement.setInt(5, pedido.getQuantiy());
			statement.execute();
			statement.close();
			connection.commit();
			System.out.println("Pedido add");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/*public void insertUsers(List<String> users) {
		String sql = "insert into cliente(cliente_nome) values(?)";
		if(users.size() >1) {
			for(int i = 2; i <= users.size(); i++ ) {
				sql+= ",(?)";
			}
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			for(int i = 1;i<= users.size();i++) {
				statement.setString(i, users.get(i-1));
			}
			statement.execute();
			statement.close();
			connection.commit();
			
		}catch(Exception e) {
			try {
				connection.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		
		}
	}
	*/
	
	
	/*
	 * 
	 * 	Pode ser criado uma classe para instanciar
	 * 
	 * */
	public void updateUser(Long id,String name) {
		
		String sql = "update  cliente set cliente_nome = ? "+" where cliente_id = "+id;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.execute();
			statement.close();
			connection.commit();
			System.out.println("User update");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(Exception ex) {
				
				ex.printStackTrace();
			}
		}
		
	}
	
	public void deletePedido(Long id) {
		String sql = "delete from pedidos_table where id = "+id;
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			statement.close();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
