package com.greatlearning.designpattern2;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.greatlearning.designpattern1.*;


public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	int in, accountNo, balance;
    	String branch, type;
    	JdbcConnector connector = new JdbcConnector();
    	Connection con = connector.getConnection();
    	
    	BankAccountDAO bankAccountDAO = new BankAccountDAO();
    	Statement stmt = con.createStatement();
    	
    	do {
        	Scanner input = new Scanner(System.in);
        	in = input.nextInt();
        	switch(in) {
        	
        	case 1: 
        		System.out.println("For Registration enter ");
        		Scanner registerInput = new Scanner(System.in);
        		System.out.print("accountNo: ");
        		accountNo = registerInput.nextInt();
        		registerInput.nextLine();
        		
        		System.out.print("balance: ");
        		balance = registerInput.nextInt();
        		registerInput.nextLine();
        		
        		System.out.print("branch: ");
        		branch = registerInput.nextLine();
        		System.out.print("type: ");
        		type = registerInput.nextLine();
        		bankAccountDAO.saveData(con, accountNo, balance, branch, type);
        		break;
        		
        	case 2: 
        		System.out.println("For updation enter accountNo, balance, branch, type");
        		Scanner updateInput = new Scanner(System.in);
        		accountNo = updateInput.nextInt();
        		updateInput.nextLine();
        		balance = updateInput.nextInt();
        		updateInput.nextLine();
        		branch = updateInput.nextLine();
        		type = updateInput.nextLine();
        		bankAccountDAO.updateUser(con, stmt, accountNo, balance, branch, type);
        		break;
        	case 3: bankAccountDAO.getAllUsers(stmt);
        		break;
        	case 4: 
        		System.out.println("For deletion enter userId");
        		Scanner deleteInput = new Scanner(System.in);
        		accountNo = deleteInput.nextInt();
        		deleteInput.nextLine();
        		bankAccountDAO.deleteUser(con, stmt, accountNo);
        		break;
        	}
        }while(in>0);
    
    }
}
