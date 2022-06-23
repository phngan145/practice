package com.kits.ngan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
	private static Connection conn;
	
	public static Connection getPreparedConnection() {
		if(conn==null) {
			String url = "jdbc:mysql://localhost:3306/blog";
			String user = "root";
			String password = "";
			conn = getConnection(url, user, password);
		}
		return conn;
	}

	public static Connection getConnection(String url, String username, String pass) {		
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, pass);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}