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
				Long id_status = result.getLong("status_id");
				Status status_unity = new Status(name,id_status);
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
				Long id_status = result.getLong("status_id");
				Status status = new Status(name,id_status);
				statement.close();
				return status;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	
	public void deleteUser(Long id) {
		String sql = "delete from cliente where status_id = "+id;
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
