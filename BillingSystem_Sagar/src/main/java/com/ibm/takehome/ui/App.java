package com.ibm.takehome.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.takehome.bean.Products;
import com.ibm.takehome.service.ServiceClass;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
    	ServiceClass service = context.getBean("serviceClass", ServiceClass.class);
    	String choice = "";
    	int productId=0;
        int checktotal = 0;
        int total=0;
        int choice2=1;
        ArrayList<Products> prod = new ArrayList<Products>();
    	Scanner sc = new Scanner(System.in);
    	do {
        System.out.println( "a. Generate Bill\nb.Exit" );
    		choice=sc.nextLine();
        
	        switch(choice){
	        	case "a":
	        		do {
		        		System.out.print("Enter the Product id :\t");
		        		try {
		        		productId=sc.nextInt();
		        		sc.nextLine();
		        		}
		        		catch(InputMismatchException e)
		        		{
		        			System.out.println("Enter the right input");
		        			continue;
		        		}
		        		if(service.checkId(productId)) {
		        			int quantity;
		        			System.out.println("Enter the Quantity");
		        			try {
		        			quantity = sc.nextInt();
		        			sc.nextLine();
		        			}
		        			catch(InputMismatchException e)
		        			{
		        				System.out.println("Enter the right input");
		        				continue;
		        			}
							checktotal=total;
		        			total=service.calculate(total,productId,quantity);
		        			if(total==checktotal)
		        			{
		        				System.out.println("This item is not available");
		        				continue;
		        			}
		        			prod = service.store(productId,quantity,prod);
		        			System.out.println("Press 0 to show the bill or 1 for continue");
		        			choice2=sc.nextInt();
		        			sc.hasNextLine();
		        			
		        		}
		        		else
		        		{
		        			continue;
		        		}
	        		}while(choice2!=0);
	        		System.out.println("ID\tName\tPrice\tQuantity");
	        		for(Products product : prod)
	        		{
	        			System.out.println(product);
	        		}
	        		System.out.println("Total amount is : " + total);
	        		break;
	        	case "b":
	        		break;
	        	default:
	        		System.out.println("Invalid Choice");
	        }
        }while(choice!="b");
    }
}
