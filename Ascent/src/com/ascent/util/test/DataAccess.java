package com.ascent.util.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataAccess {
	private static Properties prop = null;
	static {
		InputStream in = DataAccess.class.getClassLoader().getResourceAsStream("database.conf.properties");
		prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("user"), prop.getProperty("password"));
	}
}
