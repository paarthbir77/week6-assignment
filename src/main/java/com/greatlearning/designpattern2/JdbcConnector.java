package com.greatlearning.designpattern2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {
	private static Connection con=null;
	static {
		String url = "jdbc:mysql://localhost:3306/assignment6";
		String user = "root";
		String pass="9871856190";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
}
