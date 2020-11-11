package Atm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating cash dispenser for ATM
		admin cashdispenser1 = new admin(1000000); 
		
		ATM atm1 = new ATM(cashdispenser1);
		
	     Scanner scan = new Scanner(System.in);
	    /* List<Account> accountList = new ArrayList<>();
	     Account acct1 = new Account(12456, 54321, "7659094557", 10000.0);
	     Account acct2 = new Account(98765, 56789, "9494142062", 25000.0);
	     Account acct3 = new Account(34567,12345, "9849785784", 50000);
	     accountList.add(acct1);
	     accountList.add(acct2);
	     accountList.add(acct3);*/
	    //creating new array of 3 accounts
	     Account accounts[] = new Account[3];
	     accounts[0] = new Account(12456,54321,"7659094557",10000);  
	     accounts[1] = new Account(98765,56789, "9494142062", 25000); 
	     accounts[2] = new Account(34567,12345, "9849785784", 50000);
	     
	boolean atmOn = true;
	while(atmOn){
   	 int AccountNumber = 0;
   	 System.out.println("WELCOME");
	     // Get account number for sign in
   	 System.out.println("Please enter an account Number");

	     boolean correctInput = true;
	     
	     // Validate input
	     while(correctInput){
		     if(scan.hasNextInt()){
		    	 AccountNumber = scan.nextInt();
		    	 correctInput = false;
		     }else{
			     System.out.println("Please enter a valid account Number!");
			     scan.next();
		     }
	     }
	  // Get and validate pin entry from user
	     int Pin = 0;
	     correctInput = true;
	     System.out.println("Please enter a pin to your account");
	     while(correctInput){
		     if(scan.hasNextInt()){
		    	 Pin = scan.nextInt();
		    	 correctInput = false;
		     }else{
			     System.out.println("Please enter a valid pin to your account!");
			     scan.next();
		     }
	     }
	     // Get phoneNumber entry from user
	     String phonenumber = "";
	     correctInput =true;
	     System.out.println("Enter a phone number");
	     while(correctInput){
		     if(scan.hasNext()){
		    	 phonenumber = scan.next();
		    	 correctInput = false;
		     }else{
			     System.out.println("Please enter a valid phonenumber to your account!");
			     scan.next();
		     }
	     }
	      
	     int choice;
	  // checking and getting account if present with specific account number,pin
	     Account ac = getAccount(accounts, AccountNumber, Pin);
	
		   //if account not present
			if(ac == null) {
		     	 System.out.println("Invalid Account");	 
	     }else //if account is present
	     { //printing menu
	    	 //sending OTP
	    	 String otp = OTP();
		     System.out.println("OTP : " + otp +" is sent to your mobile");
	    	 do {  
	    		 System.out.println("Main menu\n" + "1.Balance Enquiry\n" + "2.Withdraw\n" + "3.Deposit\n" + "4.Mini Statement\n" + "5.Transfer amount\n" + "6.Exit");
	    		 //Asking user to enter choice
	    		 System.out.println("Enter your choice: ");
	    		 choice = scan.nextInt();
	    		 switch(choice) {
	    		 //if choice is 1: check balance
	    		 case 1:
	    		 {
				    		 System.out.println("Current Balance: " + ac.checkBalance());
				    		 break;
	    		 }
	    		//if choice is 2: withdraw amount
	    		 case 2:
	    		 { 
	    			 //sending OTP
	    			 String OK;
					     System.out.println("If the OTP is recieved Type OK to proceed");
					    while(true) {
					    	 OK = scan.nextLine();
					    	 if(OK.equals("ok")) { 		
					    		
	    			 System.out.println("Enter amount to Withdraw: ");
	    			 double amount = scan.nextDouble();
	    			 if(atm1.Dispenser.DispenseMoney(amount)) {
	    				 ac.withdraw(amount);
	    				 System.out.println("Successfully withdrawn amount " + amount);
	    				 System.out.println("Enter the withdrawn amount to show the denomination of notes");
	    				 // Storing all the denominations
	    				 int denNotes[] = {2000,500,200,100,50,20,10}; 
	    					int amount1=scan.nextInt();
	    			    	int tempAmount=amount1;
	    					int totalNotes=0,count=0;
	    			 
	    					System.out.println("\nDENOMINATIONS: \n");
	    			 
	    					for(int i=0;i<denNotes.length;i++)
	    					{
	    						count=amount1/denNotes[i]; // Counting number of denomination notes
	    						if(count!=0) //Print the denomination if the count is not zero
	    						{
	    							System.out.println(denNotes[i]+"\tx\t"+count+"\t= "+denNotes[i]*count);
	    						}
	    						totalNotes=totalNotes+count; //Find total number of notes
	    						amount1=amount1%denNotes[i]; //Find the remaining amount whose denomination is to be found
	    					}
	    			 
	    					System.out.println("--------------------------------");
	    					System.out.println("TOTAL\t\t\t= "+tempAmount);
	    					System.out.println("--------------------------------");
	    					System.out.println("Total Number of Notes\t= "+totalNotes);
	    				break;
		    		 }else{
		    			 // Message for invalid entry
		    			 System.out.println("Insufficient Balance in your account");
		    			 break;
		    		 }
					    	 }
					    
					    }
	    		 }break;
	    		//if choice is 3: Deposit amount
	    		 case 3:
	    		 {
	    			 String OK;
				     System.out.println("If the OTP is receieved Type OK to proceed");
				    while(true) {
				    	 OK = scan.nextLine();
				    	 if(OK.equals("ok")) {
				    		 System.out.println("Enter amount to Deposit: ");
	    			 double amount = scan.nextDouble();
	    			 ac.deposit(amount);
	    				 break;
	    		 }
				    }
	    		 }break;
	    
	    		//if choice is 4: print MiniStatement
	    		 case 4:
	    		 {
	    			 System.out.println("Mini Statement: ");
	    			 System.out.println(ac.miniStatement()); 
	    				 break;
	    		 }
	    		 case 5:
	    		 {  
	    			 
	    			 System.out.println("Enter account number to transfer: ");
	    			  int to = scan.nextInt();
	    			 System.out.println("Enter amount to Transfer: ");
	    			 double amount = scan.nextDouble();
	    				 ac.withdraw(amount);
	    			 accounts[1].deposit(amount);
		    		
	    				      
	    				  
	    		 }break;
	    		 case 6:
	    		 {
	    			 System.out.println("Thank You visit again....");
	    				 break;
	    		 }
	    		 default: // if any other choice entered
	    		 {
	    			 System.out.println("Invalid Entry.... Please try again");
	    			 break;
	    		 }
	    	 }
	    	 }while(choice != 6);   
	     }
	}
	     }
	
	/*
	 	 * Method to check account is present or not with specified account number if present return
	 	 * the account object is not present return null
	 	 */
	private static Account getAccount(Account[] accounts, int AccountNumber, int Pin) {
		// TODO Auto-generated method stub
		for(int i = 0; i<accounts.length; i++) {
			Account ac = accounts[i];
		if(ac.getAccountNumber() == AccountNumber) {
		if(ac.getPin() == Pin) 
				 return ac;
		}
		}
		
		return null;
	}
	
	/*
	 * Method for generating random OTP
	 */
	private static String OTP() {
		// TODO Auto-generated method stub
		int randomPin = (int)(Math.random()*9000)+1000;
		String otp = String.valueOf(randomPin);
		return otp;
	}
	
}