package Atm;

import java.util.ArrayList;

public class ATM {
	
	ArrayList<Customer> customers= new ArrayList<Customer>();
	CashDispenser Dispenser;
	
	// Constructor
	public ATM(CashDispenser dispenser) {
		super();
		this.customers = new ArrayList<Customer>() ;
		Dispenser = dispenser;
	}

	// Method that validates customer pin and account to check for a match
	public boolean SignIn(int accountnumber, int pin, ArrayList<Customer> listOfcustomers){
		int customerAccountNumber;
		int customerAccountPin;
		boolean verified = false;
	
		for(int i=0; i<listOfcustomers.size(); i++){
			
			Customer cust = listOfcustomers.get(i);
			
			Account account = cust.CustomerAccount;
			
			customerAccountNumber = account.getAccountNumber();
			customerAccountPin = account.getPin();
			
			if(customerAccountNumber == accountnumber && customerAccountPin == pin){
				verified = true;
			}
		}
		return verified;
	}
}