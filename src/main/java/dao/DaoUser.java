package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoUser {
	private static Connection connection = SingleConnection.getConnection();
	
	public void listUser() {
		String sql = "select * from cliente";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Long id = result.getLong("cliente_id");
				String name = result.getString("cliente_nome");
				System.out.println("Nome: "+name+"\n"+"Id: "+id);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
