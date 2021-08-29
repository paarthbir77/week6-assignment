package com.greatlearning.designpattern1;

public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount.AccountBuilder(1, 1000, "delhi", "savings").setEmiSchedule(5).build();
    	System.out.println(bankAccount.toString());

	}

}
