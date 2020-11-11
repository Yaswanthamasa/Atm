package Atm;

import java.util.Date;

public class Transaction {
//Attributes of Transaction
	private Date date;
	private char type;
	private double amount;
	private double Balance;
	private String description;
	//constructor
	public Transaction(Date date,char type,double amount,double balance, String description) {
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.Balance = balance;
		this.description = description;
	}
	//setter and getter method
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public double getBalance() {
		return Balance;
	}
	public void setbalance(double balance) {
		this.Balance= balance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//Method to return transaction object as string type
	public String toString() {
		return "ON " + this.date + "\tType: " + this.type + "\tAmount " + this.amount + description + "\nAvailable balance: " + this.Balance;
	}
}