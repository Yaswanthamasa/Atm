package Atm;

public class Customer {
	Account CustomerAccount;
	private String CustomerName;
	
	// Constructor with account object and name
	public Customer(Account customerAccount, String customerName) {
		super();
		CustomerAccount = customerAccount;
		CustomerName = customerName;
	}
	public String getCustomerName() {  //getter method
		return CustomerName;
	}
	public void setCustomerName(String customerName) {   //setter method
		CustomerName = customerName;
	}
	// Method for customer withdrawals and also checks if there is enough money in account to complete transaction
	public boolean Withdraw(Account account, double withdrawalAmount){	
	 double balanceAfterWithdrawal;
		boolean valid = false;
		if(withdrawalAmount<=account.getBalance()){
		balanceAfterWithdrawal = account.getBalance() - withdrawalAmount;
		account.setBalance(balanceAfterWithdrawal);
		valid = true;
		}else{
		System.out.println("Not enough balance in your account, Please choose a smaller amount!");
		valid = false;
		}
		return valid;
	}
	// Method for customer deposit
	public void Deposit(Account account, double depositedAmount){
		double balanceAfterDeposit;
		balanceAfterDeposit = account.getBalance() + depositedAmount;
		account.setBalance(balanceAfterDeposit);
	}
}