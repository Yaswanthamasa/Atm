# Atm
This program is based on a menu-driven system and the input is taken from the user in the form of numerical system                                                                 The code is distributed across 5 classes which are main,Account,Transaction,admin(for CashDispenser),ATM.                                                                                         
The instructions are given for the various input in the following order:                                                                                                           
1.First in the main it is asked that whether the atm is on or not.                                                                                                                 
2.The customer's details taken as input and we will verify the account number and pin number    
3.And the phonenumber is added to get OTP which is used as two-step verification before transaction
4.If the user enters a valid account number and the correct pin for that account,the screen displays the main menu                                                                 
5.If the user enters an invalid account number or an incorrect pin,the screen displays a message then the ATM returns to step 1 to restart the authentication process               
6.The functionalities of main are                                                                                                                                                  
i)Balance enquiry                                                                                                                                                                  
ii)withdraw amount                                                                                                                                                                 
iii)deposit amount                                                                                                                                                                 
iv)Mini Statement                                                                                                                                                                    v) Transfer amount                                                                                                                                                                 
vi)Exit                                                                                                                                                                             
I used the ArrayList for the customers transaction data and i used the admin class for Atm cash limit.                                                                             
In the withdraw option i defined the denominations of notes                                                                                                                        
Note that the OTP will come after entering the mobile number,in withdraw and deposit option Type ok if OTP is recieved
