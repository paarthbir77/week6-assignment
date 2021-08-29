package com.greatlearning.designpattern1;

public class BankAccount{
	private int accountNo;
	private int balance;
	private String branch;
	private String type;
	//Optional params
	private int emiSchedule;
	private int atmTransactions;
	
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getAccountNo() {
		return this.accountNo;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return this.balance;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranch() {
		return this.branch;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	//Setter-Getter for optional params
	public void setEmiSchedule(int emi) {
		this.emiSchedule = emi;
	}
	public int getEmiSchedule() {
		return this.emiSchedule;
	}
	public void setAtmTransactions(int atmTransactions) {
		this.atmTransactions = atmTransactions;
	}
	public int getAtmTransactions() {
		return this.atmTransactions;
	}
	public static class AccountBuilder{
		private int accountNo;
		private int balance;
		private String branch;
		private String type;
		
		//Optional params
		private int emiSchedule;
		private int atmTransactions;
		
		public AccountBuilder(int accountNo, int balance, String branch, String type) {
			this.accountNo = accountNo;
			this.balance = balance;
			this.branch = branch;
			this.type = type;
		}
		
		public AccountBuilder setEmiSchedule(int emi) {
			this.emiSchedule = emi;
			return this;
		}
		public AccountBuilder setAtmTransactions(int atmTransactions) {
			this.atmTransactions = atmTransactions;
			return this;
		}
		
		public BankAccount build() {
			return new BankAccount(this);
		}
	}
	public BankAccount(AccountBuilder accountBuilder) {
		this.accountNo = accountBuilder.accountNo;
		this.balance = accountBuilder.balance;
		this.branch = accountBuilder.branch;
		this.type = accountBuilder.type;
		
		this.atmTransactions = accountBuilder.atmTransactions;
		this.emiSchedule = accountBuilder.emiSchedule;
	}
	@Override
	public String toString() {
		return "Account [accountNo = "+this.accountNo+" balance = "+this.balance+" branch = "+ this.branch+" type = "+this.type+" ATM Transactions = "+this.atmTransactions+" EMI Schedule = "+this.emiSchedule+"]";
	}
}
