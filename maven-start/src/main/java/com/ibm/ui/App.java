package com.ibm.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.bean.Credentials;
import com.ibm.bean.Transactions;
import com.ibm.service.ServiceClass;


public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	ServiceClass service = new ServiceClass();
    	do {
    		long mobnum;
	    	System.out.println("1.Register\n2.login");
	    	choice = sc.nextInt();
	    	sc.nextLine();
	    	switch(choice) {
	    	case 1:
	    		System.out.println("Eneter the name");
	    		String name = sc.nextLine();
	    		System.out.println("Enter the Mobile number");
	    		mobnum = sc.nextLong();
	    		sc.nextLine();
	    		if(service.validateMobNum(mobnum)) {
	    			System.out.println("Mobile number already registered");
	    			choice = 1;
	    			break;
	    		}
	    		System.out.println("Set the password");
	    		String pass = sc.nextLine();
	    		System.out.println("Enter the Address");
	    		String addr = sc.nextLine();
	    		System.out.println("Enetr the initial amount");
	    		long amnt = sc.nextInt();
	    		sc.nextLine();
	    		Credentials cred = new Credentials(mobnum,pass,name,addr,amnt);
	    		service.insertData(cred);
	    		System.out.println("Account Created...");
	    		System.out.println("Press 0 for exit or 3 to continue");
	    		choice = sc.nextInt();
	    		sc.nextLine();
	    		break;
	    	case 2:
	    		while(true) {
	    		System.out.println( "Enter your mobile number" );
	            mobnum = sc.nextLong();
	            sc.nextLine();
	            if(service.validateMobNum(mobnum)) {
	            	do {
	            	System.out.println("Enter the password");
	            	pass = sc.nextLine();
	            	if(service.validatePass(mobnum,pass)) {
	            		new App().mainMenu(mobnum);
	            		choice = 0;
	            	}
	            	else {
	            		System.out.println("Incorrect Password.....try again");
	            	}
	            	}while(choice!=0);
	            	break;
	            }
	            else
	            	System.out.println("Mobile number not registered");
	    		}
	    		break;
	    	default : 
	    		System.out.println("Eneter the correct choice");
	    	}
    	}while(choice != 0);
    }

	private void mainMenu(long mobnum) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	ServiceClass service = new ServiceClass();
    	do {
		System.out.println("1.Check Balance\n2.Add Amount\n3.Widhdraw Amount\n4.Transfer to other Account\n5.Statement");
		choice = sc.nextInt();
		sc.nextLine();
		int bal;
		switch(choice) {
			case 1:
				bal = service.checkBalance(mobnum);
				System.out.println("Your Account have : "+ bal +" INR");
				break;
			case 2:
				System.out.println("Enter the amount you want to add");
				int addamnt = sc.nextInt();
				sc.nextLine();
				bal = service.addBalance(mobnum,addamnt);
				service.transactCred(mobnum,addamnt);
				System.out.println("Balance updated...\nUpdated Balance is : "+ bal + " INR");
				break;
			case 3:
				System.out.println("Enter the amount you want to withdraw");
				int withamnt = sc.nextInt();
				sc.nextLine();
				if(service.withBalance(mobnum,withamnt)) {
					service.transactDeb(mobnum,withamnt);
					System.out.println("Balance updated...\nUpdated Balance is : "+ service.checkBalance(mobnum) + " INR");
				}
				else
					System.out.println("Not sufficient amount");
				break;
			case 4:
				System.out.println("Enter the mobile number to which you want to send money");
				do {
				long mob = sc.nextLong();
				sc.nextLine();
				if(service.validateMobNum(mob)) {
					System.out.println("Enter the amount you want to send");
					do {
					int amnt = sc.nextInt();
					sc.nextLine();
					if(service.checkBalance(mobnum)>=amnt)
					{
						if(service.updateBalance(mobnum,mob,amnt)) {
							System.out.println("Funds transfered...updated balance is : " + service.checkBalance(mobnum) + " INR");
							service.transactCred(mob, amnt);
							service.transactDeb(mobnum, amnt);
						}
						break;
					}
					else
						System.out.println("Not sufficient balance in your account....enter again");
					}while(true);
					break;
				}
				else
					System.out.println("Mobile number You entered is not valid....try again");
				}while(true);
				break;
			case 5:
				ArrayList<Transactions> arr = service.state(mobnum);
				System.out.println("Number\tCredited\tDebited\tBalance\tDate and Time");
				for(Transactions trans : arr)
				{
					System.out.println(trans.getNumber() + "\t" + trans.getCredited() + "\t" + trans.getDebited() + "\t" + trans.getBalance() + "\t" + trans.getTime());
				}
				break;
			case 6: 
				break;
			default : 
				System.out.println("Invalid choice");
		}
    	}while(choice!=6);
	}
}
