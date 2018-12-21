package org.formation.zoo.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoJDBC<T> implements Dao<T>{
	private Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3306/zoo", USER="root", PASSWORD= "";
	
	public DaoJDBC() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
