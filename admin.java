package Atm;

public class admin {
	private double Balance;
	// Getters and Setters
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	// Constructor
	public admin(double balance) {
		super();
		Balance = balance;
	}
	// Method that checks if atm has enough money in order to complete withdrawal transaction
	public boolean DispenseMoney(double amountToDispense){
		boolean valid= false;
		if(amountToDispense<=getBalance()){
			setBalance(getBalance()-amountToDispense);
			System.out.println("Please wait while transaction is being proccessed");
			System.out.println("Please take your money!");
			valid = true;
		}else{
			System.out.println("Sorry, there is no available balance in the ATM, Please choose a smaller amount");
			valid = false;
		}
		return valid;
	}
}