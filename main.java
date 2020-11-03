package Atm;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create accounts
		Account account1 = new Account(12456, 54321, 8000);
		Account account2 = new Account(15498, 11122, 2000);
		Account account3 = new Account(11379, 26789, 50000);

		// Create customers using accounts
		Customer customer1 = new Customer(account1, "sandeep");
		Customer customer2 = new Customer(account2, "Goutham");
		Customer customer3 = new Customer(account3, "sagar");
		
		// Creating cash dispenser for ATM
		CashDispenser cashdispenser1 = new CashDispenser(100000); 
		
		// Create ATM
		ATM atm1 = new ATM(cashdispenser1);
		
		// Adding customers to ATM
		atm1.customers.add(customer1);
		atm1.customers.add(customer2);
		atm1.customers.add(customer3);
	     Scanner scan = new Scanner(System.in);
	     // boolean to check if ATM is on
	     boolean atmOn=true;
	     
	     while(atmOn){
	    	 int accountNumber = 0;
	    	 System.out.println("WELCOME");
		     // Get account number for sign in
	    	 System.out.println("Please enter an account Number");

		     boolean correctInput = true;
		     
		     // Validate input
		     while(correctInput){
			     if(scan.hasNextInt()){
			    	 accountNumber = scan.nextInt();
			    	 correctInput = false;
			     }else{
				     System.out.println("Please enter a valid account Number!");
				     scan.next();
			     }
		     }
		     
		     // Get and validate pin entry from user
		     int pin = 0;
		     correctInput = true;
		     System.out.println("Please enter a pin to your account");
		     while(correctInput){
			     if(scan.hasNextInt()){
			    	 pin = scan.nextInt();
			    	 correctInput = false;
			     }else{
				     System.out.println("Please enter a valid pin to your account!");
				     scan.next();
			     }
		     }
		     
			// call sign in method, boolean "true" is returned if pin and account number match
		     boolean session = atm1.SignIn(accountNumber, pin, atm1.customers);
		     // While customer is logged in
		     while(session){
			     // Set active customer for session
		    	 Customer activeCustomer = null;
		    	 
		    	 for(int i=0; i<atm1.customers.size();i++){
		    		 
		 			Customer cust = atm1.customers.get(i);

		 			if(cust.CustomerAccount.getAccountNumber() == accountNumber && cust.CustomerAccount.getPin() == pin){
		 				 activeCustomer = atm1.customers.get(i);
		 			}
		    	 }
		    	 
		    	 // boolean for while loops
		    	 boolean exit = true;
		    	 boolean withdraw = false;
		    	 
		    	 // While user has not exited out of session
		    	 while(exit){
			    	 // Main menu prompt
		    		 System.out.println("Please select an option from the following\n(1)balance enquiry \n(2)withdrawal \n(3)deposit \n(4)exit ");
			    	 int chooseoption = 0;
				     
			    	 // Validate user entry 
				     correctInput = true;
				     while(correctInput){
					     if(scan.hasNextInt()){
					    	 chooseoption = scan.nextInt();
					    	 correctInput = false;
					     }else{
						     System.out.println("Please choose a valid option from the following\n(1)balance inquiry \n(2)withdrawal \n(3)deposit \n(4)exit ");
						     scan.next();
					     }

				     }
				     	// If user selects 1, show balance
			    		 if(chooseoption==1){
				    		 activeCustomer.CustomerAccount.showBalance();
				    		 exit=true;
				    	 }else if(chooseoption==2){
				    		 // if user selects 2, perform withdrawal
				    		 withdraw = false;
				    		while(withdraw == false){ 
				    			
				    		// get amount to withdraw	
				    		 System.out.println("Please select an amount to withdraw:\n(1)rs.50 \n(2)rs.100 \n(3)rs.200 \n(4)rs.500 \n(5)rs.2000 \n(6)Cancel Transaction ");
				    		 int chooseoption2 = 0;
				    		 
				    		 // validate entry
						     correctInput = true;
						     while(correctInput){
							     if(scan.hasNextInt()){
							    	 chooseoption2 = scan.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Please select a valid amount to withdraw:\n(1)rs.50 \n(2)rs.100 \n(3)rs.200 \n(4)rs.500 \n(5)rs.2000 \n(6)Cancel Transaction ");
								     scan.next();
							     }
						     }

				    		 // If statements to handle different amounts to withdraw
				    		 double amountToWithdraw = 0;
				    		 if(chooseoption2 == 1){
				    			 amountToWithdraw = 50;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWithdraw)){
				    			 withdraw = activeCustomer.Withdraw(activeCustomer.CustomerAccount, amountToWithdraw);
				    			 }
				    			 }else if(chooseoption2 == 2){
				    			 amountToWithdraw = 100;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWithdraw)){
				    			 withdraw = activeCustomer.Withdraw(activeCustomer.CustomerAccount, amountToWithdraw);
				    			 }
				    			 }else if(chooseoption2 == 3){
				    			 amountToWithdraw = 200;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWithdraw)){
				    			 withdraw = activeCustomer.Withdraw(activeCustomer.CustomerAccount, amountToWithdraw);
				    			 }
				    			 }else if(chooseoption2 == 4){
				    			 amountToWithdraw = 500;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWithdraw)){
				    			 withdraw = activeCustomer.Withdraw(activeCustomer.CustomerAccount, amountToWithdraw);
				    			 }
				    			 }else if(chooseoption2 == 5){
				    			 amountToWithdraw = 2000;
				    			 if(atm1.Dispenser.DispenseMoney(amountToWithdraw)){
					    			 withdraw = activeCustomer.Withdraw(activeCustomer.CustomerAccount, amountToWithdraw);
				    			 }
				    		
			    			 // If option 6 chosen, cancel transaction and return to menu
				    		 }else if(chooseoption2 == 6){
				    			 System.out.println("Transaction cancelled");
				    			 withdraw = true;
				    		 }else{
				    			 // Message for invalid entry
				    			 System.out.println("Invalid input!");
				    		 }
				    		 
				    	}
			    		// If the user is selected deposit
				    	 }else if(chooseoption == 3){
				    		 System.out.println("Please enter the amount to deposit in rupees");
				    		 double amounttodeposit = 0;
						     correctInput = true;
						     
						     // validating input
						     while(correctInput){
							     if(scan.hasNextInt()){
							    	 amounttodeposit = scan.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Please enter a valid amount to deposit in rupees");
								     scan.next();
							     }
						     }

				    		 double actualamount;
				    		 // if 0 entered, go back to main menu
				    		 if(amounttodeposit == 0){
				    		 }else if (amounttodeposit>0){
			    			 // If an amount is entered, perform deposit
				    		actualamount = amounttodeposit;
				    		
				    		System.out.println("Please deposit envelope! (Type 1 when envelope is deposited!)");
				    		int yes = 0;
						     
				    		// validate input
				    		correctInput = true;
						     while(correctInput){
							     if(scan.hasNextInt()){
							    	 yes = scan.nextInt();
							    	 correctInput = false;
							     }else{
								     System.out.println("Invalid number (Please Type 1 when envelope is deposited!)");
								     scan.next();
							     }
						     }

				    		// if user "deposits envelope" perform deposit of money
				    		if(yes == 1){
				    			activeCustomer.Deposit(activeCustomer.CustomerAccount, actualamount);
				    			atm1.Dispenser.setBalance(atm1.Dispenser.getBalance() + actualamount);
				    			System.out.println("Money has been deposited to the account number: " + activeCustomer.CustomerAccount.getAccountNumber());
				    		}else{
				    			// cancel the transaction if envelope not received
				    			System.out.println("No envelope received! ... Transaction Cancelled");
				    		}
				    		 }else{
				    			 // error message for invalid input
				    			 System.out.println("Invalid entry!");
				    		 }
				    		 
				    	// If exit option is selected return to log in screen	 
				    	 }else if(chooseoption == 4){
				    		 session = false;
				    		 exit = false;
				    		 
				    		 System.out.println("Thank you for your visit!");
				    	 }
				    		 else{
				    		 System.out.println("Invalid entry!");
				    	 }

		    	}	
		    	 
		     }
	     }

	}
}