package com.dens.j2ee.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleUtil {
	private static String user;
	private static String password;
	private static String url;
	private static String driverClassName;
	private static final ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	static {
		InputStream is = OracleUtil.class.getResourceAsStream("oracle.properties");
		try {
			Properties props = new Properties();
			props.load(is);
			System.out.println(props);
			user = props.getProperty("db.username");
			password = props.getProperty("db.password");
			url = props.getProperty("db.url");
			driverClassName = props.getProperty("db.driverClassName");
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static Connection getConnection() {
		Connection connection = tl.get();
		if (connection != null) {
			return connection;
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
			tl.set(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		Connection connection = tl.get();
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				tl.set(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
