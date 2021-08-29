package com.greatlearning.designpattern1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.greatlearning.designpattern1.BankAccount;

public class BankAccountDAO {
	
	public void saveData(Connection con, int accountNo, int balance, String branch, String type) throws SQLException {
		if(con!=null && !con.isClosed()) {
			String str = "insert into accounts (accountNo, balance, branch, type) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(str);
			preparedStatement.setInt(1, accountNo);
			preparedStatement.setInt(2, balance);
			preparedStatement.setString(3, branch);
			preparedStatement.setString(4, type);
			int row = preparedStatement.executeUpdate();
		}
	}
//	public void saveData(Connection con, BankAccount bankAccount) throws SQLException {
//		if(con!=null && !con.isClosed()) {
//			String str = "insert into accounts (accountNo, balance, branch, type) values (?, ?, ?, ?)";
//			PreparedStatement preparedStatement = con.prepareStatement(str);
//			preparedStatement.setInt(1, bankAccount.getAccountNo());
//			preparedStatement.setInt(2, bankAccount.getBalance());
//			preparedStatement.setString(3, bankAccount.getBranch());
//			preparedStatement.setString(4, bankAccount.getType());
//			int row = preparedStatement.executeUpdate();
//		}
//	}
	
	public void deleteUser(Connection con, Statement stmt, int accountNo) throws SQLException {
		if (con != null && !con.isClosed()) {
			String sql = "delete from accounts where accountNo=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, accountNo);
			int counter = statement.executeUpdate();
			System.out.println("The delete recorded:- " + counter);
		}	
	}
	public void updateUser(Connection con, Statement stmt, int accountNo, int balance,String branch,String type) throws SQLException {
		if (con != null && !con.isClosed()) {
			String sql = "UPDATE accounts SET balance=?, branch=?, type=? where accountNo=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, balance);
			statement.setString(2, branch);
			statement.setString(3, type);
			statement.setInt(4, accountNo);
			System.out.println(statement);
			int counter = statement.executeUpdate();
			System.out.println("Update performed");
		}
	}
//	public void updateUser(Connection con, Statement stmt, BankAccount bankAccount) throws SQLException {
//		if (con != null && !con.isClosed()) {
//			String sql = "UPDATE accounts SET balance=?, branch=?, type=? where accountNo=?";
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setInt(1, bankAccount.getBalance());
//			statement.setString(2, bankAccount.getBranch());
//			statement.setString(3, bankAccount.getType());
//			statement.setInt(4, bankAccount.getAccountNo());
//			System.out.println(statement);
//			int counter = statement.executeUpdate();
//			System.out.println("Update performed");
//		}
//	}
	public void getAllUsers(Statement stmt) throws SQLException {
		String str = "select accountNo,balance,branch,type from accounts";
		ResultSet rs = stmt.executeQuery(str);
		int rowCounter = 0;
		while (rs.next()) {
			int accountNo = rs.getInt("accountNo");
			int balance = rs.getInt("balance");
			String branch = rs.getString("branch");
			String type = rs.getString("type");
			System.out.println("The Data =");
			System.out.println("accountNo = " + accountNo);
			System.out.println("balance = " + balance);
			System.out.println("branch = " + branch);
			System.out.println("type = " + type);
			++rowCounter;
		}
		System.out.println("Count of records: " + rowCounter);
	}
}
