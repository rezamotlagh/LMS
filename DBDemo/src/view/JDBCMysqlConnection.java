package view;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
public class JDBCMysqlConnection {
	
	private static JDBCMysqlConnection instance = new JDBCMysqlConnection();
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	
	
	public static final String URL = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
	//public static final String URL = "jdbc:mysql://localhost/library";

	public static final String USER = "root";
	public static final String PASSWORD = "hamRagh5";
	
	
	private JDBCMysqlConnection() {
		try {
			//Step 2: Load MySQL Java driver
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {

		Connection connection = null;
		try {
			//Step 3: Establish Java MySQL connection
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}	
	
	public static Connection getConnection() {
		return instance.createConnection();
	}

}
