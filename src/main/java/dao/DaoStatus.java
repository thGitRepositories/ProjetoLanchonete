package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entity.Status;
import entity.User;

public class DaoStatus {
private static Connection connection = SingleConnection.getConnection();
	
	public List<Status> listStatus() {
		String sql = "select * from status";
		List<Status> status = new ArrayList<Status>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				
				String name = result.getString("status_name");
				Status status_unity = new Status(name);
				status.add(status_unity);
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public Status getStatus(Long id) {
		String sql = "select * from status where status_id = "+id;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				String name = result.getString("status_name");
				Status status = new Status(name);
				statement.close();
				return status;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void insertUser(String name) {
		String sql = "insert into cliente(cliente_nome) values(?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.execute();
			statement.close();
			connection.commit();
			System.out.println("User add");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void insertUsers(List<String> users) {
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
	
	public void deleteUser(Long id) {
		String sql = "delete from cliente where cliente_id = "+id;
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
