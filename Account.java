package Atm;

class Account {
	 private int AccountNumber;
     private int Pin;
     private double Balance;

  // Constructor
Account(){
}

Account(int accountNumber, int pin, double balance){
	this.AccountNumber = accountNumber;
    this.Pin = pin;
    this.Balance = balance;
}
 	// Getter and Setter methods
 	public int getAccountNumber() {
 		return AccountNumber;
 	}
 	public void setAccountNumber(int accountNumber) {
 		AccountNumber = accountNumber;
 	}
 	public int getPin() {
 		return Pin;
 	}
 	public void setPin(int pin) {
 		Pin = pin;
 	}
 	public double getBalance() {
 		return Balance;
 	}
 	public void setBalance(double balance) {
 		Balance = balance;
 	}
 	// method to show the balance of customers account
 	public void showBalance(){
 		System.out.println("The balance of the account number: " + getAccountNumber() + " is: " +getBalance());
 	}
 }