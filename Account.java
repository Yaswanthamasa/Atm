package Atm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
class Account {
	 private int AccountNumber;
	 private String name;
     private int Pin;
     private String phonenumber;
     private double Balance;
     private Date dateCreated;
     private ArrayList<Transaction> transactions;
     private admin cashDispenser; // reference to cash dispenser
  // Constructor
public Account(int AccountNumber, String name, int Pin, String phonenumber, double Balance){
	this.AccountNumber = AccountNumber;
	this.name = name;
    this.Pin = Pin;
    this.phonenumber = phonenumber;
    this.Balance = Balance;
    this.dateCreated = new Date();
    this.transactions = new ArrayList<Transaction>();
}
//Default constructor to create account
public Account() {
	this.AccountNumber = 1;
	this.name = "Unknown";
    this.Pin = 1;
    this.phonenumber = "Unknown";
    this.Balance = 0;
    this.dateCreated = new Date();
    this.transactions = new ArrayList<Transaction>();
}
// constructor to create Account with Account number, pin, phone number and balance
public Account(int AccountNumber, int Pin, String phonenumber, double Balance) {
	this.AccountNumber = AccountNumber;
    this.Pin = Pin;
    this.phonenumber = "";
    this.Balance = Balance;
    this.name = "Unknown";
    this.dateCreated = new Date();
    this.transactions = new ArrayList<Transaction>();
}

 	// Getter and Setter methods
 	public int getAccountNumber() {
 		return AccountNumber;
 	}
 	public void setAccountNumber(int accountNumber) {
 		AccountNumber = accountNumber;
 	}
 	public String getName() {
 		return name;
 	}
 	public void setName(String name) {
 		this.name = name;
 	}
 	public int getPin() {
 		return Pin;
 	}
 	public void setPin(int Pin) {
 		this.Pin = Pin;
 	}
 	public String getPhonenumber(){
		return phonenumber;
	}
	public void setPhone(String phonenumber){
		if(phonenumber != null)
		this.phonenumber = phonenumber;
	}
 	public double getBalance() {
 		return Balance;
 	}
 	public void setBalance(double balance) {
 		Balance = balance;
 	}
 	public Date getDateCreated() {
 		return dateCreated;
 	}
 	public void setDateCreated(Date dateCreated) {
 		this.dateCreated = dateCreated;
 	}
 	public ArrayList<Transaction>getTransactions() {
 		return transactions;
 	}
 	public void setTransactions(ArrayList<Transaction> transactions) {
 		this.transactions = transactions;
 	}
 	//method to withdraw amount
 	public boolean withdraw(double amount) {
 		if(this.Balance < amount) {
 			return false;
 		}else {
 			this.Balance = this.Balance - amount;
 			transactions.add(new Transaction(new Date(), 'W', amount, this.Balance, " Withdrawn"));
 		}
		return true;
 	}
		
 	//method to deposit amount
 	 	public void deposit(double amount) {
 	 			this.Balance = this.Balance + amount;
 	 			System.out.println("Amount deposited: " + amount);
 	 			transactions.add(new Transaction(new Date(), 'D', amount, this.Balance, " Deposited"));
 	 		}
 	
 
		public void transfer(double amount, Account to) { //here is the transfer method
 	        if(this.Balance >= amount){
 	            this.Balance -= amount;
 	            to.Balance += amount;
 	            System.out.println("Funds successfully transfered.");
 	        } else {
 	                System.out.println("Insufficient funds");
 	            }
 	        }
		//method to check balance
 	 	public double checkBalance() {
 	 		return this.Balance;
 	 	}
//method to print transaction details
public String miniStatement() {
	String s = "";
	if(transactions.size() <= 5) //if less than 5 transactions return all transaction
	{
		for(int i = 0; i<transactions.size(); i++) {
			s=s+transactions.get(i) + "\n";
		}
	}else // if more than 5 transactions return last 5 transactions
	{
		int start = transactions.size() - 5;
		for(int i = start; i<transactions.size(); i++) {
			s=s+transactions.get(i) + "\n";
		}
	}
	return s;
}

}
